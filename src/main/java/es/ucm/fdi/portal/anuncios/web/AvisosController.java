package es.ucm.fdi.portal.anuncios.web;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import es.ucm.fdi.anuncios.business.Avisos;
import es.ucm.fdi.anuncios.business.domain.Aviso;
import es.ucm.fdi.anuncios.util.CustomRssViewer;

@Controller
public class AvisosController {

	private static final Logger logger = LoggerFactory
			.getLogger("es.ucm.fdi.avisos");
	
	@Autowired
	private Avisos avisoService;

	@RequestMapping(method = RequestMethod.GET, value = "/avisos")
	public ModelAndView listarAvisos(HttpServletRequest request) {
		Map<String, Object> model = new HashMap<>();
		model.put("avisos", avisoService.getAvisos());
		model.put("deleteAction", request.getContextPath()+"/avisos");
		return new ModelAndView("listarAvisos", model);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/aviso/{id}")
	public String avisoIndividual(@PathVariable("id") Long avisoID,
			Model model) {
		model.addAttribute(avisoService.getAviso(avisoID));
		return "verAviso";
	}

	@RequestMapping(method = RequestMethod.GET, value = "/avisos/feed", produces = "application/xml")
	public ModelAndView rssVisor() {
		List<Aviso> items = new ArrayList<Aviso>();
		items = avisoService.getAvisos();
		return new ModelAndView(new CustomRssViewer(), "feedContent", items);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/avisos/nuevo")
	public ModelAndView nuevoAviso() {
		Map<String, Object> model = new HashMap<>();
		model.put("modo", "Crear");
		model.put("method", "POST");
		model.put("aviso", new AvisoFormBean());
		return new ModelAndView("editorAvisos", model);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/avisos/nuevo")
	public String creaNuevoAviso(@ModelAttribute("aviso") AvisoFormBean aviso,
			BindingResult result, HttpServletRequest request) {

		logger.debug("Creando aviso: " + aviso);
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

		MultipartFile archivoAdjunto = aviso.getAdjunto();

		DateTime today = DateTime.now();
		aviso.setFechaCreacion(today);

		avisoService.addAviso(aviso.build());

		String rootDirectory = request.getSession().getServletContext()
				.getRealPath("/");

		String nuevoNombre = "" + aviso.getId();

		// Si hay archivo, se guarda con su id interno, sin extensión
		if (archivoAdjunto != null && !archivoAdjunto.isEmpty()) {
			try {
				String rutaArchivoNuevo = rootDirectory
						+ "resources\\archivosAdjuntos\\" + nuevoNombre;
				archivoAdjunto.transferTo(new File(rutaArchivoNuevo));
				logger.info("Se ha guardado el archivo adjunto del aviso en : "
						+ rutaArchivoNuevo);
			} catch (Exception e) {
				throw new RuntimeException(
						"El archivo adjunto no ha podido guardarse", e);
			}
		}

		return "redirect:/avisos";
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/avisos/{id}")
	public ModelAndView editarAviso(@PathVariable("id") Long avisoID) {
		Map<String, Object> model = new HashMap<>();
		model.put("modo", "Editar");
		model.put("method", "PUT");
		AvisoFormBean avisoForm = new AvisoFormBean();
		Aviso aviso = avisoService.getAviso(avisoID);
		BeanUtils.copyProperties(aviso, avisoForm);
		model.put("aviso", avisoForm);
		return new ModelAndView("editorAvisos", model);
	}
	
	@RequestMapping(method=RequestMethod.DELETE , value="/avisos/{id}")
	public String eliminarAviso(@PathVariable("id") Long avisoID) {
		avisoService.eliminarAviso(avisoID);
		return "redirect:/avisos";
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/avisos/{id}")
	public String actualizarAviso(@PathVariable("id") Long avisoID, @ModelAttribute("aviso") AvisoFormBean aviso,
			BindingResult result, HttpServletRequest request) {

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
		
		MultipartFile archivoAdjunto = aviso.getAdjunto();
		
		DateTime today = DateTime.now();
		aviso.setFechaCreacion(today);
		Aviso avisoReal = avisoService.getAviso(avisoID);

		aviso.setId(avisoID);
		Aviso newAviso = aviso.build();
		
		BeanUtils.copyProperties(newAviso, avisoReal);
		
		avisoService.addAviso(aviso.build());
		
		String rootDirectory = request.getSession().getServletContext()
				.getRealPath("/");
		
		String nuevoNombre = "" + aviso.getId();
		
		// Si hay archivo, se guarda con su id interno, sin extensión
		if (archivoAdjunto != null && !archivoAdjunto.isEmpty()) {
			try {
				String rutaArchivoNuevo = rootDirectory
						+ "resources\\archivosAdjuntos\\" + nuevoNombre;
				archivoAdjunto.transferTo(new File(rutaArchivoNuevo));
				logger.info("Se ha guardado el archivo adjunto del aviso en : "
						+ rutaArchivoNuevo);
			} catch (Exception e) {
				throw new RuntimeException(
						"El archivo adjunto no ha podido guardarse", e);
			}
		}
	
		return "redirect:/avisos";
	}


}
