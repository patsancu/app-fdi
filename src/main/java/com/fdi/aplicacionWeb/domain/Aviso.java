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
	private Date fechaPublicacion;
	@Temporal(javax.persistence.TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern="dd/MM/yyyy hh:mm")
	private Date fechaCreacion;
	private String contenidoAviso;
	private String tipoDestino; //URL, archivo, contenidoPost
	private String tipoAviso; // Normal, importante
	private String etiqueta;
	private String urlDestino;

	@Transient
	private int mes;
	@Transient
	private String dia;
	@Transient
	private int anyo;
	@Transient
	private String hora;
	@Transient
	private int minuto;
	@Transient
	private int segundo;

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




	public Date getFechaPublicacion() {
		return fechaPublicacion;
	}




	public void setFechaPublicacion(Date fechaPublicacion) {
		this.fechaPublicacion = fechaPublicacion;
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




	public int getMes() {
		return mes;
	}




	public void setMes(int mes) {
		this.mes = mes;
	}




	public String getDia() {
		return dia;
	}




	public void setDia(String dia) {
		this.dia = dia;
	}




	public int getAnyo() {
		return anyo;
	}




	public void setAnyo(int anyo) {
		this.anyo = anyo;
	}




	public String getHora() {
		return hora;
	}




	public void setHora(String hora) {
		this.hora = hora;
	}




	public int getMinuto() {
		return minuto;
	}




	public void setMinuto(int minuto) {
		this.minuto = minuto;
	}




	public int getSegundo() {
		return segundo;
	}




	public void setSegundo(int segundo) {
		this.segundo = segundo;
	}




	public MultipartFile getAdjunto() {
		return adjunto;
	}




	public void setAdjunto(MultipartFile adjunto) {
		this.adjunto = adjunto;
	}




	public String getUrlDestino() {
		return urlDestino;
	}




	public void setUrlDestino(String urlDestino) {
		this.urlDestino = urlDestino;
	}




	@Override
	public String toString() {
		return "Aviso [postInternalId=" + postInternalId + ", titulo=" + titulo
				+ ", fechaPublicacion=" + fechaPublicacion + ", fechaCreacion="
				+ fechaCreacion + ", contenidoPost=" + contenidoAviso
				+ ", tipoDestino=" + tipoDestino + ", tipoAviso=" + tipoAviso
				+ ", etiqueta=" + etiqueta + "]";
	}



}
