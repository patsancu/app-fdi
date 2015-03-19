package es.ucm.fdi.acortador.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AcortadorURL {
	

	static boolean local = true;
	
	public static boolean esUrlInterna(String url){
		
		//Fuerza la url sin protocolo
		String urlSinProtocolo = url;
		if (url.startsWith("http")){
			urlSinProtocolo = url.split("//")[1];
		}
		
		Pattern patternDev = Pattern.compile("localhost:[\\d]{4}/anuncios.*");
		Pattern patternRemoto = Pattern.compile("fdi.e-ucm.es/portal.*");
		Pattern pattern = patternDev;
		if (!local){
			pattern = patternRemoto; 
		}
		
		Matcher matcher = pattern.matcher(urlSinProtocolo);
        return matcher.matches();
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
