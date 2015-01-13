package com.fdi.aplicacionWeb.controller;

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

import com.fdi.aplicacionWeb.domain.Aviso;
import com.fdi.aplicacionWeb.service.AvisoService;

@Controller
@RequestMapping("/avisos/gestor")
public class GestorAvisosController {

	static final Logger logger = LoggerFactory.getLogger(GestorAvisosController.class);

	@Autowired
	AvisoService avisoService;

	@RequestMapping
	public String gestor(Model model) {
		model.addAttribute("avisos", avisoService.getAllAvisos());
		return "gestorAvisos";		
	}

	@RequestMapping("/eliminar")
	public String eliminarAviso(@RequestParam("id") String avisoID, Model model) {		
		avisoService.eliminarAviso(avisoID);
		return "redirect:/avisos/ver";	
	}


	@RequestMapping(value="/crear", method = RequestMethod.GET)	
	public String formularioCreadorAvisos(@ModelAttribute("aviso") Aviso aviso, Model model) {
		return "creadorEditorAvisos";
	}

	@RequestMapping(value="/crear", method = RequestMethod.POST)	
	public String procesarNuevoAviso(@ModelAttribute("aviso") Aviso aviso, BindingResult result, HttpServletRequest request) {

		if(result.hasErrors()) {
			logger.warn(result.getAllErrors().toString());
			return "gestorAvisos";
		}
		String[] suppressedFields = result.getSuppressedFields();
		if (suppressedFields.length > 0) {
			logger.error("Attempting to bind disallowed fields: " + StringUtils.arrayToCommaDelimitedString(suppressedFields));
			throw new RuntimeException("Attempting to bind disallowed fields: " + StringUtils.arrayToCommaDelimitedString(suppressedFields));
		}


		MultipartFile archivoAdjunto = aviso.getAdjunto();

		//Formateado de fecha
		LocalDateTime today = LocalDateTime.now();
		aviso.setFechaCreacion(today);
		aviso.setNumeroVisitas(0);

		//Fecha inicio
		// Se combinan los datos individuales 
		// para crear el campo definitivo de tipo Date
		DateTimeFormatter dtForm=DateTimeFormat.forPattern("yy-MM-dd HH:mm");
		String dateInString = aviso.getDiaPublicacionInicio() + " ";
		dateInString += aviso.getHoraPublicacionInicio();

		LocalDateTime dt = LocalDateTime.parse(dateInString, dtForm);
		aviso.setFechaPublicacionInicio(dt);

		//	Fecha fin
		// Se combinan los datos individuales 
		// para crear el campo definitivo de tipo Date
		dateInString = aviso.getDiaPublicacionFin() + " ";
		dateInString += aviso.getHoraPublicacionFin();

		dt = LocalDateTime.parse(dateInString, dtForm);
		aviso.setFechaPublicacionFin(dt);

		//Fecha evento
		dateInString = aviso.getDiaEvento() + " ";
		dateInString += aviso.getHoraEvento();

		dt = LocalDateTime.parse(dateInString, dtForm);
		aviso.setFechaEvento(dt);	

		avisoService.addAviso(aviso);

		String rootDirectory = request.getSession().getServletContext().getRealPath("/");

		String nuevoNombre = "" + aviso.getPostInternalId();

		//Si hay archivo, se guarda con su id interno, sin extensi�n
		if (archivoAdjunto!=null && !archivoAdjunto.isEmpty()) {
			try {		
				String rutaArchivoNuevo = rootDirectory+"resources\\archivosAdjuntos\\"+ nuevoNombre;
				archivoAdjunto.transferTo(new File(rutaArchivoNuevo));
				logger.info("Se ha guardado el archivo adjunto del aviso en : " + rutaArchivoNuevo);
			} catch (Exception e) {
				throw new RuntimeException("El archivo adjunto no ha podido guardarse",e);
			}
		}

		return "redirect:/avisos/ver";
	}

	@RequestMapping(value="/editar", method = RequestMethod.GET)
	public String editarAviso(@ModelAttribute("aviso") Aviso aviso, @RequestParam("id") String avisoID,Model model){		
		model.addAttribute("aviso",avisoService.getAvisoById(avisoID));
		logger.info("Se quiere editar el aviso con id: " + aviso.getPostInternalId());
		logger.debug("Aviso antes de editar: ");
		logger.debug(aviso.toString());
		return "creadorEditorAvisos";
	}


	@RequestMapping(value="/editar", method = RequestMethod.POST)
	public String guardarEdicionAviso(@ModelAttribute("aviso") Aviso aviso, Model model, HttpServletRequest request){		

		//Fecha inicio
		//Se combinan los datos individuales (no mapeados a la bd) 
		// para crear el campo definitivo de tipo Date
		//Formateado de fecha
		LocalDateTime today = LocalDateTime.now();
		aviso.setFechaCreacion(today);
		aviso.setNumeroVisitas(0);

		//Fecha inicio
		// Se combinan los datos individuales 
		// para crear el campo definitivo de tipo Date
		DateTimeFormatter dtForm=DateTimeFormat.forPattern("yy-MM-dd HH:mm");
		String dateInString = aviso.getDiaPublicacionInicio() + " ";
		dateInString += aviso.getHoraPublicacionInicio();

		LocalDateTime dt = LocalDateTime.parse(dateInString, dtForm);
		aviso.setFechaPublicacionInicio(dt);

		//	Fecha fin
		// Se combinan los datos individuales 
		// para crear el campo definitivo de tipo Date
		dateInString = aviso.getDiaPublicacionFin() + " ";
		dateInString += aviso.getHoraPublicacionFin();

		dt = LocalDateTime.parse(dateInString, dtForm);
		aviso.setFechaPublicacionFin(dt);

		//Fecha evento
		dateInString = aviso.getDiaEvento() + " ";
		dateInString += aviso.getHoraEvento();

		dt = LocalDateTime.parse(dateInString, dtForm);
		aviso.setFechaEvento(dt);


		MultipartFile archivoAdjunto = aviso.getAdjunto();




		logger.debug("Aviso después de editar: ");
		logger.debug(aviso.toString());


		String rootDirectory = request.getSession().getServletContext().getRealPath("/");

		String nuevoNombre = "" + aviso.getPostInternalId();

		//Si hay archivo, se guarda con su id interno, sin extensi�n
		if (archivoAdjunto!=null && !archivoAdjunto.isEmpty()) {
			try {		
				String rutaArchivoNuevo = rootDirectory+"resources\\archivosAdjuntos\\"+ nuevoNombre;
				archivoAdjunto.transferTo(new File(rutaArchivoNuevo));
				logger.info("Se ha guardado el archivo adjunto del aviso en : " + rutaArchivoNuevo);
			} catch (Exception e) {
				throw new RuntimeException("El archivo adjunto no ha podido guardarse",e);
			}
		}


		//Se guarda el aviso editado
		avisoService.addAviso(aviso);

		return "redirect:/avisos/ver";
	}

}
