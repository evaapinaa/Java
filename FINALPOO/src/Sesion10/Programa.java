package Sesion10;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

public class Programa {

	public static void main(String[] args) {
		Random random = new Random();
		List<Integer> lista = new LinkedList<Integer>();
		
		for(int i=0;i<20;i++) {
			int aleatorio = random.nextInt(100);
			lista.add(aleatorio);
		}
		
		System.out.println("Ejercicio 1:");
		lista.stream().map(u->Integer.toHexString(u)).forEach(u->System.out.println(u));
		System.out.println("Ejercicio 2:");
		lista.stream().sorted((o1,o2)->-1*(o1.compareTo(o2))).map(u->Integer.toHexString(u)).forEach(u->System.out.println(u));
		System.out.println("Ejercicio 3:");
		long b = lista.stream().filter(u->u%2 == 0).count();
		System.out.println(b);
		System.out.println("Ejercicio 4:");
		Map<Integer, String> mapa = lista.stream()
	            .collect(Collectors.toMap(u -> u, u -> Integer.toHexString(u), (existing, replacement) -> existing));

		System.out.println(mapa);
		System.out.println("Ejercicio 5:");
		boolean c = lista.stream().anyMatch(u-> u >= 55 && u <= 60);
		System.out.println(c);
	}

}
