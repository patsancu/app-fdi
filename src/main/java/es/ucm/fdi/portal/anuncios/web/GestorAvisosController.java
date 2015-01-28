package es.ucm.fdi.portal.anuncios.web;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.joda.time.LocalDateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import es.ucm.fdi.anuncios.business.Avisos;
import es.ucm.fdi.anuncios.business.domain.Aviso;

@Controller
@RequestMapping("/gestor")
public class GestorAvisosController {

	static final Logger logger = LoggerFactory
			.getLogger(GestorAvisosController.class);

	@Autowired
	Avisos avisoService;

	@RequestMapping
	public String gestor(Model model) {
		model.addAttribute("avisos", avisoService.getAllAvisos());
		return "gestorAvisos";
	}

	@RequestMapping("/eliminar")
	public String eliminarAviso(@RequestParam("id") String avisoID, Model model) {
		avisoService.eliminarAviso(avisoID);
		return "redirect:/ver";
	}

	@RequestMapping(value = "/crear", method = RequestMethod.GET)
	public String formularioCreadorAvisos(@ModelAttribute("aviso") Aviso aviso,
			Model model) {
		return "creadorEditorAvisos";
	}

	@RequestMapping(value = "/crear", method = RequestMethod.POST)
	public String procesarNuevoAviso(@ModelAttribute("aviso") Aviso aviso,
			BindingResult result, HttpServletRequest request) {
		logger.warn("Creando aviso: " + aviso);
		if (result.hasErrors()) {
			logger.warn(result.getAllErrors().toString());
			return "gestorAvisos";
		}
		String[] suppressedFields = result.getSuppressedFields();
		if (suppressedFields.length > 0) {
			logger.error("Attempting to bind disallowed fields: "
					+ StringUtils.arrayToCommaDelimitedString(suppressedFields));
			throw new RuntimeException("Attempting to bind disallowed fields: "
					+ StringUtils.arrayToCommaDelimitedString(suppressedFields));
		}

		MultipartFile archivoAdjunto = aviso.getAdjunto();

		// Formateado de fecha
		LocalDateTime today = LocalDateTime.now();
		aviso.setFechaCreacion(today);
		aviso.setNumeroVisitas(0);

		// Fecha inicio
		// Se combinan los datos individuales
		// para crear el campo definitivo de tipo Date
		DateTimeFormatter dtForm = DateTimeFormat.forPattern("yy-MM-dd HH:mm");
		String dateInString = aviso.getDiaPublicacionInicio() + " ";
		dateInString += aviso.getHoraPublicacionInicio();

		LocalDateTime dt = LocalDateTime.parse(dateInString, dtForm);
		logger.debug("FechaPublicacion:" + dt);
		aviso.setFechaPublicacionInicio(dt);

		// Fecha fin
		// Se combinan los datos individuales
		// para crear el campo definitivo de tipo Date
		dateInString = aviso.getDiaPublicacionFin() + " ";
		dateInString += aviso.getHoraPublicacionFin();

		dt = LocalDateTime.parse(dateInString, dtForm);
		logger.debug("FechaPublicacion:" + dt.toString());
		aviso.setFechaPublicacionFin(dt);

		// Fecha evento
		dateInString = aviso.getDiaEvento() + " ";
		dateInString += aviso.getHoraEvento();

		dt = LocalDateTime.parse(dateInString, dtForm);
		logger.debug("FechaEvento:" + dt.toString());
		aviso.setFechaEvento(dt);

		avisoService.addAviso(aviso);

		String rootDirectory = request.getSession().getServletContext()
				.getRealPath("/");

		String nuevoNombre = "" + aviso.getPostInternalId();

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

		return "redirect:/ver";
	}

	@RequestMapping(value = "/editar", method = RequestMethod.GET)
	public String editarAviso(@ModelAttribute("aviso") Aviso aviso,
			@RequestParam("id") String avisoID, Model model) {
		model.addAttribute("aviso", avisoService.getAvisoById(avisoID));
		logger.info("Se quiere editar el aviso con id: "
				+ aviso.getPostInternalId());
		logger.debug("Aviso antes de editar: ");
		logger.debug(aviso.toString());
		return "creadorEditorAvisos";
	}

	@RequestMapping(value = "/editar", method = RequestMethod.POST)
	public String guardarEdicionAviso(@ModelAttribute("aviso") Aviso aviso,
			Model model, HttpServletRequest request) {

		// Fecha inicio
		// Se combinan los datos individuales (no mapeados a la bd)
		// para crear el campo definitivo de tipo Date
		// Formateado de fecha
		LocalDateTime today = LocalDateTime.now();
		aviso.setFechaCreacion(today);
		aviso.setNumeroVisitas(0);

		// Fecha inicio
		// Se combinan los datos individuales
		// para crear el campo definitivo de tipo Date
		DateTimeFormatter dtForm = DateTimeFormat.forPattern("yy-MM-dd HH:mm");
		String dateInString = aviso.getDiaPublicacionInicio() + " ";
		dateInString += aviso.getHoraPublicacionInicio();

		LocalDateTime dt = LocalDateTime.parse(dateInString, dtForm);
		aviso.setFechaPublicacionInicio(dt);

		// Fecha fin
		// Se combinan los datos individuales
		// para crear el campo definitivo de tipo Date
		dateInString = aviso.getDiaPublicacionFin() + " ";
		dateInString += aviso.getHoraPublicacionFin();

		dt = LocalDateTime.parse(dateInString, dtForm);
		aviso.setFechaPublicacionFin(dt);

		// Fecha evento
		dateInString = aviso.getDiaEvento() + " ";
		dateInString += aviso.getHoraEvento();

		dt = LocalDateTime.parse(dateInString, dtForm);
		aviso.setFechaEvento(dt);

		MultipartFile archivoAdjunto = aviso.getAdjunto();

		logger.debug("Aviso después de editar: ");
		logger.debug(aviso.toString());

		String rootDirectory = request.getSession().getServletContext()
				.getRealPath("/");

		String nuevoNombre = "" + aviso.getPostInternalId();

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

		// Se guarda el aviso editado
		avisoService.addAviso(aviso);

		return "redirect:/ver";
	}

}
