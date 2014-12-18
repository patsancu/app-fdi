package com.fdi.aplicacionWeb.domain.repository;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.fdi.aplicacionWeb.domain.Aviso;

public interface AvisoRepository {
	List <Aviso> getAllAvisos();
	Aviso getAvisoById(String avisotID);	
	List<Aviso> getAvisosByCategory(String category);
	Set<Aviso> getAvisosByFilter(Map<String, List<String>> filterParams);
	//List <Aviso> getAvisosByManufacturer(String manufacturer);
	void eliminarAviso(String avisoID);
	void addAviso(Aviso product);
	void incrementarVisitas(String avisoID);
}
