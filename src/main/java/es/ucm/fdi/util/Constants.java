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
package es.ucm.fdi.util;

public class Constants {
	
	// Reservas
	public static final String URL_REST_NUEVA_RESERVA = "/reservas/rest/nueva";	
	public static final String URL_NUEVA_RESERVA = "/reservas/nuevo";
	public static final String URL_LISTAR_RESERVAS = "/reservas";
	public static final String URL_RESERVA_INDIVIDUAL = "/reservas/{id}";
	public static final String URL_CALENDARIO_RESERVAS = "/reservas/calendario";
	
	// Redirecciones
	public static final String URL_REDIRECCIONES = "/u";
	public static final String URL_NUEVA_REDIRECCION = "/urls/nueva";
	public static final String URL_REST_NUEVA_REDIRECCION = "/urls/rest/nueva";
	public static final String URL_LISTAR_REDIRECCIONES = "/urls";
	
	// Avisos
	public static final String URL_NUEVO_AVISO = "/avisos/nuevo";
	public static final String URL_AVISO_INDIVIDUAL = "/avisos/{id}";
	public static final String URL_LISTAR_AVISOS = "/avisos";
	
	// Espacios
	public static final String URL_NUEVO_ESPACIO = "/espacios/nuevo";
	public static final String URL_LISTAR_ESPACIOS = "/espacios";
	public static final String URL_ESPACIO_INDIVIDUAL = "/espacios/{id}";
	
	//Tweets
	public static final String URL_TWITTER_USUARIO = "http://twitter.com/mortadeloTIA/status/";
	public static final String URL_REST_TWITTER = "/tweets/rest/";
	
	//Tutorias
	public static final String URL_LISTAR_TUTORIAS = "/tutorias";	
	public static final String URL_ADMIN_LISTAR_TUTORIAS = "/tutorias/admin";
	public static final String URL_NUEVA_TUTORIA = "/tutorias/nueva";
	public static final String URL_CONFIRMAR_TUTORIA = "/tutorias/confirmar";
}


