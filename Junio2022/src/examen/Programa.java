package examen;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Programa {

	public static void main(String[] args) {
		
			List<Valoracion> lista = new LinkedList<>();
			Valoracion valor1 = new Valoracion("usuario1", 4, "muy bien");
			Valoracion valor2 = new Valoracion("usuario4", 2);
			Valoracion valor3 = new Valoracion("usuario3", 1, "mal");
			Valoracion valor4 = new Valoracion("usuario2", 5, "");
			
			lista.add(valor1);
			lista.add(valor2);
			lista.add(valor3);
			lista.add(valor4);
			
			// Expresion lambda
			lista.sort((v1, v2) -> v1.getUsuario().compareTo(v2.getUsuario()));
			for (Valoracion valoracion : lista) {
				System.out.println(valoracion.toString());
			}
			// Stream
			Set<String> conjunto = new HashSet<>();
			lista.stream()
				.map(u->u.getUsuario())
				.forEach(n -> conjunto.add(n));
			System.out.println("Usuarios que han realizado alguna valoración: ");
			for (String usuario: conjunto) {
				System.out.println("Usuario: "+usuario);
			}
			// ¿Todas las valoraciones tienen nota 5?
			System.out.println("¿Todas las valoraciones tienen nota 5?");
			boolean result = true;
			for (Valoracion valor : lista) {
				if (valor.getNota()<5) {
					result = false;
				}
			}
			System.out.println(result);

			
			//PREDICATE
			Restaurante restaurante = new Restaurante("Freiduría Paquiño");
			restaurante.addServicio(Tipo.COMIDA);
			
			List<Valoracion> listaUsuario1 = restaurante.getValoraciones(v -> v.getUsuario().equals("usuario1"));
			for (Valoracion valoracion : listaUsuario1) {
				System.out.println(valoracion.toString());
			}
			System.out.println(" "); 
	}

}
