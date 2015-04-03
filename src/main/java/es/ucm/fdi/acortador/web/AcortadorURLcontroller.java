package es.ucm.fdi.acortador.web;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import es.ucm.fdi.acortador.business.boundary.URLredirecciones;
import es.ucm.fdi.acortador.business.entity.URLredireccion;
import es.ucm.fdi.acortador.business.entity.URLredireccionBuilder;

@Controller
public class AcortadorURLcontroller {
	private static final Logger logger = LoggerFactory.getLogger("es.ucm.fdi.acortador");

	private static final String URL_REDIRECCIONES = "/u";
	private static final String URL_NUEVA_REDIRECCION = "/urls/nueva";
	private static final String URL_REST_NUEVA_REDIRECCION = "/urls/rest/nueva";
	
	@Autowired
	URLredirecciones urlRedirecciones;

	@RequestMapping(value = URL_REDIRECCIONES + "/{sufijo}", method = RequestMethod.GET)
	public ModelAndView redirigir(@PathVariable("sufijo") String sufijo){
		Map<String, Object> model = new HashMap<>();
		URLredireccion urlRedireccion = urlRedirecciones.obtenerRedireccion(sufijo);
		String urlOriginal = urlRedireccion.getUrlOriginal();
		
		if (! urlRedireccion.isInterna()){
			model.put("urlRedireccion", urlOriginal);
			return new ModelAndView("temporal", model );
		}
		return new ModelAndView("redirect:" + urlOriginal, model);		
	}
	

	@RequestMapping(value = URL_NUEVA_REDIRECCION, method = RequestMethod.GET)
	public ModelAndView crearNuevoAcortador(HttpServletRequest request){
		logger.warn("Se quiere crear una redirección");
		Map<String, Object> model = new HashMap<>();
		model.put("urlEnvio", URL_REST_NUEVA_REDIRECCION );
		model.put("urlReenvios", URL_REDIRECCIONES);

		return new ModelAndView("editorRedireccion", model);
	}
	
	@RequestMapping(value = URL_NUEVA_REDIRECCION, method = RequestMethod.POST)
	public ModelAndView nuevoAcortador(URLredireccionBuilder URLredireccionBuilder, HttpServletRequest request){
		Map<String, Object> model = new HashMap<>();
		URLredireccion redireccion = urlRedirecciones.addURLredireccion(URLredireccionBuilder);
		logger.warn("Sufijo:" + redireccion.getSufijo());
		model.put("urlOriginal", redireccion.getUrlOriginal());
		model.put("urlCorta",  URL_REDIRECCIONES + redireccion.getSufijo());
		
		return new ModelAndView("mostrarAbreviatura",model);
	}
	
	@RequestMapping(value = URL_REST_NUEVA_REDIRECCION, method = RequestMethod.POST)
	public  @ResponseBody URLredireccion nuevoAcortadorREST(@RequestBody final URLredireccionBuilder urlRedireccion){
		logger.warn("La url es:" + urlRedireccion.getUrl());
		URLredireccion redireccion = urlRedirecciones.addURLredireccion(urlRedireccion);
		logger.warn("Sufijo:" + redireccion.getSufijo());
		return redireccion;		
	}

}
