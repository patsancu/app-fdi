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
package es.ucm.fdi.avisos.business.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
public class Aviso {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Size(min = 4, max = 50, message = "{Size.Aviso.titulo.validation}")
	private String titulo;

	@Column(length=512)
	private String contenidoAviso;

	@Enumerated(EnumType.ORDINAL)
	private TipoAvisoEnum tipoAviso;

	@Enumerated(EnumType.ORDINAL)
	private PrioridadesAvisoEnum prioridadAviso;

	private String etiqueta;

	@ManyToOne(optional=true)
	@JoinColumn(name="USER_ID")
	private User autor;
	
	private String urlDestino;
	
	private Long idTweetAsociado;
	
	private Long idAutorTwitterAsociado;

	// Fechas

	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	@DateTimeFormat(pattern = "yyyy/mm/dd HH:mm")
	private DateTime fechaCreacion;
	
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	@DateTimeFormat(pattern = "yyyy/mm/dd HH:mm")
	private DateTime comienzoPublicacion;

	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	@DateTimeFormat(pattern = "yyyy/mm/dd HH:mm")
	private DateTime finPublicacion;

	private String adjunto;

	public Aviso() {
		this.idAutorTwitterAsociado = (long) 0;
		this.idTweetAsociado = (long) 0;
	}
	
	Aviso(Long id) {
		this.id = id;
	}
	
	public Long getId() {
		return id;
	}

	private void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getContenidoAviso() {
		return contenidoAviso;
	}

	public void setContenidoAviso(String contenidoAviso) {
		this.contenidoAviso = contenidoAviso;
	}

	public String getEtiqueta() {
		return etiqueta;
	}

	public void setEtiqueta(String etiqueta) {
		this.etiqueta = etiqueta;
	}
	

	public User getAutor() {
		return autor;
	}

	public void setAutor(User autor) {
		this.autor = autor;
	}

	public String getAdjunto() {
		return adjunto;
	}

	public void setAdjunto(String adjunto) {
		this.adjunto = adjunto;
	}

	public DateTime getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(DateTime fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public DateTime getComienzoPublicacion() {
		return comienzoPublicacion;
	}

	public void setComienzoPublicacion(DateTime comienzoPublicacion) {
		this.comienzoPublicacion = comienzoPublicacion;
	}

	public DateTime getFinPublicacion() {
		return finPublicacion;
	}

	public void setFinPublicacion(DateTime finPublicacion) {
		this.finPublicacion = finPublicacion;
	}

	public TipoAvisoEnum getTipoAviso() {
		return tipoAviso;
	}

	public void setTipoAviso(TipoAvisoEnum tipoAviso) {
		this.tipoAviso = tipoAviso;
	}

	public PrioridadesAvisoEnum getPrioridadAviso() {
		return prioridadAviso;
	}

	public void setPrioridadAviso(PrioridadesAvisoEnum prioridadAviso) {
		this.prioridadAviso = prioridadAviso;
	}

	public Long getIdTweetAsociado() {
		return idTweetAsociado;
	}

	public void setIdTweetAsociado(Long idTweetAsociado) {
		this.idTweetAsociado = idTweetAsociado;
	}

	public Long getIdAutorTwitterAsociado() {
		return idAutorTwitterAsociado;
	}

	public void setIdAutorTwitterAsociado(Long idAutorTwitterAsociado) {
		this.idAutorTwitterAsociado = idAutorTwitterAsociado;
	}

	/**
	 * @return the urlDestino
	 */
	public String getUrlDestino() {
		return urlDestino;
	}

	/**
	 * @param urlDestino the urlDestino to set
	 */
	public void setUrlDestino(String urlDestino) {
		this.urlDestino = urlDestino;
	}

	
}
