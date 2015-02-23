package es.ucm.fdi.espacios.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import es.ucm.fdi.espacios.business.domain.Espacio;

@Component
public class EspacioValidator implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		return Espacio.class.equals(arg0);
	}

	@Override
	public void validate(Object o, Errors errs) {		
		Espacio espacio = (Espacio) o;
		if (espacio.getNombre().length() <= 4 || espacio.getNombre().length() >= 50){
			errs.rejectValue("nombre", "Size.Espacio.nombre.validation");
		}

	}

}
