package es.ucm.fdi.tutorias.business.entity;

import org.springframework.beans.BeanUtils;

public class TutoriaBuilder {
	private Long id;

	private String resumenDudas;

	private Long destinatario_id;

	private String asignatura;

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
	
	public Long getDestinatario_id() {
		return destinatario_id;
	}

	public void setDestinatario_id(Long destinatario_id) {
		this.destinatario_id = destinatario_id;
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
}
