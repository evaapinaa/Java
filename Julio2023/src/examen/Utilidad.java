package examen;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Utilidad {

	public static <T,R> Map<T,R> entradas(Map<T,R> mapa1, Map<T,R> mapa2) {
		Map<T,R> resultado = new HashMap<T, R>();

        for (T key : mapa1.keySet()) {
            if (!mapa2.containsKey(key)) {
                resultado.put(key, mapa1.get(key));
            }
        }

        for (T key : mapa2.keySet()) {
            if (!mapa1.containsKey(key)) {
                resultado.put(key, mapa2.get(key));
            }
        }
        
		return resultado;
	}
	
	public static void touch(String...nombres) throws IOException {
		for(String n : nombres) {
			File fichero = new File(n);
			fichero.createNewFile();
		}
	}
	
	public static void touch2(String... nombres) {
	    for (String n : nombres) {
	        try {
	            File fichero = new File(n);
	            fichero.createNewFile();
	        } catch (IOException e) {
	            throw new RuntimeException("Error al crear archivo: " + n, e);
	        }
	    }
	}

}
