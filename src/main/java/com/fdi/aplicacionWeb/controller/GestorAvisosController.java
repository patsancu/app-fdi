package com.fdi.aplicacionWeb.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
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

	@RequestMapping("/editar")
	public String editarAvisos(Model model) {
		model.addAttribute("avisos", avisoService.getAllAvisos());
		return "editarAvisos";
	}
	
	@RequestMapping("/eliminar")
	public String eliminarAviso(@RequestParam("id") String avisoID, Model model) {
		avisoService.eliminarAviso(avisoID);
		return "redirect:/avisos/gestor";	
	}
	
	
	@RequestMapping(value="/crear", method = RequestMethod.GET)	
	public String formularioCreadorAvisos(@ModelAttribute("nuevoAviso") Aviso nuevoAviso) {
		return "creadorAvisos";
	}

	@RequestMapping(value="/crear", method = RequestMethod.POST)	
	public String procesarNuevoAviso(@ModelAttribute("nuevoAviso") Aviso nuevoAviso, BindingResult result, HttpServletRequest request) {
		System.out.println("GestorAvisosController");
		System.out.print(nuevoAviso);
		if(result.hasErrors()) {
			return "gestorAvisos";
		}
		String[] suppressedFields = result.getSuppressedFields();
		if (suppressedFields.length > 0) {
			throw new RuntimeException("Attempting to bind disallowed fields: " + StringUtils.arrayToCommaDelimitedString(suppressedFields));
		}


		//MultipartFile productImage = nuevoAviso.getProductImage();


		String rootDirectory =request.getSession().getServletContext().getRealPath("/");

		//		if (productImage!=null && !productImage.isEmpty()) {
		//			try {
		//				productImage.transferTo(new File(rootDirectory+"resources/images/"+ nuevoAviso.getProductId() + ".png"));
		//			} catch (Exception e) {
		//				throw new RuntimeException("Product Image saving failed",e);
		//			}
		//		}



		avisoService.addAviso(nuevoAviso);
		//return "redirect:/avisos/gestor";
		return "redirect:/avisos/ver";
	}

	@InitBinder
	public void initialiseBinder(WebDataBinder binder) {
		binder.setDisallowedFields("fechaCreacion");
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class,
				new CustomDateEditor(dateFormat, false));	
	}
}
