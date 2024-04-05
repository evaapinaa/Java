package examen;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Utilidades {

	public static List<LocalDate> notificar(String...cadenas) {
		List<LocalDate> lista = new LinkedList<LocalDate>();
		for(String cadena : cadenas) {
			try {
				LocalDate fecha = LocalDate.parse(cadena);
				lista.add(fecha);
			} catch(DateTimeParseException e) {
				lista.add(null);
			}
		}
		return lista;
	}
	
	public static <T> Set<T> interseccion (Set<T> conjunto1, Set<T> conjunto2){
		Set<T> conjunto = new HashSet<>();
		for (T elemento: conjunto1) {
			if (conjunto2.contains(elemento)) {
				conjunto.add(elemento);
			}
		}
		for (T elemento: conjunto2) {
			if (conjunto1.contains(elemento)) {
				conjunto.add(elemento);
			}
		}
		return conjunto;
	}
	

}
