package com.fdi.aplicacionWeb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/avisos/gestor")
public class GestorNoticiasController {
	
	@RequestMapping
	public String gestor(Model model) {
		return "gestorAvisos";
	}
	
	@RequestMapping("/crear")
	public String creadorAvisos(Model model) {
		return "creadorAvisos";
	}
}
