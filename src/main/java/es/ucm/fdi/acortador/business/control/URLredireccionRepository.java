package es.ucm.fdi.acortador.business.control;

import org.springframework.data.repository.CrudRepository;

import es.ucm.fdi.acortador.business.entity.URLredireccion;

public interface URLredireccionRepository extends CrudRepository<URLredireccion, Long>{
	public URLredireccion findBySufijo(String sufijo);
}
