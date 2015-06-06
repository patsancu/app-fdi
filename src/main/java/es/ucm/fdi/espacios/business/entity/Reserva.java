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

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Reserva {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@ManyToOne(optional=true)
	@JoinColumn(name="ESPACIO_ID")
	private Espacio espacio;
	
	private String titular;
	
	//Fechas
	
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	@DateTimeFormat(pattern = "yyyy/MM/dd HH:mm")
	private DateTime fechaCreacion;

	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	@DateTimeFormat(pattern = "yyyy/MM/dd HH:mm")
	private DateTime fechaInicio;

	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	@DateTimeFormat(pattern = "yyyy/MM/dd HH:mm")
	private DateTime fechaFin;
	
	private String aclaraciones;
	
//	@Enumerated(EnumType.ORDINAL)
//	private TipoEspacioEnum tipoEspacioEnum;

	public Reserva() {
		
	}
	
	public Reserva(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public DateTime getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(DateTime fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public DateTime getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(DateTime fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public DateTime getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(DateTime fechaFin) {
		this.fechaFin = fechaFin;
	}

	public String getAclaraciones() {
		return aclaraciones;
	}

	public void setAclaraciones(String aclaraciones) {
		this.aclaraciones = aclaraciones;
	}

//	public TipoEspacioEnum getTipoEspacioEnum() {
//		return tipoEspacioEnum;
//	}
//
//	public void setTipoEspacioEnum(TipoEspacioEnum tipoEspacioEnum) {
//		this.tipoEspacioEnum = tipoEspacioEnum;
//	}

	public Espacio getEspacio() {
		return espacio;
	}

	public void setEspacio(Espacio espacio) {
		this.espacio = espacio;
	}

	@Override
	public String toString() {
		return "Reserva [id=" + id + ", espacio=" + espacio + ", titular="
				+ titular + ", fechaCreacion=" + fechaCreacion
				+ ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin
				+ ", aclaraciones=" + aclaraciones + ", tipoEspacioEnum="
				+ "]";
	}
	
	
}
