package es.ucm.fdi.espacios.business.control;

import org.springframework.data.repository.CrudRepository;

import es.ucm.fdi.espacios.business.domain.Reserva;

public interface ReservaRepository  extends CrudRepository<Reserva, Long> {

}
