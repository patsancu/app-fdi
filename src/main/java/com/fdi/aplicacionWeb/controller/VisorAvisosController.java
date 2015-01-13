package com.fdi.aplicacionWeb.controller;


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

import com.fdi.aplicacionWeb.domain.Aviso;
import com.fdi.aplicacionWeb.service.AvisoService;
import com.fdi.aplicacionWeb.util.CustomRssViewer;

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
		 
//		Aviso content  = new Aviso();
//		content.setTitulo("Spring MVC Tutorial 1");
//		content.setEtiqueta("item1");
//		content.setContenidoAviso("Tutorial 1 summary ...");
//		content.setDiaEvento(""+new Date(0));
//		items.add(content);
		
		items = avisoService.getAllAvisos();
 
//		SampleContent content2  = new SampleContent();
//		content2.setTitle("Spring MVC Tutorial 2");
//		content2.setUrl("http://www.mkyong.com/spring-mvc/tutorial-2");
//		content2.setSummary("Tutorial 2 summary ...");
//		content2.setCreatedDate(new Date());
//		items.add(content2);
//		ModelAndView mav = new ModelAndView();
//		mav.setViewName("rssViewer");
//		mav.addObject("feedContent", items);
		
		
		//model.addAttribute("rssItems", items);
		ModelAndView modelAndView = new ModelAndView("rssItems");
		modelAndView.setViewName("rssViewer");
		modelAndView.addObject("feedContent", items);
		
		return new ModelAndView(new CustomRssViewer(),"feedContent", items);
//		return modelAndView;
 
		//return "listarRss";
	}
}
