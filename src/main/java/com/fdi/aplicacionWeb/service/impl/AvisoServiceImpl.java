package com.fdi.aplicacionWeb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fdi.aplicacionWeb.domain.Aviso;
import com.fdi.aplicacionWeb.domain.repository.AvisoRepository;
import com.fdi.aplicacionWeb.service.AvisoService;

@Transactional
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

	public void eliminarAviso(String avisoID){
		avisoRepository.eliminarAviso(avisoID);
	}

	@Transactional
	public void addAviso(Aviso aviso) {
		avisoRepository.addAviso(aviso);		
	}

	public void incrementarVisitas(String avisoID){
		avisoRepository.incrementarVisitas(avisoID);
	}


}
