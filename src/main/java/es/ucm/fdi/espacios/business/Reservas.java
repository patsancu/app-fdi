package es.ucm.fdi.espacios.business;

import java.util.List;

import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.ucm.fdi.espacios.business.control.EspacioRepository;
import es.ucm.fdi.espacios.business.control.ReservaRepository;
import es.ucm.fdi.espacios.business.domain.Espacio;
import es.ucm.fdi.espacios.business.domain.Reserva;
import es.ucm.fdi.espacios.business.domain.ReservaBuilder;

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

	public void eliminar(Long espacioID) {
		Reserva reserva = reservaRepository.getReserva(espacioID);
		
		reservaRepository.eliminar(reserva);
		
	}

	public Reserva getReserva(Long reservaId) {
		return reservaRepository.getReserva(reservaId);
	}

	public void actualiza(ReservaBuilder reserva) {
		Reserva nuevaReserva = reserva.build();		
		Reserva reservaExistente = reservaRepository.getReserva(reserva.getId());
		//ignores the "titular" field, since it's not defined in ReservaBuilder
		BeanUtils.copyProperties(nuevaReserva, reservaExistente, "titular"); 	
		
		Espacio espacio = espacioRepository.getEspacio(reserva.getId_espacio());
		
		reservaExistente.setEspacio(espacio);
		
		reservaRepository.save(reservaExistente);
		
	}

}
