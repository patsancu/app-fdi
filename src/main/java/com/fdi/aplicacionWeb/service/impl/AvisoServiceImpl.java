package com.fdi.aplicacionWeb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fdi.aplicacionWeb.domain.Aviso;
import com.fdi.aplicacionWeb.domain.repository.AvisoRepository;
import com.fdi.aplicacionWeb.service.AvisoService;

@Service	
public class AvisoServiceImpl implements AvisoService{
	@Autowired
	AvisoRepository avisoRepository;

	public List<Aviso> getAllAvisos() {
		return avisoRepository.getAllAvisos();
	}

	public Aviso getAvisoById(String avisoID) {
		return avisoRepository.getAvisoById(avisoID);
	}

	public List<Aviso> getAvisosByCategory(String category) {
		return avisoRepository.getAvisosByCategory(category);
	}

//	public List<Aviso> getAvisosByManufacturer(String manufacturer) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	public Set<Aviso> getAvisosByFilter(Map<String, List<String>> filterParams) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	public void addAviso(Aviso aviso) {
		avisoRepository.addAviso(aviso);		
	}
	
	

}
