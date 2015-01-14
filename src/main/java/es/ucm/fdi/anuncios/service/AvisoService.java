package es.ucm.fdi.anuncios.service;

import java.util.List;

import es.ucm.fdi.anuncios.domain.Aviso;

public interface AvisoService {
	List <Aviso> getAllAvisos();
	Aviso getAvisoById(String avisoID);
	List<Aviso> getAvisosByCategory(String category);
//	List<Aviso> getAvisosByManufacturer(String manufacturer);
//	Set<Aviso> getAvisosByFilter(Map<String, List<String>> filterParams);
	void addAviso(Aviso aviso);
	void eliminarAviso(String avisoID);
	void incrementarVisitas(String avisoID);
}
