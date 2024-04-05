package examen;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class Utils {
	
	public static <T, R> Map<T, List<R>> clasificar(Collection<R> coleccion, Function<R, T> f) {
		Map<T,List<R>> resultado = new HashMap<T,List<R>>();
		
		for(R item : coleccion) {
			T clave = f.apply(item);
			if(!resultado.containsKey(clave)) {
				resultado.put(clave, new LinkedList<R>());
			}
			resultado.get(clave).add(item);
		}
		
		return resultado;
	}
	
}
