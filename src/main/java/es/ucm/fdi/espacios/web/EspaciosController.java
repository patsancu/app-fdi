package es.ucm.fdi.espacios.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import es.ucm.fdi.espacios.business.boundary.Espacios;
import es.ucm.fdi.espacios.business.entity.Espacio;
import es.ucm.fdi.espacios.business.entity.TipoEspacioEnum;
import es.ucm.fdi.espacios.validation.EspacioValidator;
import es.ucm.fdi.util.Constants;

@Controller
public class EspaciosController {
	private static final Logger logger = LoggerFactory.getLogger("es.ucm.fdi.espacios");
	
	@Autowired
	private Espacios espacios;
	
	@Autowired
	private EspacioValidator espacioValidator;
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(method = RequestMethod.GET, value = Constants.URL_NUEVO_ESPACIO)
	public ModelAndView nuevoEspacio() {
		Map<String, Object> model = new HashMap<>();
		model.put("modo", "Crear");
		model.put("method", "POST");
		model.put("espacio", new Espacio() );
		model.put("tiposEspacios", TipoEspacioEnum.values());
		return new ModelAndView("editorEspacios", model);		
	}
	
	@RequestMapping(method = RequestMethod.POST, value = Constants.URL_NUEVO_ESPACIO)
	public ModelAndView creaNuevaEspacio(@ModelAttribute("espacio") @Validated  Espacio espacio,
			BindingResult result) throws IOException {
		logger.warn("Creando espacio: " + espacio);
		Map<String, Object> model = new HashMap<>();
		
		if (result.hasErrors()){		
				logger.debug("Ha habido errores ");
				logger.debug(result.getAllErrors().toString());
			
			model.put("modo", "Crear");
			model.put("method", "POST");
			model.put("espacio", espacio);
			return new ModelAndView("editorEspacios", model);
		}
		
		String[] suppressedFields = result.getSuppressedFields();
		if (suppressedFields.length > 0) {
			logger.error("Attempting to bind disallowed fields: "
					+ StringUtils.arrayToCommaDelimitedString(suppressedFields));
			throw new RuntimeException("Attempting to bind disallowed fields: "
					+ StringUtils.arrayToCommaDelimitedString(suppressedFields));
		}
		
		
		espacios.addEspacio(espacio);

		return new ModelAndView("redirect:/espacios", model);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = Constants.URL_LISTAR_ESPACIOS)
	public ModelAndView listarEspacios(HttpServletRequest request){
		List<Espacio> listaEspacios = espacios.listarEspacios();
		logger.warn("Listando " + listaEspacios.size() + " espacios:");
		Map<String, Object> model = new HashMap<>();
		
		model.put("espacios", listaEspacios);
		model.put("deleteAction", request.getContextPath()+"/espacios");
		
		
		return new ModelAndView("listarEspacios", model);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = Constants.URL_ESPACIO_INDIVIDUAL)
	public ModelAndView editarEspacio(@PathVariable("id") Long espacioId){
		Map<String, Object> model = new HashMap<>();
		model.put("modo", "Editar");
		model.put("method", "PUT");
		model.put("espacio", espacios.getEspacio(espacioId));		
		
		return new ModelAndView("editorEspacios", model);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = Constants.URL_ESPACIO_INDIVIDUAL)
	public String actualizaEspacios(@PathVariable("id") Long espacioId, @ModelAttribute("espacio") Espacio espacio,
			BindingResult result, HttpServletRequest request){
		logger.debug("Actualizando espacio:" + espacio);
		
		espacio.setId(espacioId);
		espacios.actualizaEspacio(espacio);
		
		return "redirect:/espacios";
	}
	
	
	@RequestMapping(method=RequestMethod.DELETE , value = Constants.URL_ESPACIO_INDIVIDUAL)
	public String eliminarEspacio(@PathVariable("id") Long espacioID) throws IOException {
		espacios.eliminar(espacioID);
		return "redirect:/espacios";
	}
	
	@InitBinder
	public void initialiseBinder(WebDataBinder binder) {
		binder.setValidator(espacioValidator);
		binder.setDisallowedFields("id");
	}
	
}
