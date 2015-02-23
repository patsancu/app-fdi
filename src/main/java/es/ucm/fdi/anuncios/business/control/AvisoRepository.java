package es.ucm.fdi.anuncios.business.control;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import es.ucm.fdi.anuncios.business.entity.Aviso;

public interface AvisoRepository extends CrudRepository<Aviso, Long> {
	public List<Aviso> findByEtiqueta(String etiqueta);
}
