package utilidades;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Utilidades {
	/*
	 * Febrero 2012
	   La moda es el valor o valores de una serie de números que más veces 
       se repite. Por ejemplo, la moda de la serie {2, 3, 3, 3, 4, 5, 4, 6, 4} es {3, 4}. En el caso 
       de  que  no  se  repita  ningún  valor  la  serie  no  tiene  moda.  Implementa  un  método  que 
       reciba como parámetro una serie de números de tamaño variable y devuelva la moda de dicha serie. 
	 */
	 
	public static <T> List<T> getModa(T... valores) {
	    Map<T, Integer> mapaContadores = new HashMap<>();
	    int maxCount = 0;

	    // Contar las ocurrencias de cada valor
	    for (T valor : valores) {
	        int count = mapaContadores.getOrDefault(valor, 0) + 1;
	        mapaContadores.put(valor, count);
	        maxCount = Math.max(maxCount, count);
	    }

	    // Si la moda es 1 (o si no hay valores), significa que no hay moda
	    if (maxCount <= 1) return null;

	    // Encuentra todos los valores con el conteo máximo
	    List<T> resultado = new ArrayList<>();
	    for (Map.Entry<T, Integer> entry : mapaContadores.entrySet()) {
	        if (entry.getValue() == maxCount) {
	            resultado.add(entry.getKey());
	        }
	    }

	    return resultado;
	}

	/*
	Junio 2017
	Escribe un método que calcule las posiciones en las que se encuentran los 
	elementos de una lista de cadenas. Por ejemplo, si tenemos la lista [“hola”, “adiós”, 
	“hola”, “bye”, “bye”], debe retornar un mapa que asocie cada cadena encontrada en la 
	lista  con las posiciones en la que ha sido encontrada: {“hola” -> [0, 2], 
												  			 “adiós”-> [1], 
												  			 “bye”  -> [3, 4]}
	- Una vez resuelto para cadenas de texto se puede generalizar y convertirlo en un método genérico.
	*/	
	public static <T> Map<T,List<Integer>> getPosiciones(T...cadenas) {
		Map<T,List<Integer>> resultado = new HashMap<T,List<Integer>>();
		
		for(int i = 0; i<cadenas.length; i++) {
			T cadena = cadenas[i];
			if(!resultado.containsKey(cadena)) {
				resultado.put(cadena, new ArrayList<Integer>());
			}
			resultado.get(cadena).add(i);
		}
		return resultado;
	}
	
	/*
	Febrero 2015.
	Escribe un método genérico que reciba como parámetro una colección de elementos
	y retorne una nueva colección formada por los elementos de la original sin repetidos. 
	*/
	
	public static <T> Collection<T> eliminarRepetidos(Collection<T> coleccion) {
		return new HashSet<T>(coleccion);
	}
	

	/*
	Junio 2016.
	Implementa un método genérico que reciba como parámetros una lista y 
	un  valor  de  un  elemento.  La  funcionalidad  del  método  consiste  en  borrar  todas  las 
	ocurrencias  en  la  lista  de  elementos  iguales  al  pasado  como  parámetro.  El  método 
	devolverá el número de ocurrencias que se han borrado. Se establece como requisito 
	utilizar un iterador explícito para el procesamiento de la lista.
	*/
	public static <T> int eliminarOcurrencias(List<T> lista, T elemento) {
		int contador = 0;
		Iterator<T> it = lista.iterator();
		while(it.hasNext()) {
			T e = it.next();
			if(e.equals(elemento)) {
				it.remove();
				contador++;
			}
		}
		return contador;
	}
	
}
	