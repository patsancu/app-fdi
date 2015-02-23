package es.ucm.fdi.espacios.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import es.ucm.fdi.espacios.business.domain.ReservaBuilder;

@Component
public class ReservaValidator implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		return ReservaBuilder.class.equals(arg0);
	}

	@Override
	public void validate(Object o, Errors errs) {
		ValidationUtils.rejectIfEmpty(errs, "id_espacio", "Size.Aviso.titulo.validation");
		
	}

}
