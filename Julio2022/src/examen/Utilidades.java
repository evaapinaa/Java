package examen;

import java.util.Collection;

public class Utilidades {

	public static <T> boolean sonDisjuntos (Collection<T> col1, Collection<T> col2) {
		boolean resultado = true;
		for (T elemento : col1) {
			if (col2.contains(elemento)) {
				resultado=false;
			}
		}
		for (T elemento : col2) {
			if (col1.contains(elemento)) {
				resultado=false;
			}
		}
		return resultado;
	}
}