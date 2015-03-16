package es.ucm.fdi.avisos.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import es.ucm.fdi.avisos.business.entity.AvisoBuilder;
import es.ucm.fdi.avisos.business.entity.TipoAvisoEnum;

@Component
public class AvisoValidator implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		return AvisoBuilder.class.equals(arg0);
	}

	@Override
	public void validate(Object obj, Errors e){
		//ValidationUtils.rejectIfEmpty(e, "titulo", "Size.Aviso.titulo.validation");
		
		AvisoBuilder a = (AvisoBuilder) obj;
        if (a.getTitulo().length() <= 4 || a.getTitulo().length() >= 50){
        	e.rejectValue("titulo", "Aviso.titulo.Size.validation");
        }
        
        if (a.getComienzoPublicacion() != null && a.getFinPublicacion() != null){
        	if (a.getComienzoPublicacion().isAfter(a.getFinPublicacion())){
            	e.rejectValue("comienzoPublicacion", "Aviso.fecha.validation");
            }
        }
        
        if (a.getTipoAviso() == null){
        	e.rejectValue("tipoAviso", "Aviso.tipoAviso.validation");
        }
        else if (a.getTipoAviso() == TipoAvisoEnum.URL){
        	ValidationUtils.rejectIfEmpty(e, "urlDestino", "Aviso.url");
        }
        else if (a.getTipoAviso() == TipoAvisoEnum.HTML){
        	ValidationUtils.rejectIfEmpty(e, "contenidoAviso", "Aviso.contenido");
        }
        
        
        
       
        
	}

}
