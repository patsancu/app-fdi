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
package es.ucm.fdi.acortador.util;

import java.net.MalformedURLException;
import java.net.URL;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AcortadorURL {
	
	private static final Logger logger = LoggerFactory
			.getLogger("AcortadorURL");
	
	private static final String nombresLocal [] = {"localhost", "fdi.e-ucm.es"};
	
	static boolean local = true;
	
	public static boolean esUrlInterna(String url){
		try {
			URL urlParseada = new URL(url);		
			boolean interna = false;
			for (String host: nombresLocal){
				interna = interna || host.equals(urlParseada.getHost());				
			}
			logger.warn("Es local? "+ interna);
			return interna;
		} catch (MalformedURLException e) {
			e.printStackTrace();
			return false;
		}
	}

	/* Para que las URLs no sean tan fácilmente enumerables,
	 se crea un hash (muy simple) de entero a entero.
	 */
	public static long knuthHash(long num){
		long factor = 2654435761l;
		//se añade el uno para que el id de 0 tenga hash != 0.
		return (long) (((num + 1) * factor) % Math.pow(2,32));
	}

	/*
	 * http://crockford.com/wrmg/base32.html
	 * */
	public static String codificarBase32(long numero){
		char [] alphabet = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F','G','H','J','K','M','N','P','Q','R','S','T','V','W','X','Y','Z'};
		long res = numero;
		long resto;
		StringBuilder resultado = new StringBuilder();

		while (res > 0){
			long temp = (long) (res / 32.0);
			resto = (long) (res % 32.0);
			res = temp;
			resultado.append(alphabet[(int) resto]);
		}
		return resultado.reverse().toString();
	}
	
	public static String generarHashId(Long id){
		return codificarBase32(knuthHash(id));
	}


}
