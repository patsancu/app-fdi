package es.ucm.fdi.espacios.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import es.ucm.fdi.espacios.business.Reservas;
import es.ucm.fdi.espacios.business.domain.Reserva;

@Controller
public class ReservasController {
	private static final Logger logger = LoggerFactory.getLogger("es.ucm.fdi.espacios");
	
	@Autowired
	private Reservas reservas; 
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(method = RequestMethod.GET, value = "/reservas/nuevo")
	public ModelAndView nuevaReserva() {
		Map<String, Object> model = new HashMap<>();
		model.put("modo", "Crear");
		model.put("method", "POST");
		model.put("reserva", new Reserva() );
		return new ModelAndView("editorReservas", model);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/reservas/nuevo")
	public ModelAndView creaNuevaReserva(@ModelAttribute("reserva") Reserva reserva,
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

		return new ModelAndView("redirect:/", model);
	}
	
}
