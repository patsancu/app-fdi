package es.ucm.fdi.espacios.business.control;

import org.springframework.data.repository.CrudRepository;

import es.ucm.fdi.espacios.business.entity.Espacio;

public interface EspacioRepository extends CrudRepository<Espacio, Long> {
	
}
