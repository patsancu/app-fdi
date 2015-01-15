package es.ucm.fdi.anuncios.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.ucm.fdi.anuncios.business.domain.Aviso;
import es.ucm.fdi.anuncios.business.domain.repository.AvisoRepository;

@Transactional
@Service
public class Avisos {
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

	public void addAviso(Aviso aviso) {
		avisoRepository.addAviso(aviso);		
	}

	public void incrementarVisitas(String avisoID){
		avisoRepository.incrementarVisitas(avisoID);
	}
}
