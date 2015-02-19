package es.ucm.fdi.espacios.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import es.ucm.fdi.espacios.business.Espacios;
import es.ucm.fdi.espacios.business.domain.Espacio;
import es.ucm.fdi.espacios.business.domain.TipoEspacioEnum;

@Controller
public class EspaciosController {
	private static final Logger logger = LoggerFactory.getLogger("es.ucm.fdi.espacios");
	
	@Autowired
	private Espacios espacios;
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(method = RequestMethod.GET, value = "/espacios/nuevo")
	public ModelAndView nuevoEspacio() {
		Map<String, Object> model = new HashMap<>();
		model.put("modo", "Crear");
		model.put("method", "POST");
		model.put("espacio", new Espacio() );
		model.put("tiposEspacios", TipoEspacioEnum.values());
		return new ModelAndView("editorEspacios", model);		
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/espacios/nuevo")
	public ModelAndView creaNuevaEspacio(@ModelAttribute("espacio") Espacio espacio,
			BindingResult result) throws IOException {
		logger.debug("Creando espacio: " + espacio);
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

		return new ModelAndView("redirect:/", model);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/espacios/")
	public ModelAndView listarEspacios(){
		logger.debug("Listando espacios:");
		Map<String, Object> model = new HashMap<>();
		
		model.put("espacios", espacios.listarEspacios());
		
		return new ModelAndView("listarEspacios", model);
	}
}
