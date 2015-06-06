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
package es.ucm.fdi.acortador.business.entity;

import org.springframework.beans.BeanUtils;

public class URLredireccionBuilder {
	
	private String url;

	public URLredireccionBuilder() {

	}
	
	public URLredireccion build() {
		URLredireccion redireccion = new URLredireccion();
		BeanUtils.copyProperties(this, redireccion);
		return redireccion;
	}
	
	public URLredireccionBuilder(URLredireccion urlRedireccion) {
		BeanUtils.copyProperties(urlRedireccion, this);
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
