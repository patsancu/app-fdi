package com.fdi.aplicacionWeb.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;
import org.joda.time.LocalDateTime;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

@Entity
public class Aviso {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long postInternalId;	

	@Size(min=4, max=50, message="{Size.Aviso.titulo.validation}")
	private String titulo;



	private String contenidoAviso;

	private String tipoDestino; //URL, archivo, contenidoPost

	private String tipoAviso; // Normal, importante

	private String etiqueta;

	private String urlDestino;	

	private Integer numeroVisitas;

	private String autor;

	private String duracionEstimada;

	private Integer numeroPlazas;

	private String lugar;

	private String Status;



	//Fechas

//	@Temporal(javax.persistence.TemporalType.TIMESTAMP)
//	//@DateTimeFormat(pattern="yyyy-mm-dd hh:mm")
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDateTime")
	private LocalDateTime fechaCreacion;

//	@Temporal(javax.persistence.TemporalType.TIMESTAMP)
//	@DateTimeFormat(pattern="yy-mm-dd hh:mm")
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDateTime")
	private LocalDateTime fechaEvento;	

//	@Temporal(javax.persistence.TemporalType.TIMESTAMP)
//	@DateTimeFormat(pattern="yy-mm-dd hh:mm")
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDateTime")
	//private Date fechaPublicacionInicio;
	private LocalDateTime fechaPublicacionInicio;

	//@Temporal(javax.persistence.TemporalType.TIMESTAMP)
	//@DateTimeFormat(pattern="yy-mm-dd hh:mm")
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDateTime")
	private LocalDateTime fechaPublicacionFin;
	
	

	
	@DateTimeFormat(pattern="yy-mm-dd")
	private String diaEvento;
	
	@DateTimeFormat(pattern="hh:mm")
	private String horaEvento;
	
	@DateTimeFormat(pattern="yy-mm-dd")
	private String diaPublicacionInicio;

	@DateTimeFormat(pattern="hh:mm")
	private String horaPublicacionInicio;

	@DateTimeFormat(pattern="yy-mm-dd")
	private String diaPublicacionFin;

	@DateTimeFormat(pattern="hh:mm")
	private String horaPublicacionFin;



	@Transient
	private MultipartFile adjunto;



	public long getPostInternalId() {
		return postInternalId;
	}



	public void setPostInternalId(long postInternalId) {
		this.postInternalId = postInternalId;
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



	public String getTipoDestino() {
		return tipoDestino;
	}



	public void setTipoDestino(String tipoDestino) {
		this.tipoDestino = tipoDestino;
	}



	public String getTipoAviso() {
		return tipoAviso;
	}



	public void setTipoAviso(String tipoAviso) {
		this.tipoAviso = tipoAviso;
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



	public Integer getNumeroVisitas() {
		return numeroVisitas;
	}



	public void setNumeroVisitas(Integer numeroVisitas) {
		this.numeroVisitas = numeroVisitas;
	}



	public String getAutor() {
		return autor;
	}



	public void setAutor(String autor) {
		this.autor = autor;
	}



	public String getDuracionEstimada() {
		return duracionEstimada;
	}



	public void setDuracionEstimada(String duracionEstimada) {
		this.duracionEstimada = duracionEstimada;
	}



	public Integer getNumeroPlazas() {
		return numeroPlazas;
	}



	public void setNumeroPlazas(Integer numeroPlazas) {
		this.numeroPlazas = numeroPlazas;
	}



	public String getLugar() {
		return lugar;
	}



	public void setLugar(String lugar) {
		this.lugar = lugar;
	}



	public String getStatus() {
		return Status;
	}



	public void setStatus(String status) {
		Status = status;
	}



	


	public String getDiaEvento() {
		return diaEvento;
	}



	public void setDiaEvento(String diaEvento) {
		this.diaEvento = diaEvento;
	}



	public String getHoraEvento() {
		return horaEvento;
	}



	public void setHoraEvento(String horaEvento) {
		this.horaEvento = horaEvento;
	}



	public String getDiaPublicacionInicio() {
		return diaPublicacionInicio;
	}



	public void setDiaPublicacionInicio(String diaPublicacionInicio) {
		this.diaPublicacionInicio = diaPublicacionInicio;
	}



	public String getHoraPublicacionInicio() {
		return horaPublicacionInicio;
	}



	public void setHoraPublicacionInicio(String horaPublicacionInicio) {
		this.horaPublicacionInicio = horaPublicacionInicio;
	}



	public String getDiaPublicacionFin() {
		return diaPublicacionFin;
	}



	public void setDiaPublicacionFin(String diaPublicacionFin) {
		this.diaPublicacionFin = diaPublicacionFin;
	}



	public String getHoraPublicacionFin() {
		return horaPublicacionFin;
	}



	public void setHoraPublicacionFin(String horaPublicacionFin) {
		this.horaPublicacionFin = horaPublicacionFin;
	}



	public MultipartFile getAdjunto() {
		return adjunto;
	}



	public void setAdjunto(MultipartFile adjunto) {
		this.adjunto = adjunto;
	}



	@Override
	public String toString() {
		return "Aviso [postInternalId=" + postInternalId + ", titulo=" + titulo
				+ ", contenidoAviso=" + contenidoAviso + ", tipoDestino="
				+ tipoDestino + ", tipoAviso=" + tipoAviso + ", etiqueta="
				+ etiqueta + ", urlDestino=" + urlDestino + ", numeroVisitas="
				+ numeroVisitas + ", autor=" + autor + ", duracionEstimada="
				+ duracionEstimada + ", numeroPlazas=" + numeroPlazas
				+ ", lugar=" + lugar + ", Status=" + Status
				+ ", fechaCreacion=" + fechaCreacion + ", fechaEvento="
				+ fechaEvento + ", fechaPublicacionInicio="
				+ fechaPublicacionInicio + ", fechaPublicacionFin="
				+ fechaPublicacionFin + ", diaEvento=" + diaEvento
				+ ", horaEvento=" + horaEvento + ", diaPublicacionInicio="
				+ diaPublicacionInicio + ", horaPublicacionInicio="
				+ horaPublicacionInicio + ", diaPublicacionFin="
				+ diaPublicacionFin + ", horaPublicacionFin="
				+ horaPublicacionFin + ", adjunto=" + adjunto + "]";
	}



	public LocalDateTime getFechaCreacion() {
		return fechaCreacion;
	}



	public void setFechaCreacion(LocalDateTime fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}



	public LocalDateTime getFechaEvento() {
		return fechaEvento;
	}



	public void setFechaEvento(LocalDateTime fechaEvento) {
		this.fechaEvento = fechaEvento;
	}



	public LocalDateTime getFechaPublicacionInicio() {
		return fechaPublicacionInicio;
	}



	public void setFechaPublicacionInicio(LocalDateTime fechaPublicacionInicio) {
		this.fechaPublicacionInicio = fechaPublicacionInicio;
	}



	public LocalDateTime getFechaPublicacionFin() {
		return fechaPublicacionFin;
	}



	public void setFechaPublicacionFin(LocalDateTime fechaPublicacionFin) {
		this.fechaPublicacionFin = fechaPublicacionFin;
	}

	



}
