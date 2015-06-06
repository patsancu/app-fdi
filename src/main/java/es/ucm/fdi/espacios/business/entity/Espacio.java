/**
 * This file is part of Portal Web de la FDI.
 *
 * Portal Web de la FDI is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Portal Web de la FDI is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with Portal Web de la FDI.  If not, see <http://www.gnu.org/licenses/>.
 */
package es.ucm.fdi.espacios.business.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
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
	@Column(name="ESPACIO_ID")
	private Long id;
	
	@OneToMany(mappedBy="espacio", cascade={CascadeType.ALL}, fetch=FetchType.EAGER)
	private List<Reserva> reservas;
	
	private String nombre;
	
	private Integer aforo;
	
	private String notas;
	
	@Enumerated(EnumType.ORDINAL)
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
