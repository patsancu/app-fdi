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

	public List<Aviso> getAvisos() {
		return avisoRepository.getAllAvisos();
	}

	public Aviso getAviso(Long avisoID) {
		return avisoRepository.getAviso(avisoID);
	}

	public List<Aviso> getAvisosByCategory(String category) {
		return avisoRepository.getAvisosByCategory(category);
	}

	public void eliminarAviso(Long avisoID) {
		avisoRepository.eliminarAviso(avisoID);
	}

	public void addAviso(Aviso aviso) {
		avisoRepository.addAviso(aviso);
	}
}
