package es.ucm.fdi.avisos.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import es.ucm.fdi.avisos.boundary.Avisos;
import es.ucm.fdi.avisos.business.entity.Aviso;
import es.ucm.fdi.avisos.business.entity.AvisoBuilder;
import es.ucm.fdi.avisos.util.CustomRssViewer;
import es.ucm.fdi.avisos.validation.AvisoValidator;

@Controller
public class AvisosController {

	private static final Logger logger = LoggerFactory
			.getLogger("es.ucm.fdi.avisos");
	
	@Autowired
	private Avisos avisoService;
	
	@Autowired 
	private AvisoValidator avisoValidator;

	@RequestMapping(method = RequestMethod.GET, value = "/avisos")
	public ModelAndView listarAvisos(HttpServletRequest request) {
		Map<String, Object> model = new HashMap<>();
		model.put("avisos", avisoService.getAvisos());
		model.put("deleteAction", request.getContextPath()+"/avisos");
		return new ModelAndView("listarAvisos", model);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/avisos/{id}/ver")
	public String avisoIndividual(@PathVariable("id") Long avisoID,
			Model model) {
		model.addAttribute(avisoService.getAviso(avisoID));
		return "verAviso";
	}

	@RequestMapping(method = RequestMethod.GET, value = "/avisos/feed", produces = "application/xml")
	public ModelAndView rssVisor() {
		Iterable<Aviso> items = avisoService.getAvisos();
		return new ModelAndView(new CustomRssViewer(), "feedContent", items);
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(method = RequestMethod.GET, value = "/avisos/nuevo")
	public ModelAndView nuevoAviso() {
		Map<String, Object> model = new HashMap<>();
		model.put("modo", "Crear");
		model.put("method", "POST");
		model.put("aviso", new AvisoBuilder());
		return new ModelAndView("editorAvisos", model);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/avisos/nuevo")
	public ModelAndView creaNuevoAviso(@ModelAttribute("aviso") AvisoBuilder aviso,
			BindingResult result) throws IOException {
		logger.debug("Creando aviso: " + aviso);
		Map<String, Object> model = new HashMap<>();

		if (aviso.getComienzoPublicacion().isAfter(aviso.getFinPublicacion()) || result.hasErrors()){			
			if ( result.hasErrors()){
				logger.debug("Ha habido errores ");
				logger.debug(result.getAllErrors().toString());
			}
			else{
				logger.debug("Fecha comienzo " + aviso.getComienzoPublicacion() + " > " + aviso.getFinPublicacion() + "Fecha fin");
				
			}
			model.put("modo", "Crear");
			model.put("method", "POST");
			model.put("aviso", aviso);
			return new ModelAndView("editorAvisos", model);
		}
		
		String[] suppressedFields = result.getSuppressedFields();
		if (suppressedFields.length > 0) {
			logger.error("Attempting to bind disallowed fields: "
					+ StringUtils.arrayToCommaDelimitedString(suppressedFields));
			throw new RuntimeException("Attempting to bind disallowed fields: "
					+ StringUtils.arrayToCommaDelimitedString(suppressedFields));
		}

		avisoService.addAviso(aviso);

		return new ModelAndView("redirect:/avisos", model);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/avisos/{id}")
	public ModelAndView editarAviso(@PathVariable("id") Long avisoID) {
		Map<String, Object> model = new HashMap<>();
		model.put("modo", "Editar");
		model.put("method", "PUT");
		AvisoBuilder avisoForm = new AvisoBuilder();
		Aviso aviso = avisoService.getAviso(avisoID);
		BeanUtils.copyProperties(aviso, avisoForm);
		model.put("aviso", avisoForm);
		return new ModelAndView("editorAvisos", model);
	}
	
	@RequestMapping(method=RequestMethod.DELETE , value="/avisos/{id}")
	public String eliminarAviso(@PathVariable("id") Long avisoID) throws IOException {
		avisoService.eliminarAviso(avisoID);
		return "redirect:/avisos";
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/avisos/{id}")
	public String actualizarAviso(@PathVariable("id") Long avisoID, @ModelAttribute("aviso") AvisoBuilder aviso,
			BindingResult result, HttpServletRequest request) throws IOException {

		logger.debug("Actualizando aviso: " + aviso);
		if (result.hasErrors()) {
			logger.debug(result.getAllErrors().toString());
			return "nuevo";
		}
		String[] suppressedFields = result.getSuppressedFields();
		if (suppressedFields.length > 0) {
			logger.error("Attempting to bind disallowed fields: "
					+ StringUtils.arrayToCommaDelimitedString(suppressedFields));
			throw new RuntimeException("Attempting to bind disallowed fields: "
					+ StringUtils.arrayToCommaDelimitedString(suppressedFields));
		}
		aviso.setId(avisoID);
		avisoService.actualizaAviso(aviso);
	
		return "redirect:/avisos";
	}
	
	
	@InitBinder
	public void initialiseBinder(WebDataBinder binder) {
		binder.setValidator(avisoValidator);
		binder.setDisallowedFields("id");
	}
}
