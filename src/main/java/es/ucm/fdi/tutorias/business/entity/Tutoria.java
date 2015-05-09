package es.ucm.fdi.tutorias.business.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;

import es.ucm.fdi.users.business.entity.User;

@Entity
public class Tutoria {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Size(min = 4, max = 100, message = "{error.tutoria.resumen.size}")
	private String resumenDudas;
	
	@ManyToOne(optional=true)
	@JoinColumn(name="EMISOR_ID")
	private User emisor;
	
	@ManyToOne(optional=true)
	@JoinColumn(name="DESTINATARIO_ID")
	private User destinatario;
	
	private boolean confirmada;
	
	private String asignatura;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getResumenDudas() {
		return resumenDudas;
	}

	public void setResumenDudas(String resumen_dudas) {
		this.resumenDudas = resumen_dudas;
	}

	public User getEmisor() {
		return emisor;
	}

	public void setEmisor(User emisor) {
		this.emisor = emisor;
	}

	public User getDestinatario() {
		return destinatario;
	}

	public void setDestinatario(User destinatario) {
		this.destinatario = destinatario;
	}

	public boolean isConfirmada() {
		return confirmada;
	}

	public void setConfirmada(boolean confirmada) {
		this.confirmada = confirmada;
	}

	public String getAsignatura() {
		return asignatura;
	}

	public void setAsignatura(String asignatura) {
		this.asignatura = asignatura;
	}

	@Override
	public String toString() {
		return "Tutoria [id=" + id + ", resumenDudas=" + resumenDudas
				+ ", emisor=" + emisor + ", destinatario=" + destinatario
				+ ", confirmada=" + confirmada + ", asignatura=" + asignatura
				+ "]";
	}
	
	
	
	

}