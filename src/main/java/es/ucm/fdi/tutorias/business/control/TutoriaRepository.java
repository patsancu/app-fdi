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
