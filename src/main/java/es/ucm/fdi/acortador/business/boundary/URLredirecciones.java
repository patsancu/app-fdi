package es.ucm.fdi.acortador.business.boundary;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.ucm.fdi.acortador.business.control.URLredireccionRepository;
import es.ucm.fdi.acortador.business.entity.URLredireccion;
import es.ucm.fdi.acortador.business.entity.URLredireccionBuilder;
import es.ucm.fdi.acortador.util.AcortadorURL;

@Transactional("portalTransactionManager")
@Service
public class URLredirecciones {
	@Autowired
	URLredireccionRepository repository;
	
	public URLredireccion addURLredireccion(URLredireccionBuilder builder){
		URLredireccion redireccion = builder.build();
		redireccion.setInterna(AcortadorURL.esUrlInterna(builder.getUrl()));
		redireccion.setUrlOriginal(builder.getUrl());
		redireccion = repository.save(redireccion);
		
		Long id = redireccion.getId();
		redireccion.setSufijo(AcortadorURL.generarHashId(id));
		
		// Por defecto, la redirección caduca en una semana desde que se creó la redirección
		if ( builder.getCaducidad() == null){
			builder.setCaducidad(DateTime.now().plusWeeks(1));
		}
		repository.save(redireccion);
		
		return redireccion;
		
	}

	
	public URLredireccion obtenerRedireccion(String sufijo){
		URLredireccion urlRedir = repository.findBySufijo(sufijo);
		return urlRedir;
	}

}
