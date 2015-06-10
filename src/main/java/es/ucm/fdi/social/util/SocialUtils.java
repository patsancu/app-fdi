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
package es.ucm.fdi.social.util;

import org.jsoup.Jsoup;

import es.ucm.fdi.acortador.business.boundary.URLredirecciones;
import es.ucm.fdi.acortador.business.entity.URLredireccion;
import es.ucm.fdi.acortador.business.entity.URLredireccionBuilder;
import es.ucm.fdi.avisos.business.entity.Aviso;
import es.ucm.fdi.avisos.business.entity.TipoAvisoEnum;

public class SocialUtils {
	
	public static String crearTweet(URLredirecciones urlRedirecciones, Aviso aviso, String path){
		String textoTweet = aviso.getTitulo();		
		if (aviso.getTipoAviso() == TipoAvisoEnum.HTML){
			textoTweet += " - ";
			textoTweet += Jsoup.parse(aviso.getContenidoAviso()).text();
		}
		String etiqueta = aviso.getEtiqueta();
		if ( etiqueta!= null && ! "".equalsIgnoreCase(etiqueta) ){
			textoTweet += " - ";
			textoTweet += "#" + etiqueta; 
		}
		String url = aviso.getUrlDestino();
		if (aviso.getTipoAviso() == TipoAvisoEnum.URL || (url != null && ! "".equalsIgnoreCase(url) )){
			textoTweet += " - ";
			URLredireccionBuilder urlRedireccion = new URLredireccionBuilder();
			urlRedireccion.setUrl(aviso.getUrlDestino());
			URLredireccion u = urlRedirecciones.addURLredireccion(urlRedireccion);
			textoTweet += path + u.getSufijo();
		}
		return textoTweet;
	}
}
