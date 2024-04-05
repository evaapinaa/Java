import java.text.ParseException;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Utilidad {
	
	public static <T> void poblarColeccion(Collection<T> c, Iterator<T> it) {
		while(it.hasNext()) {
			T objeto = it.next();
			c.add(objeto);
		}
	}
	
	public static List<Double> convertStringToDouble(String ... cadenas) throws ParseException {
		List<Double> lista = new LinkedList<>();
		for(String cadena : cadenas) {
			try {
				double numero = Double.parseDouble(cadena);
				lista.add(numero);
			} catch(NumberFormatException e) {
				throw new ParseException("Error en la conversion"+ e.getMessage(), 0);
			}
		}
		return lista;
	}
}
