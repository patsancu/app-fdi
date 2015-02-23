package es.ucm.fdi.avisos.business.control;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import es.ucm.fdi.avisos.business.entity.Aviso;

public interface AvisoRepository extends CrudRepository<Aviso, Long> {
	public List<Aviso> findByEtiqueta(String etiqueta);
}
