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

public enum PrioridadesAvisoEnum {
	NORMAL("Normal"), IMPORTANTE("Importante");
	
	private String description;
	
	private PrioridadesAvisoEnum(String description) {
		this.description = description;
	}
	
	public String getDescription() {
		return description;
	}
	
	public String getValue() {
		return name();
	}
	
	@Override
	public String toString() {
		return description;
	}
}
