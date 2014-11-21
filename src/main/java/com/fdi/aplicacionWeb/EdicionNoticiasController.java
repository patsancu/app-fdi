package com.fdi.aplicacionWeb;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/avisos/editar")
public class EdicionNoticiasController {
	
	@RequestMapping
	public String welcome(Model model) {
		model.addAttribute("greeting", "Bienvenido a la aplicación de avisos de Fdi-UCM");
		model.addAttribute("tagline", "Seleccione la opción deseada");

		return "gestorAvisos";
	}
}
