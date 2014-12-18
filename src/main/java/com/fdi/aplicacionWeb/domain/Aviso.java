package com.fdi.aplicacionWeb.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.Transient;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

@Entity
public class Aviso {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long postInternalId;	

	@Size(min=4, max=50, message="{Size.Aviso.titulo.validation}")
	private String titulo;
	
	@Temporal(javax.persistence.TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern="dd/MM/yyyy hh:mm")
	private Date fechaPublicacionInicio;
	
	@Temporal(javax.persistence.TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern="dd/MM/yyyy hh:mm")
	private Date fechaPublicacionFin;
	
	@Temporal(javax.persistence.TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern="dd/MM/yyyy hh:mm")
	private Date fechaCreacion;
	
	private String contenidoAviso;
	
	private String tipoDestino; //URL, archivo, contenidoPost
	
	private String tipoAviso; // Normal, importante
	
	private String etiqueta;
	
	private String urlDestino;	
	
	private String autor;
	
	private String lugar;
	
//	private int aforo;
	
	private String status;
	
//	private int numeroVisitas;
	
	private String duracionEstimada;

	
	@DateTimeFormat(pattern="yy-MM-dd")
	private String diaPublicacionInicio;

	@DateTimeFormat(pattern="hh:mm")
	private String horaPublicacionInicio;
	
	@DateTimeFormat(pattern="yy-MM-dd")
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

	public Date getFechaPublicacionInicio() {
		return fechaPublicacionInicio;
	}

	public void setFechaPublicacionInicio(Date fechaPublicacionInicio) {
		this.fechaPublicacionInicio = fechaPublicacionInicio;
	}

	public Date getFechaPublicacionFin() {
		return fechaPublicacionFin;
	}

	public void setFechaPublicacionFin(Date fechaPublicacionFin) {
		this.fechaPublicacionFin = fechaPublicacionFin;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
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

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getLugar() {
		return lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

//	public int getNumeroVisitas() {
//		return numeroVisitas;
//	}
//
//	public void setNumeroVisitas(int numeroVisitas) {
//		this.numeroVisitas = numeroVisitas;
//	}

	public String getDuracionEstimada() {
		return duracionEstimada;
	}

	public void setDuracionEstimada(String duracionEstimada) {
		this.duracionEstimada = duracionEstimada;
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

//	@Override
//	public String toString() {
//		return "Aviso [postInternalId=" + postInternalId + ", titulo=" + titulo
//				+ ", fechaPublicacionInicio=" + fechaPublicacionInicio
//				+ ", fechaPublicacionFin=" + fechaPublicacionFin
//				+ ", fechaCreacion=" + fechaCreacion + ", contenidoAviso="
//				+ contenidoAviso + ", tipoDestino=" + tipoDestino
//				+ ", tipoAviso=" + tipoAviso + ", etiqueta=" + etiqueta
//				+ ", urlDestino=" + urlDestino + ", autor=" + autor
//				+ ", lugar=" + lugar + ", status=" + status
//				+ ", numeroVisitas=" + numeroVisitas + ", duracionEstimada="
//				+ duracionEstimada + ", diaPublicacionInicio="
//				+ diaPublicacionInicio + ", horaPublicacionInicio="
//				+ horaPublicacionInicio + ", diaPublicacionFin="
//				+ diaPublicacionFin + ", horaPublicacionFin="
//				+ horaPublicacionFin + ", adjunto=" + adjunto + "]";
//	}


	
	
}
