/**
 * This file is part of Portal Web de la FDI.
 *
 * Portal Web de la FDI is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Portal Web de la FDI is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with Portal Web de la FDI.  If not, see <http://www.gnu.org/licenses/>.
 */
package es.ucm.fdi.avisos.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import es.ucm.fdi.avisos.boundary.Avisos;
import es.ucm.fdi.avisos.business.entity.Aviso;
import es.ucm.fdi.avisos.business.entity.AvisoBuilder;
import es.ucm.fdi.avisos.util.CustomRssViewer;
import es.ucm.fdi.avisos.validation.AvisoValidator;
import es.ucm.fdi.util.Constants;

@Controller
public class AvisosController {

	private static final Logger logger = LoggerFactory.getLogger("es.ucm.fdi.avisos");

	@Autowired
	private Avisos avisoService;

	@Autowired 
	private AvisoValidator avisoValidator;

	@RequestMapping(method = RequestMethod.GET, value = Constants.URL_LISTAR_AVISOS)
	public ModelAndView listarAvisos(HttpServletRequest request) {
		Map<String, Object> model = new HashMap<>();
		model.put("avisos", avisoService.getAvisos());
		model.put("deleteAction", request.getContextPath()+"/avisos");
		model.put("urlTwitterUsuario", Constants.URL_TWITTER_USUARIO);
		return new ModelAndView("listarAvisos", model);
	}

	@RequestMapping(method = RequestMethod.GET, value = Constants.URL_AVISO_INDIVIDUAL + "/ver")
	public String avisoIndividual(@PathVariable("id") Long avisoID, Model model) {
		model.addAttribute("a", avisoService.getAviso(avisoID));
		return "verAviso";
	}

	@RequestMapping(method = RequestMethod.GET, value = "/avisos/feed", produces = "application/xml")
	public ModelAndView rssVisor() {
		Iterable<Aviso> items = avisoService.getAvisos();
		return new ModelAndView(new CustomRssViewer(), "feedContent", items);
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(method = RequestMethod.GET, value = Constants.URL_NUEVO_AVISO)
	public ModelAndView nuevoAviso() {
		Map<String, Object> model = new HashMap<>();
		model.put("modo", "Crear");
		model.put("method", "POST");
		model.put("aviso", new AvisoBuilder());
		return new ModelAndView("editorAvisos", model);
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(method = RequestMethod.POST, value = Constants.URL_NUEVO_AVISO)
	public ModelAndView creaNuevoAviso(@ModelAttribute("aviso") @Validated AvisoBuilder aviso, BindingResult result) 
			throws IOException 
	{
		logger.debug("Creando aviso: " + aviso);
		Map<String, Object> model = new HashMap<>();


		if ( result.hasErrors()){
			logger.debug("Ha habido errores ");
			logger.debug(result.getAllErrors().toString());
			model.put("modo", "Crear");
			model.put("method", "POST");
			model.put("aviso", aviso);
			return new ModelAndView("editorAvisos", model);
		}




		String[] suppressedFields = result.getSuppressedFields();
		if (suppressedFields.length > 0) {
			logger.error("Attempting to bind disallowed fields: "
					+ StringUtils.arrayToCommaDelimitedString(suppressedFields));
			throw new RuntimeException("Attempting to bind disallowed fields: "
					+ StringUtils.arrayToCommaDelimitedString(suppressedFields));
		}

		avisoService.addAviso(aviso);

		return new ModelAndView("redirect:/avisos", model);
	}

	@RequestMapping(method = RequestMethod.GET, value = Constants.URL_AVISO_INDIVIDUAL)
	public ModelAndView editarAviso(@PathVariable("id") Long avisoID) {
		Map<String, Object> model = new HashMap<>();
		model.put("modo", "Editar");
		model.put("method", "PUT");
		AvisoBuilder avisoForm = new AvisoBuilder();
		Aviso aviso = avisoService.getAviso(avisoID);
		BeanUtils.copyProperties(aviso, avisoForm);
		model.put("aviso", avisoForm);
		return new ModelAndView("editorAvisos", model);
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(method=RequestMethod.DELETE , value = Constants.URL_AVISO_INDIVIDUAL)
	public String eliminarAviso(@PathVariable("id") Long avisoID) throws IOException {
		avisoService.eliminarAviso(avisoID);
		return "redirect:/avisos";
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(method = RequestMethod.PUT, value = Constants.URL_AVISO_INDIVIDUAL)
	public String actualizarAviso(@PathVariable("id") Long avisoID, @ModelAttribute("aviso") @Validated AvisoBuilder aviso,
			BindingResult result, HttpServletRequest request) throws IOException {

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
		aviso.setId(avisoID);
		avisoService.actualizaAviso(aviso);

		return "redirect:/avisos";
	}


	@InitBinder("aviso")
	public void initialiseBinder(WebDataBinder binder) {
		binder.setValidator(avisoValidator);
		binder.setDisallowedFields("id");
	}
}
