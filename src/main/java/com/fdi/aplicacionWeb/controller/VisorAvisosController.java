package com.fdi.aplicacionWeb.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fdi.aplicacionWeb.service.AvisoService;

@Controller
@RequestMapping("/avisos/ver")
public class VisorAvisosController {
	@Autowired
	AvisoService avisoService;

	@RequestMapping
	public String welcome(Model model) {
		model.addAttribute("greeting", "Bienvenido a la aplicaci�n de noticias de Fdi-UCM");
		model.addAttribute("tagline", "Seleccione la opci�n deseada");
		model.addAttribute("avisos", avisoService.getAllAvisos());
		System.out.println(avisoService.getAllAvisos());
		return "listarAvisos";
	}
	
	@RequestMapping("/individual")
	public String individual(@RequestParam("id") String avisoID, Model model){
		model.addAttribute(avisoService.getAvisoById(avisoID));
		return "verAviso";
	}
}
