package com.fdi.aplicacionWeb.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Aviso {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long postInternalId;	
	
	//@NotNull(message= "{NotNull.Aviso.titulo.validation}")
	@Size(min=4, max=50, message="{Size.Aviso.titulo.validation}")
	private String titulo;
	private Date fechaPublicacion;
	private Date fechaCreacion;
	private String contenidoAviso;
	private String tipoDestino; //URL, archivo, contenidoPost
	private String tipoAviso; // Normal, importante
	private String etiqueta;
	
	
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
	public void setContenidoAviso(String contenidoPost) {
		this.contenidoAviso = contenidoPost;
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
	@Override
	public String toString() {
		return "Aviso [postInternalId=" + postInternalId + ", titulo=" + titulo
				+ ", fechaPublicacion=" + fechaPublicacion + ", fechaCreacion="
				+ fechaCreacion + ", contenidoPost=" + contenidoAviso
				+ ", tipoDestino=" + tipoDestino + ", tipoAviso=" + tipoAviso
				+ ", etiqueta=" + etiqueta + "]";
	}
	
	
	
}
