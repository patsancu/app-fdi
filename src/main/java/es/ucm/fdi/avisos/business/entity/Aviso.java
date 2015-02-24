package es.ucm.fdi.avisos.business.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Aviso {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Size(min = 4, max = 50, message = "{Size.Aviso.titulo.validation}")
	private String titulo;

	private String contenidoAviso;

	@Enumerated(EnumType.ORDINAL)
	private TipoAvisoEnum tipoAviso;

	@Enumerated(EnumType.ORDINAL)
	private PrioridadesAvisoEnum prioridadAviso;

	private String etiqueta;

	private String autor;

	// Fechas

	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	@DateTimeFormat(pattern = "yyyy/mm/dd HH:mm")
	private DateTime fechaCreacion;
	
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	@DateTimeFormat(pattern = "yyyy/mm/dd HH:mm")
	private DateTime comienzoPublicacion;

	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	@DateTimeFormat(pattern = "yyyy/mm/dd HH:mm")
	private DateTime finPublicacion;

	private String adjunto;

	Aviso() {
		
	}
	
	Aviso(Long id) {
		this.id = id;
	}
	
	public Long getId() {
		return id;
	}

	private void setId(Long id) {
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

	public String getEtiqueta() {
		return etiqueta;
	}

	public void setEtiqueta(String etiqueta) {
		this.etiqueta = etiqueta;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getAdjunto() {
		return adjunto;
	}

	public void setAdjunto(String adjunto) {
		this.adjunto = adjunto;
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

	public TipoAvisoEnum getTipoAviso() {
		return tipoAviso;
	}

	public void setTipoAviso(TipoAvisoEnum tipoAviso) {
		this.tipoAviso = tipoAviso;
	}

	public PrioridadesAvisoEnum getPrioridadAviso() {
		return prioridadAviso;
	}

	public void setPrioridadAviso(PrioridadesAvisoEnum prioridadAviso) {
		this.prioridadAviso = prioridadAviso;
	}

	
}
