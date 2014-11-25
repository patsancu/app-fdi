package com.fdi.aplicacionWeb.service;

import java.util.List;

import com.fdi.aplicacionWeb.domain.Aviso;

public interface AvisoService {
	List <Aviso> getAllAvisos();
	Aviso getAvisoById(String avisoID);
	List<Aviso> getAvisosByCategory(String category);
//	List<Aviso> getAvisosByManufacturer(String manufacturer);
//	Set<Aviso> getAvisosByFilter(Map<String, List<String>> filterParams);
	void addAviso(Aviso aviso);
	void eliminarAviso(String avisoID);
}
