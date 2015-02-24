package es.ucm.fdi.avisos.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import es.ucm.fdi.avisos.business.entity.AvisoBuilder;

@Component
public class AvisoValidator implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		return AvisoBuilder.class.equals(arg0);
	}

	@Override
	public void validate(Object obj, Errors e){
		ValidationUtils.rejectIfEmpty(e, "titulo", "Size.Aviso.titulo.validation");
		
		AvisoBuilder a = (AvisoBuilder) obj;
        if (a.getTitulo().length() <= 4 || a.getTitulo().length() >= 50){
        	e.rejectValue("titulo", "Size.Aviso.titulo.validation");
        }
        
        if (a.getComienzoPublicacion().isAfter(a.getFinPublicacion())){
        	e.rejectValue("comienzoPublicacion", "Size.Aviso.fecha.validaton");
        }
        
	}

}
