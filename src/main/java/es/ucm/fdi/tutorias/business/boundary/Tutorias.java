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
package es.ucm.fdi.tutorias.business.boundary;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.ucm.fdi.tutorias.business.control.TutoriaRepository;
import es.ucm.fdi.tutorias.business.entity.Tutoria;
import es.ucm.fdi.tutorias.business.entity.TutoriaBuilder;
import es.ucm.fdi.users.business.boundary.UsersManager;
import es.ucm.fdi.users.business.control.UserRepository;
import es.ucm.fdi.users.business.entity.User;


@Transactional("portalTransactionManager")
@Service
public class Tutorias {
	private static final Logger logger = LoggerFactory.getLogger("es.ucm.fdi.tutorias");
	
	@Autowired
	TutoriaRepository tutoriaRepository; 
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UsersManager usersManager;
	
	public Iterable<Tutoria> getTutorias() {
		logger.warn(tutoriaRepository.findAll().toString());
		return tutoriaRepository.findAll();
	}
	
	public Iterable<Tutoria> getTutoriasForUser(Long idUser) {
		logger.warn("Buscando tutorías para usuario con id " + idUser + ":" + tutoriaRepository.tutoriasDeUsuario(idUser).toString());
		return tutoriaRepository.tutoriasDeUsuario(idUser);
	}
	
	public Tutoria getTutoria(Long tutoriaId){
		return tutoriaRepository.findOne(tutoriaId);
	}
	
	public Tutoria addTutoria(TutoriaBuilder tutoriaBuilder){
		Tutoria tutoria = tutoriaBuilder.build();
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    User emisor = (User)auth.getPrincipal();
	    tutoria.setEmisor(emisor);
	    
	    User receptor = (User)usersManager.loadUserByUsername(tutoriaBuilder.getDestinatarioUsername());
	    tutoria.setDestinatario(receptor);
	    
		return tutoriaRepository.save(tutoria);
	}
	
	public void confirmarTutoria(String id){
		tutoriaRepository.confirmarTutoria(Long.parseLong(id));
	}

}
