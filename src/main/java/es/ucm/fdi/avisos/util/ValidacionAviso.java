package es.ucm.fdi.avisos.util;

import java.util.ArrayList;
import java.util.List;

import es.ucm.fdi.avisos.business.entity.AvisoBuilder;
import es.ucm.fdi.avisos.business.entity.TipoAvisoEnum;

public class ValidacionAviso {

	static public List<String> ValidarAviso(AvisoBuilder aviso){
		List<String> errores = new ArrayList<String>();

		//Generales
		if (aviso.getComienzoPublicacion().isAfter(aviso.getFinPublicacion()) ){
			errores.add("Fecha inicio más tarde que fecha fin de publicación");
		}

		//URLs
		if (aviso.getTipoAviso().equals(TipoAvisoEnum.URL)){

		}
		//Adjunto
		else if (aviso.getTipoAviso().equals(TipoAvisoEnum.ADJUNTO)){
			if (aviso.getUrlDestino().length() == 0){
				errores.add("Anuncios tipo URL deben contener URL");
			}
		}
		//HTML
		else if (aviso.getTipoAviso().equals(TipoAvisoEnum.HTML)){

		}

		return errores;
	}
}
