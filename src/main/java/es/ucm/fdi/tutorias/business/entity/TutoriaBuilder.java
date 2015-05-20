package es.ucm.fdi.tutorias.business.entity;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;
import org.springframework.beans.BeanUtils;
import org.springframework.format.annotation.DateTimeFormat;

public class TutoriaBuilder {

	private Long id;

	private String resumenDudas;

	private String destinatarioUsername;	

	private String asignatura;

	// Fechas

	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	@DateTimeFormat(pattern = "yyyy/mm/dd HH:mm")
	private DateTime fechaCreacion;

	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	@DateTimeFormat(pattern = "yyyy/mm/dd HH:mm")
	private DateTime comienzoTutoria;

	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	@DateTimeFormat(pattern = "yyyy/mm/dd HH:mm")
	private DateTime finTutoria;

	/**
	 * @return the asignatura
	 */
	public String getAsignatura() {
		return asignatura;
	}

	/**
	 * @param asignatura the asignatura to set
	 */
	public void setAsignatura(String asignatura) {
		this.asignatura = asignatura;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getResumenDudas() {
		return resumenDudas;
	}

	public void setResumenDudas(String resumenDudas) {
		this.resumenDudas = resumenDudas;
	}

	public TutoriaBuilder(){

	}

	public TutoriaBuilder(Tutoria tutoria){
		BeanUtils.copyProperties(tutoria, this);
	}

	public Tutoria build(){
		Tutoria nuevo = new Tutoria();
		BeanUtils.copyProperties(this, nuevo);
		return nuevo;
	}

	/**
	 * @return the destinatarioUsername
	 */
	public String getDestinatarioUsername() {
		return destinatarioUsername;
	}

	/**
	 * @param destinatarioUsername the destinatarioUsername to set
	 */
	public void setDestinatarioUsername(String destinatarioUsername) {
		this.destinatarioUsername = destinatarioUsername;
	}

	public DateTime getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(DateTime fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public DateTime getComienzoTutoria() {
		return comienzoTutoria;
	}

	public void setComienzoTutoria(DateTime comienzoTutoria) {
		this.comienzoTutoria = comienzoTutoria;
	}

	public DateTime getFinTutoria() {
		return finTutoria;
	}

	public void setFinTutoria(DateTime finTutoria) {
		this.finTutoria = finTutoria;
	}
}
