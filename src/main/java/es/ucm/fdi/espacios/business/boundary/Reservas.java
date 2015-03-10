package es.ucm.fdi.espacios.business.boundary;

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

import es.ucm.fdi.espacios.business.control.ReservaRepository;
import es.ucm.fdi.espacios.business.entity.Espacio;
import es.ucm.fdi.espacios.business.entity.Reserva;
import es.ucm.fdi.espacios.business.entity.ReservaBuilder;

@Service
@Transactional
public class Reservas {
	@Autowired
	ReservaRepository reservaRepository;
	
	@Autowired
	Espacios espacios;

	private static final Logger logger = LoggerFactory.getLogger("es.ucm.fdi.espacios");


	public boolean addReserva(ReservaBuilder builder){
		boolean coincidente = ! reservaRepository.existeReservaCoincicente(builder.getFechaInicio(), builder.getFechaFin(), builder.getId_espacio()).isEmpty();
		String existeReserva = ( coincidente  ? "Si" : "No");			
		logger.warn("Existe reserva coincidente? " + existeReserva );
		if (coincidente){			
			return false;
		}
		
		if (builder.getFechaCreacion() ==  null) {
			builder.setFechaCreacion(DateTime.now());
		}
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String titularReserva = auth.getName();
		
		Reserva reserva = builder.build();
		reserva.setTitular(titularReserva);
		
		Espacio espacio = espacios.getEspacio(builder.getId_espacio());
	
		reserva.setEspacio(espacio);		
		
		reservaRepository.save(reserva);
		return true;
	}

	public List<Reserva> listReservas(){
		return (List<Reserva>) reservaRepository.findAll();
	}

	public void eliminar(Long espacioID) {
		reservaRepository.delete(espacioID);
	}

	public Reserva getReserva(Long reservaId) {
		return reservaRepository.findOne(reservaId);
	}

	public void actualiza(ReservaBuilder reserva) {
		Reserva nuevaReserva = reserva.build();		
		Reserva reservaExistente = reservaRepository.findOne(reserva.getId());
		//ignores the "titular" field, since it's not defined in ReservaBuilder
		BeanUtils.copyProperties(nuevaReserva, reservaExistente, "titular"); 	
		
		Espacio espacio = espacios.getEspacio(reserva.getId_espacio());
		
		reservaExistente.setEspacio(espacio);
		
		reservaRepository.save(reservaExistente);
		
	}
	
	public List<Espacio> espaciosUsados(){
		return reservaRepository.espaciosUsados();
	}

}
