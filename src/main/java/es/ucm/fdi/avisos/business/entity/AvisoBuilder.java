package es.ucm.fdi.avisos.business.entity;

import javax.validation.constraints.Size;

import org.joda.time.DateTime;
import org.springframework.beans.BeanUtils;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

public class AvisoBuilder {

	private Long id;

	@Size(min = 4, max = 50, message = "{Size.Aviso.titulo.validation}")
	private String titulo;

	private String contenidoAviso;

	private TipoAvisoEnum tipoAviso;

	private PrioridadesAvisoEnum prioridadAviso;

	private String etiqueta;

	private String urlDestino;

	private String autor;

	private DateTime fechaCreacion;
	
	@DateTimeFormat(pattern = "yyyy/MM/dd HH:mm")
	private DateTime comienzoPublicacion;

	@DateTimeFormat(pattern = "yyyy/MM/dd HH:mm")
	private DateTime finPublicacion;

	private MultipartFile adjunto;
	
	public AvisoBuilder() {
		
	}
	
	public AvisoBuilder(Aviso aviso) {
		BeanUtils.copyProperties(aviso, this);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getContenidoAviso() {
		return contenidoAviso;
	}

	public void setContenidoAviso(String contenidoAviso) {
		this.contenidoAviso = contenidoAviso;
	}

	public TipoAvisoEnum getTipoAviso() {
		return tipoAviso;
	}

	public void setTipoAviso(TipoAvisoEnum tipoAviso) {
		this.tipoAviso = tipoAviso;
	}
	
	public TipoAvisoEnum[] getTiposAviso() {
		return TipoAvisoEnum.values();
	}
	
	public PrioridadesAvisoEnum getPrioridadAviso() {
		return prioridadAviso;
	}

	public void setPrioridadAviso(PrioridadesAvisoEnum prioridadAviso) {
		this.prioridadAviso = prioridadAviso;
	}
	
	public PrioridadesAvisoEnum[] getPrioridadesAviso() {
		return PrioridadesAvisoEnum.values();
	}

	public String getEtiqueta() {
		return etiqueta;
	}

	public void setEtiqueta(String etiqueta) {
		this.etiqueta = etiqueta;
	}

	public String getUrlDestino() {
		return urlDestino;
	}

	public void setUrlDestino(String urlDestino) {
		this.urlDestino = urlDestino;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}
	
	public DateTime getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(DateTime fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public DateTime getComienzoPublicacion() {
		return comienzoPublicacion;
	}

	public void setComienzoPublicacion(DateTime comienzoPublicacion) {
		this.comienzoPublicacion = comienzoPublicacion;
	}

	public DateTime getFinPublicacion() {
		return finPublicacion;
	}

	public void setFinPublicacion(DateTime finPublicacion) {
		this.finPublicacion = finPublicacion;
	}

	public MultipartFile getAdjunto() {
		return adjunto;
	}

	public void setAdjunto(MultipartFile adjunto) {
		this.adjunto = adjunto;
	}
	
	public Aviso build() {
		Aviso result = new Aviso(this.id);
		BeanUtils.copyProperties(this, result);
		return result;
	}
}
