package es.ucm.fdi.espacios.business;

import java.util.List;

import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.ucm.fdi.espacios.business.domain.Espacio;
import es.ucm.fdi.espacios.business.domain.Reserva;
import es.ucm.fdi.espacios.business.domain.ReservaBuilder;
import es.ucm.fdi.espacios.business.domain.repository.EspacioRepository;
import es.ucm.fdi.espacios.business.domain.repository.ReservaRepository;

@Service
@Transactional
public class Reservas {
	@Autowired
	ReservaRepository reservaRepository;
	
	@Autowired
	EspacioRepository espacioRepository;

	private static final Logger logger = LoggerFactory.getLogger("es.ucm.fdi.espacios");


	public void addReserva(ReservaBuilder builder){
		if (builder.getFechaCreacion() ==  null) {
			builder.setFechaCreacion(DateTime.now());
		}
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String titularReserva = auth.getName();
		
		Reserva reserva = builder.build();
		reserva.setTitular(titularReserva);
		
		Espacio espacio = espacioRepository.getEspacio(builder.getId_espacio());
	
		reserva.setEspacio(espacio);
		
		reservaRepository.save(reserva);
	}

	public List<Reserva> listReservas(){
		return (List<Reserva>) reservaRepository.findAll();
	}

}
