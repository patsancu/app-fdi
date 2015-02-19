package es.ucm.fdi.espacios.business.domain;

import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

public class Espacio {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@OneToMany(mappedBy="reservas")
	private List<Reserva> espacios;
	
	private String nombreEspacio;
	
	private Integer aforo;
	
	private String notas;
	
	private TipoEspacioEnum tipoEspacio;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Reserva> getEspacios() {
		return espacios;
	}

	public void setEspacios(List<Reserva> espacios) {
		this.espacios = espacios;
	}

	public String getNombreEspacio() {
		return nombreEspacio;
	}

	public void setNombreEspacio(String nombreEspacio) {
		this.nombreEspacio = nombreEspacio;
	}

	public Integer getAforo() {
		return aforo;
	}

	public void setAforo(Integer aforo) {
		this.aforo = aforo;
	}

	public String getNotas() {
		return notas;
	}

	public void setNotas(String notas) {
		this.notas = notas;
	}

	public TipoEspacioEnum getTipoEspacio() {
		return tipoEspacio;
	}

	public void setTipoEspacio(TipoEspacioEnum tipoEspacio) {
		this.tipoEspacio = tipoEspacio;
	}
	
	
	
	
}
