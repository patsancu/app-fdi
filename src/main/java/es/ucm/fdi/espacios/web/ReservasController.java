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
package es.ucm.fdi.espacios.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
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

import es.ucm.fdi.espacios.business.boundary.Espacios;
import es.ucm.fdi.espacios.business.boundary.Reservas;
import es.ucm.fdi.espacios.business.entity.Espacio;
import es.ucm.fdi.espacios.business.entity.Reserva;
import es.ucm.fdi.espacios.business.entity.ReservaBuilder;
import es.ucm.fdi.espacios.validation.ReservaValidator;
import es.ucm.fdi.util.Constants;

@Controller
public class ReservasController {
	private static final Logger logger = LoggerFactory.getLogger("es.ucm.fdi.espacios");

	@Autowired
	private Reservas reservas; 

	@Autowired
	private ReservaValidator reservaValidator;

	@Autowired
	private Espacios espacios;

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(method = RequestMethod.GET, value = Constants.URL_NUEVA_RESERVA)
	public ModelAndView nuevaReserva() {
		Map<String, Object> model = new HashMap<>();
		model.put("modo", "Crear");
		model.put("method", "POST");
		model.put("reserva", new ReservaBuilder() );
		model.put("espacios", espacios.listarEspacios());

		return new ModelAndView("editorReservas", model);
	}

	@RequestMapping(method = RequestMethod.POST, value = Constants.URL_NUEVA_RESERVA)
	public ModelAndView creaNuevaReserva(@ModelAttribute("reserva") @Validated ReservaBuilder reserva,
			BindingResult result) throws IOException {
		logger.debug("Creando reserva: " + reserva);
		Map<String, Object> model = new HashMap<>();

		if (result.hasErrors() || ! reservas.addReserva(reserva)){
			logger.debug("Ha habido errores ");
			if (result.hasErrors()){
				logger.debug(result.getAllErrors().toString());
			}
			else{
				model.put("error", "La reserva coincide con alguna existente");
			}

			model.put("modo", "Crear");
			model.put("method", "POST");
			model.put("reserva", reserva);
			model.put("espacios", espacios.listarEspacios());


			return new ModelAndView("editorReservas", model);
		}

		String[] suppressedFields = result.getSuppressedFields();
		if (suppressedFields.length > 0) {
			logger.error("Attempting to bind disallowed fields: "
					+ StringUtils.arrayToCommaDelimitedString(suppressedFields));
			throw new RuntimeException("Attempting to bind disallowed fields: "
					+ StringUtils.arrayToCommaDelimitedString(suppressedFields));
		}

		return new ModelAndView("redirect:/reservas/calendario", model);
	}

	

	@RequestMapping(method = RequestMethod.GET, value = Constants.URL_LISTAR_RESERVAS)
	public ModelAndView listarReservas(HttpServletRequest request){
		Map<String, Object> model = new HashMap<>();		

		List<Reserva> listaReservas = reservas.listReservas();
		model.put("reservas", listaReservas);
		model.put("deleteAction", request.getContextPath()+"/reservas");

		return new ModelAndView("listarReservas", model);
	}

	@RequestMapping(method = RequestMethod.GET, value = Constants.URL_RESERVA_INDIVIDUAL)
	public ModelAndView editarReserva(@PathVariable("id") Long reservaId){
		Map<String, Object> model = new HashMap<>();

		ReservaBuilder reservaForm = new ReservaBuilder();
		Reserva reserva = reservas.getReserva(reservaId);
		BeanUtils.copyProperties(reserva, reservaForm);

		reservaForm.setId_espacio(reserva.getEspacio().getId());

		model.put("modo", "Editar");
		model.put("method", "PUT");
		model.put("reserva", reservaForm);		
		model.put("espacios", espacios.listarEspacios());


		return new ModelAndView("editorReservas", model);
	}

	@RequestMapping(method = RequestMethod.PUT, value = Constants.URL_RESERVA_INDIVIDUAL)
	public String actualizaReserva(@PathVariable("id") Long reservaId, @ModelAttribute("reserva") ReservaBuilder reserva,
			BindingResult result, HttpServletRequest request){
		logger.debug("Actualizando reserva:" + reserva);
		reserva.setId(reservaId);
		reservas.actualiza(reserva);

		return "redirect:/reservas/calendario";
	}

	@RequestMapping(method=RequestMethod.DELETE , value = Constants.URL_RESERVA_INDIVIDUAL)
	public String eliminarReserva(@PathVariable("id") Long reservaId) throws IOException {
		reservas.eliminar(reservaId);
		return "redirect:/reservas";
	}

	@RequestMapping(method = RequestMethod.GET, value = Constants.URL_CALENDARIO_RESERVAS)
	public ModelAndView calendarioReservas(HttpServletRequest request){
		Map<String, Object> model = new HashMap<>();	

		List<Espacio> espaciosUsados = reservas.espaciosUsados();
		if (espaciosUsados.size() > 0){
			for ( Espacio element :  espaciosUsados) {
				logger.warn("Espacio: " + element.getId());
			}
		}



		List<Reserva> listaReservas = reservas.listReservas();
		model.put("modo", "Crear");
		model.put("methodCrear", "POST");
		model.put("methodActualizar", "PUT");
		model.put("reserva", new ReservaBuilder() );
		model.put("reservas", listaReservas);
		model.put("espacios", espacios.listarEspacios());
		model.put("deleteAction", request.getContextPath()+"/reservas");
		model.put("espaciosUsados", espaciosUsados);

		return new ModelAndView("calendarioReservas", model);
	}

	@RequestMapping(method = RequestMethod.POST, value="/reservas/ajax/nueva")
	public void ajaxCrearReserva(@ModelAttribute("reserva") @Validated ReservaBuilder reserva, BindingResult result, HttpServletResponse response){
		response.setStatus(org.springframework.http.HttpStatus.OK.value());
	}


	@InitBinder
	public void initialiseBinder(WebDataBinder binder) {
		binder.setValidator(reservaValidator);
		binder.setDisallowedFields("id");
	}
}
