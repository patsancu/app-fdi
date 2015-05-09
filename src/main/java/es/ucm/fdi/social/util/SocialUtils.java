package es.ucm.fdi.social.util;

import org.jsoup.Jsoup;

import es.ucm.fdi.acortador.business.boundary.URLredirecciones;
import es.ucm.fdi.acortador.business.entity.URLredireccion;
import es.ucm.fdi.acortador.business.entity.URLredireccionBuilder;
import es.ucm.fdi.avisos.business.entity.Aviso;
import es.ucm.fdi.avisos.business.entity.TipoAvisoEnum;

public class SocialUtils {
	
	public static String crearTweet(URLredirecciones urlRedirecciones, Aviso aviso){
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
			textoTweet += "http://localhost:8088/anuncios/u/" + u.getSufijo();
		}
		return textoTweet;
	}
}
