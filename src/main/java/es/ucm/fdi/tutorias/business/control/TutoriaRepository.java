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
package es.ucm.fdi.tutorias.business.control;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import es.ucm.fdi.tutorias.business.entity.Tutoria;

@Transactional
public interface TutoriaRepository extends CrudRepository<Tutoria, Long>{
	@Query("SELECT t FROM Tutoria t WHERE (t.destinatario.id = :userId) OR (t.emisor.id = :userId)")
	List<Tutoria> tutoriasDeUsuario(@Param("userId") Long userId);
	
	@Modifying
	@Query("UPDATE Tutoria SET confirmada = true WHERE id=:userId")
	void confirmarTutoria(@Param("userId") Long userId);
}
