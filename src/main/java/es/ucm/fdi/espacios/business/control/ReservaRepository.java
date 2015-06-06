/**
 * This file is part of Portal Web de la FDI.
 *
 * Portal Web de la FDI is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Portal Web de la FDI is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with Portal Web de la FDI.  If not, see <http://www.gnu.org/licenses/>.
 */
package es.ucm.fdi.espacios.business.control;

import java.util.List;

import org.joda.time.DateTime;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import es.ucm.fdi.espacios.business.entity.Espacio;
import es.ucm.fdi.espacios.business.entity.Reserva;

public interface ReservaRepository  extends CrudRepository<Reserva, Long> {
	@Query("SELECT r FROM Reserva r	WHERE	(( :inicio BETWEEN r.fechaInicio AND r.fechaFin) OR ( :fin BETWEEN r.fechaInicio AND r.fechaFin ) OR (r.fechaInicio BETWEEN :inicio AND :fin) OR (r.fechaFin BETWEEN :inicio AND :fin) )	AND (r.espacio.id = :espacio_id)")
	public List<Reserva> existeReservaCoincicente(@Param("inicio") DateTime inicio, @Param("fin") DateTime fin, @Param("espacio_id") Long espacio_id);
	
	
	@Query("SELECT DISTINCT r.espacio FROM Reserva r")
	public List<Espacio> espaciosUsados();
}
