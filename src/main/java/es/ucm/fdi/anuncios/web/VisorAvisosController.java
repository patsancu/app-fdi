package es.ucm.fdi.anuncios.web;


import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import es.ucm.fdi.anuncios.business.Avisos;
import es.ucm.fdi.anuncios.business.domain.Aviso;
import es.ucm.fdi.anuncios.util.CustomRssViewer;

@Controller
@RequestMapping("/ver")
public class VisorAvisosController {
	@Autowired
	Avisos avisoService;

	@RequestMapping
	public String welcome(Model model) {
		model.addAttribute("greeting", "Bienvenido a la aplicaci�n de noticias de Fdi-UCM");
		model.addAttribute("tagline", "Seleccione la opci�n deseada");
		model.addAttribute("avisos", avisoService.getAllAvisos());
		return "listarAvisos";
	}
	
	@RequestMapping("/individual")
	public String individual(@RequestParam("id") String avisoID, Model model){
		avisoService.incrementarVisitas(avisoID);
		model.addAttribute(avisoService.getAvisoById(avisoID));				
		return "verAviso";
	}
	
	@RequestMapping("/iframe")
	public String pruebaIframe(Model model){		
		return "iframe";
	}
	
	@RequestMapping("/basico")
	public String basico(Model model){
		model.addAttribute("avisos", avisoService.getAllAvisos());
		return "basico";
	}
	
	
	@RequestMapping(value="/rssfeed", method = RequestMethod.GET)
	public ModelAndView rssVisor(Model model, HttpServletRequest request){
		List<Aviso> items = new ArrayList<Aviso>();
		
		items = avisoService.getAllAvisos();
		
		return new ModelAndView(new CustomRssViewer(),"feedContent", items);
	}
}
