package es.ucm.fdi.tutorias.business.control;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import es.ucm.fdi.tutorias.business.entity.Tutoria;

public interface TutoriaRepository extends CrudRepository<Tutoria, Long>{
	@Query("SELECT t FROM Tutoria t WHERE (t.destinatario.id = :userId) OR (t.emisor.id = :userId)")
	List<Tutoria> tutoriasDeUsuario(@Param("userId") Long userId);
}
