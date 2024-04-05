package examen;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;


public class Utilidades {
	
	public static <T> Collection<T> objetosAlmacenados(Map<String, Collection<T>> mapa) {
		Collection<T> resultado = new HashSet<T>();
		for(String s : mapa.keySet()) {
			resultado.addAll(mapa.get(s));
		}
		return resultado;
	}
	
	public static LocalDate getFecha() {
        try (Scanner sc = new Scanner(System.in)) {
            int intentos = 3;
            LocalDate fecha = null;

            while (intentos > 0) {
                System.out.println("Introduce una fecha en formato año-mes-día (por ejemplo, \"2023-01-17\"): ");
                String texto = sc.nextLine();

                try {
                    fecha = LocalDate.parse(texto);
                    break;
                } catch (DateTimeParseException e) {
                    System.err.println("Formato incorrecto " + e.getMessage());
                    intentos--;
                    if (intentos == 0) {
                        System.out.println("Has agotado tus intentos. Se utilizará el formato por defecto.");
                        fecha = LocalDate.now();
                    }
                }
            }
            return fecha;
        } catch (Exception e) {
            e.printStackTrace();
            return LocalDate.now();
        }
    }
	
}
