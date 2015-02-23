package es.ucm.fdi.espacios.business;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.ucm.fdi.espacios.business.domain.Espacio;
import es.ucm.fdi.espacios.business.domain.repository.EspacioRepository;

@Service
@Transactional//(value="espaciosTransactionManager")
public class Espacios {
	@Autowired
	EspacioRepository espacioRepository;
	
	private static final Logger logger = LoggerFactory.getLogger("es.ucm.fdi.espacios");

	public void addEspacio(Espacio espacio){
		espacioRepository.save(espacio);
	}
	
	public List<Espacio> listarEspacios(){
		return (List<Espacio>) espacioRepository.findAll();
	}

	public void actualizaEspacio(Espacio espacio){
		Espacio espacioExistente = espacioRepository.getEspacio(espacio.getId());
		BeanUtils.copyProperties(espacio, espacioExistente);
		espacioRepository.save(espacioExistente);		
	}
	
	public Espacio getEspacio(Long idEspacio){
		return espacioRepository.getEspacio(idEspacio);
	}

	public void eliminar(Long espacioID) {
		espacioRepository.eliminar(espacioID);		
	}
}
