package es.ucm.fdi.espacios.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

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

import es.ucm.fdi.espacios.business.Espacios;
import es.ucm.fdi.espacios.business.Reservas;
import es.ucm.fdi.espacios.business.domain.Reserva;
import es.ucm.fdi.espacios.business.domain.ReservaBuilder;
import es.ucm.fdi.espacios.validation.ReservaValidator;

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
	@RequestMapping(method = RequestMethod.GET, value = "/reservas/nuevo")
	public ModelAndView nuevaReserva() {
		Map<String, Object> model = new HashMap<>();
		model.put("modo", "Crear");
		model.put("method", "POST");
		model.put("reserva", new ReservaBuilder() );
		model.put("espacios", espacios.listarEspacios());
		
		return new ModelAndView("editorReservas", model);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/reservas/nuevo")
	public ModelAndView creaNuevaReserva(@ModelAttribute("reserva") @Validated ReservaBuilder reserva,
			BindingResult result) throws IOException {
		logger.debug("Creando reserva: " + reserva);
		Map<String, Object> model = new HashMap<>();
		
		if (result.hasErrors()){		
				logger.debug("Ha habido errores ");
				logger.debug(result.getAllErrors().toString());
			
			model.put("modo", "Crear");
			model.put("method", "POST");
			model.put("reserva", reserva);
			return new ModelAndView("editorReservas", model);
		}
		
		String[] suppressedFields = result.getSuppressedFields();
		if (suppressedFields.length > 0) {
			logger.error("Attempting to bind disallowed fields: "
					+ StringUtils.arrayToCommaDelimitedString(suppressedFields));
			throw new RuntimeException("Attempting to bind disallowed fields: "
					+ StringUtils.arrayToCommaDelimitedString(suppressedFields));
		}

		reservas.addReserva(reserva);

		return new ModelAndView("redirect:/reservas", model);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/reservas")
	public ModelAndView listarReservas(HttpServletRequest request){
		Map<String, Object> model = new HashMap<>();		
		
		List<Reserva> listaReservas = reservas.listReservas();
		model.put("reservas", listaReservas);
		model.put("deleteAction", request.getContextPath()+"/reservas");
		
		return new ModelAndView("listarReservas", model);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/reservas/{id}")
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
	
	@RequestMapping(method = RequestMethod.PUT, value = "/reservas/{id}")
	public String actualizaReserva(@PathVariable("id") Long reservaId, @ModelAttribute("reserva") ReservaBuilder reserva,
			BindingResult result, HttpServletRequest request){
		logger.debug("Actualizando reserva:" + reserva);
		reserva.setId(reservaId);
		reservas.actualiza(reserva);
		
		return "redirect:/reservas";
	}
	
	@RequestMapping(method=RequestMethod.DELETE , value="/reservas/{id}")
	public String eliminarReserva(@PathVariable("id") Long reservaId) throws IOException {
		reservas.eliminar(reservaId);
		return "redirect:/reservas";
	}
	
	@InitBinder
	public void initialiseBinder(WebDataBinder binder) {
		binder.setValidator(reservaValidator);
		binder.setDisallowedFields("id");
	}
}
