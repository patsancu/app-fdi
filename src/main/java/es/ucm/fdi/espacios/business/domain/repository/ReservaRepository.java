package es.ucm.fdi.espacios.business.domain.repository;

import java.util.List;

import es.ucm.fdi.espacios.business.domain.Reserva;

public interface ReservaRepository {
	List<Reserva> findAll();

	void save(Reserva reserva);

	Reserva getReserva(Long reservaID);

	void eliminar(Reserva reserva);
}
