package es.ucm.fdi.espacios.business.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Espacio {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@OneToMany(mappedBy="espacio")
	private List<Reserva> reservas;
	
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

	
	public List<Reserva> getReservas() {
		return reservas;
	}

	public void setReservas(List<Reserva> reservas) {
		this.reservas = reservas;
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
