package es.ucm.fdi.acortador.business.entity;

import org.hibernate.validator.constraints.URL;
import org.joda.time.DateTime;
import org.springframework.beans.BeanUtils;
import org.springframework.format.annotation.DateTimeFormat;

import es.ucm.fdi.avisos.business.entity.Aviso;

public class URLredireccionBuilder {
	@URL
	private String url;

	@DateTimeFormat(pattern = "yyyy/MM/dd HH:mm")
	private DateTime caducidad;

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

	public DateTime getCaducidad() {
		return caducidad;
	}

	public void setCaducidad(DateTime caducidad) {
		this.caducidad = caducidad;
	}

}
