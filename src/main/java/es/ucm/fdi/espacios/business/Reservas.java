package es.ucm.fdi.espacios.business;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.ucm.fdi.espacios.business.domain.Reserva;
import es.ucm.fdi.espacios.business.domain.repository.ReservaRepository;

@Service
//@Transactional("reservasTransactionManager")
@Transactional
public class Reservas {
	@Autowired
	ReservaRepository reservaRepository;

	private static final Logger logger = LoggerFactory.getLogger("es.ucm.fdi.espacios");


	public void addReserva(Reserva reserva){
		reservaRepository.save(reserva);
	}

	public List<Reserva> listReservas(){
		return (List<Reserva>) reservaRepository.findAll();
	}

}
