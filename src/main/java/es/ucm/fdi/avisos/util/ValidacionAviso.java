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
