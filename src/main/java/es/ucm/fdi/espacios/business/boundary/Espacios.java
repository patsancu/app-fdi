/**
 * This file is part of Portal Web de la FDI.
 *
 * Portal Web de la FDI is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Portal Web de la FDI is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with Portal Web de la FDI.  If not, see <http://www.gnu.org/licenses/>.
 */
package es.ucm.fdi.espacios.business.boundary;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.ucm.fdi.espacios.business.control.EspacioRepository;
import es.ucm.fdi.espacios.business.entity.Espacio;

@Service
@Transactional
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
		Espacio espacioExistente = espacioRepository.findOne(espacio.getId());
		BeanUtils.copyProperties(espacio, espacioExistente);
		espacioRepository.save(espacioExistente);		
	}
	
	public Espacio getEspacio(Long idEspacio){
		return espacioRepository.findOne(idEspacio);
	}

	public void eliminar(Long espacioID) {
		espacioRepository.delete(espacioID);		
	}
}
