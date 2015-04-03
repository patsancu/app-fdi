package es.ucm.fdi.acortador.business.entity;

import org.springframework.beans.BeanUtils;

public class URLredireccionBuilder {
	
	private String url;

	public URLredireccionBuilder() {

	}
	
	public URLredireccion build() {
		URLredireccion redireccion = new URLredireccion();
		BeanUtils.copyProperties(this, redireccion);
		return redireccion;
	}
	
	public URLredireccionBuilder(URLredireccion urlRedireccion) {
		BeanUtils.copyProperties(urlRedireccion, this);
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
