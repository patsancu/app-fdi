package com.fdi.aplicacionWeb.controller;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
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

	@Autowired
	AvisoService avisoService;

	@RequestMapping
	public String gestor(Model model) {
		model.addAttribute("avisos", avisoService.getAllAvisos());
		return "gestorAvisos";		
	}

	//	@RequestMapping("/editar")
	//	public String editarAvisos(Model model) {
	//		model.addAttribute("avisos", avisoService.getAllAvisos());
	//		return "editarAvisos";
	//	}

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
		System.out.println("DAFUQ!");
		System.out.println("DAFUQ!");
		System.out.println("DAFUQ!");
		if(result.hasErrors()) {
			System.out.println(result.getAllErrors());
			return "gestorAvisos";
		}
		String[] suppressedFields = result.getSuppressedFields();
		if (suppressedFields.length > 0) {
			throw new RuntimeException("Attempting to bind disallowed fields: " + StringUtils.arrayToCommaDelimitedString(suppressedFields));
		}


		MultipartFile archivoAdjunto = aviso.getAdjunto();

		//Formateado de fecha
		Date fechaCreacion = new Date(System.currentTimeMillis());
		aviso.setFechaCreacion(fechaCreacion);

		//Fecha inicio
		// Se combinan los datos individuales 
		// para crear el campo definitivo de tipo Date
		SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd hh:mm");
		String dateInString = aviso.getDiaPublicacionInicio() + " ";
		dateInString += aviso.getHoraPublicacionInicio();
		Date date = new Date();
		System.out.println(date);
		System.out.println(dateInString);

		try {
			date = sdf.parse(dateInString);
			aviso.setFechaPublicacionInicio(date);	
		}
		catch(ParseException e){
			System.out.println("Algo fue mal");
		}

		//	Fecha fin
		// Se combinan los datos individuales 
		// para crear el campo definitivo de tipo Date
		sdf = new SimpleDateFormat("yy-MM-dd hh:mm");
		dateInString = aviso.getDiaPublicacionFin() + " ";
		dateInString += aviso.getHoraPublicacionFin();
		date = new Date();
		System.out.println(date);
		System.out.println(dateInString);

		try {
			date = sdf.parse(dateInString);
			aviso.setFechaPublicacionFin(date);	
		}
		catch(ParseException e){
			System.out.println("Algo fue mal");
		}

		avisoService.addAviso(aviso);

		String rootDirectory = request.getSession().getServletContext().getRealPath("/");

		System.out.println(rootDirectory); //DEBUG
		String nuevoNombre = "" + aviso.getPostInternalId();

		//Si hay archivo, se guarda con su id interno, sin extensión
		if (archivoAdjunto!=null && !archivoAdjunto.isEmpty()) {
			try {		
				String rutaArchivoNuevo = rootDirectory+"resources\\archivosAdjuntos\\"+ nuevoNombre;
				archivoAdjunto.transferTo(new File(rutaArchivoNuevo));
				System.out.println("Se ha guardado el archivo en : " + rutaArchivoNuevo);
			} catch (Exception e) {
				throw new RuntimeException("El archivo adjunto no ha podido guardarse",e);
			}
		}

		return "redirect:/avisos/ver";
	}

	@RequestMapping(value="/editar", method = RequestMethod.GET)
	public String editarAviso(@ModelAttribute("aviso") Aviso aviso, @RequestParam("id") String avisoID,Model model){		
		model.addAttribute("aviso",avisoService.getAvisoById(avisoID));
		return "creadorEditorAvisos";
	}


	@RequestMapping(value="/editar", method = RequestMethod.POST)
	public String guardarEdicionAviso(@ModelAttribute("aviso") Aviso aviso, Model model){	
		Date fechaCreacion = new Date(System.currentTimeMillis());
		aviso.setFechaCreacion(fechaCreacion);

		//Fecha inicio
		//Se combinan los datos individuales (no mapeados a la bd) 
		// para crear el campo definitivo de tipo Date
		SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd hh:mm");
		String dateInString = aviso.getDiaPublicacionInicio() + " ";
		dateInString += aviso.getHoraPublicacionInicio();
		Date date = new Date();
		System.out.println(date);
		System.out.println(dateInString);

		try {
			date = sdf.parse(dateInString);
			aviso.setFechaPublicacionInicio(date);	
		}
		catch(ParseException e){
			System.out.println("Algo fue mal");
		}	

		//Fecha fin
		sdf = new SimpleDateFormat("yy-MM-dd hh:mm");
		dateInString = aviso.getDiaPublicacionFin() + " ";
		dateInString += aviso.getHoraPublicacionFin();
		date = new Date();
		System.out.println(date);
		System.out.println(dateInString);

		try {
			date = sdf.parse(dateInString);
			aviso.setFechaPublicacionFin(date);	
		}
		catch(ParseException e){
			System.out.println("Algo fue mal");
		}	

		//Se guarda el aviso editado
		avisoService.addAviso(aviso);

		return "redirect:/avisos/ver";
	}

}
