package es.ucm.fdi.espacios.business.control;

import java.util.List;

import org.joda.time.DateTime;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import es.ucm.fdi.espacios.business.entity.Espacio;
import es.ucm.fdi.espacios.business.entity.Reserva;

public interface ReservaRepository  extends CrudRepository<Reserva, Long> {
	@Query("SELECT r FROM Reserva r WHERE (( :inicio BETWEEN r.fechaInicio AND r.fechaFin) OR ( :fin BETWEEN r.fechaInicio AND r.fechaFin )) AND (r.espacio.id = :espacio_id)")
	public List<Reserva> existeReservaCoincicente(@Param("inicio") DateTime inicio, @Param("fin") DateTime fin, @Param("espacio_id") Long espacio_id);
	
	@Query("SELECT DISTINCT r.espacio FROM Reserva r")
	public List<Espacio> espaciosUsados();
}
