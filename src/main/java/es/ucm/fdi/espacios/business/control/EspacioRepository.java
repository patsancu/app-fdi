package es.ucm.fdi.espacios.business.control;

import java.util.List;

import es.ucm.fdi.espacios.business.domain.Espacio;


//public interface EspacioRepository extends CrudRepository<Espacio, Integer>{
//	
//}

public interface EspacioRepository {

	List<Espacio> findAll();

	void save(Espacio espacio);
	
	Espacio getEspacio(Long espacioID);

	void eliminar(Long espacioID);
	
}
