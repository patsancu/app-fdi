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

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;
import org.springframework.beans.BeanUtils;
import org.springframework.format.annotation.DateTimeFormat;

public class ReservaBuilder {

	private Long id;

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

	@Enumerated(EnumType.ORDINAL)
	private TipoEspacioEnum tipoEspacioEnum;
	
	private Long id_espacio;
	
	public ReservaBuilder(){
		
	}
	
	public Reserva build(){
		Reserva nuevo = new Reserva(this.id);
		BeanUtils.copyProperties(this, nuevo);
		return nuevo;
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

	public TipoEspacioEnum getTipoEspacioEnum() {
		return tipoEspacioEnum;
	}

	public void setTipoEspacioEnum(TipoEspacioEnum tipoEspacioEnum) {
		this.tipoEspacioEnum = tipoEspacioEnum;
	}

	/**
	 * @return the id_espacio
	 */
	public Long getId_espacio() {
		return id_espacio;
	}

	/**
	 * @param id_espacio the id_espacio to set
	 */
	public void setId_espacio(Long id_espacio) {
		this.id_espacio = id_espacio;
	}

	@Override
	public String toString() {
		return "ReservaBuilder [id=" + id + ", titular=" + titular
				+ ", fechaCreacion=" + fechaCreacion + ", fechaInicio="
				+ fechaInicio + ", fechaFin=" + fechaFin + ", aclaraciones="
				+ aclaraciones + ", tipoEspacioEnum=" + tipoEspacioEnum
				+ ", id_espacio=" + id_espacio + "]";
	}
	
	
	
	

}
