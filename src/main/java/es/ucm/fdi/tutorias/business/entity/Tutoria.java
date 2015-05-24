package es.ucm.fdi.tutorias.business.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;

import es.ucm.fdi.users.business.entity.User;

@Entity
public class Tutoria {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Size(min = 4, max = 512, message = "{error.tutoria.resumen.size}")
	@Column(length=512)
	private String resumenDudas;
	
	@ManyToOne(optional=true)
	@JoinColumn(name="EMISOR_ID")
	private User emisor;
	
	@ManyToOne(optional=true)
	@JoinColumn(name="DESTINATARIO_ID")
	private User destinatario;
	
	private boolean confirmada;
	
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

	@Override
	public String toString() {
		return "Tutoria [id=" + id + ", resumenDudas=" + resumenDudas
				+ ", emisor=" + emisor + ", destinatario=" + destinatario
				+ ", confirmada=" + confirmada + ", asignatura=" + asignatura
				+ "]";
	}
	
	
	
	

}