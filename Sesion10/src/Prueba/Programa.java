package Prueba;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

public class Programa {

	public static void main(String[] args) {
		List<Integer> lista = new LinkedList<Integer>();
		Random random = new Random();
		for(int i=0;i<20;i++) {
			int n = random.nextInt(100); // [0,100)
			lista.add(n);
		}
		
		// EXPRESIONES LAMBDA
		lista.stream().map(i->Integer.toHexString(i)).forEach(t -> System.out.println(t));
		lista.stream().map(i->{return Integer.toHexString(i);}).forEach(t -> System.out.println(t));
		// REFERENCIAS A MÉTODOS
		lista.stream().map(Integer::toHexString).forEach(System.out::println);
		
		lista.stream().map(Integer::toHexString).sorted((o1,o2)->{return o2.compareTo(o1);}).forEach(System.out::println);
		
		lista.stream().filter(n -> (n%2) == 0).forEach(System.out::println);
		
		Map<Integer,String> mapa = new HashMap<Integer, String>();
		lista.stream().forEach(i->mapa.put(i,Integer.toHexString(i)));
		Set<Integer> noRep = new HashSet<Integer>(lista);
		Map<Integer,String> m = noRep.stream().collect(Collectors.toMap(i->i, i->Integer.toHexString(i)));
		System.out.println("Mapa"+mapa);
		System.out.println("Mapa"+m);
		
		boolean b1 = lista.stream().anyMatch(i-> 55 < i && i < 60);
		System.out.println("Hay algún numero entre 55 y 60: "+b1);
		/*
		 * for(Integer i : lista) {
		 * 		mapa.put(i,Integer.toHexString(i));
		 * }
		 * 
		 * */
	}

}
