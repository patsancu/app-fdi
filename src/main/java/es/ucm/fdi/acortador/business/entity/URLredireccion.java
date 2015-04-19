package es.ucm.fdi.acortador.business.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import es.ucm.fdi.users.business.entity.User;

@Entity
public class URLredireccion {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private boolean interna;
	private String urlOriginal;
	private String sufijo;
	
	
	private Integer numeroVisitas;
	@ManyToOne(optional=true)
	@JoinColumn(name="USER_ID")
	private User creador;
	
	

	public URLredireccion() {
		numeroVisitas = 0;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public boolean isInterna() {
		return interna;
	}

	public void setInterna(boolean interna) {
		this.interna = interna;
	}

	public String getUrlOriginal() {
		return urlOriginal;
	}

	public void setUrlOriginal(String urlOriginal) {
		this.urlOriginal = urlOriginal;
	}

	public String getSufijo() {
		return sufijo;
	}

	public void setSufijo(String sufijo) {
		this.sufijo = sufijo;
	}

	public Integer getNumeroVisitas() {
		return numeroVisitas;
	}

	public void setNumeroVisitas(Integer numeroVisitas) {
		this.numeroVisitas = numeroVisitas;
	}

	public User getCreador() {
		return creador;
	}

	public void setCreador(User creador) {
		this.creador = creador;
	}
	
	
}
