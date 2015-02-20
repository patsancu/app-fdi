package es.ucm.fdi.espacios.business.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Espacio {
	@Override
	public String toString() {
		return "Espacio [id=" + id + ", reservas=" + reservas
				+ ", nombre=" + nombre + ", aforo=" + aforo
				+ ", notas=" + notas + ", tipoEspacio=" + tipoEspacio + "]";
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@OneToMany(mappedBy="espacio")
	private List<Reserva> reservas;
	
	private String nombre;
	
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

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombreEspacio) {
		this.nombre = nombreEspacio;
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
