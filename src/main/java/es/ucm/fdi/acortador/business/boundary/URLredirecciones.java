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
package es.ucm.fdi.acortador.business.boundary;

import java.util.List;

import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.ucm.fdi.acortador.business.control.URLredireccionRepository;
import es.ucm.fdi.acortador.business.entity.URLredireccion;
import es.ucm.fdi.acortador.business.entity.URLredireccionBuilder;
import es.ucm.fdi.acortador.util.AcortadorURL;
import es.ucm.fdi.users.business.entity.User;

@Transactional("portalTransactionManager")
@Service
public class URLredirecciones {
	@Autowired
	URLredireccionRepository repository;
	
	private static final Logger logger = LoggerFactory.getLogger("es.ucm.fdi.acortador");
	
	public URLredireccion addURLredireccion(URLredireccion urlRedireccion){
		return repository.save(urlRedireccion);
	}
	
	public URLredireccion addURLredireccion(URLredireccionBuilder builder){
		URLredireccion redireccion = builder.build();
		redireccion.setInterna(AcortadorURL.esUrlInterna(builder.getUrl()));
		
		/*
		 * Si la URL no empieza por http (o https),
		 * spring la toma como interna y no funciona como debiera. 
		 */ 
		if (! builder.getUrl().startsWith("http")){
			redireccion.setUrlOriginal("http://"+ builder.getUrl());
		}
		else{
			redireccion.setUrlOriginal(builder.getUrl());
		}
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    User creador = (User)auth.getPrincipal();
	    
	    redireccion.setCreador(creador);		
		
		redireccion = repository.save(redireccion);
		
		Long id = redireccion.getId();
		redireccion.setSufijo(AcortadorURL.generarHashId(id));
		
		logger.debug(redireccion.getSufijo());

		repository.save(redireccion);
		
		return redireccion;
		
	}

	
	public URLredireccion obtenerRedireccion(String sufijo){
		URLredireccion urlRedir = repository.findBySufijo(sufijo);
		return urlRedir;
	}
	
	public List<URLredireccion> obtenerRedirecciones(){
		return (List<URLredireccion>) repository.findAll();
	}

}
