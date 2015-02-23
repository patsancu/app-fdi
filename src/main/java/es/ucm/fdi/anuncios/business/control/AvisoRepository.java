package es.ucm.fdi.anuncios.business.control;

import java.util.List;
import java.util.Map;
import java.util.Set;

import es.ucm.fdi.anuncios.business.domain.Aviso;

public interface AvisoRepository {
	List<Aviso> getAllAvisos();

	Aviso getAviso(Long avisotID);

	List<Aviso> getAvisosByCategory(String category);

	Set<Aviso> getAvisosByFilter(Map<String, List<String>> filterParams);

	void eliminarAviso(Long avisoID);

	void addAviso(Aviso product);

	void eliminarAviso(Aviso aviso);
}
