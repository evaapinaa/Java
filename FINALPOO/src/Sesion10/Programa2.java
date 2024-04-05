package Sesion10;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Programa2 {

	public static void main(String[] args) {
		
		Registro registro1 = new Registro("Pedro",LocalDate.of(2023, 11, 11));
		Registro registro2 = new Registro("Juan",LocalDate.of(2023, 11, 4));
		Registro registro3 = new Registro("Martina",LocalDate.of(2023, 11, 12));
		Registro registro4 = new Registro("Andrea",LocalDate.of(2023, 11, 4));
		Registro registro5 = new Registro("Pedro",LocalDate.of(2023, 11, 12));
		
		List<Registro> lista = new LinkedList<Registro>();
		Collections.addAll(lista, registro1, registro2, registro3, registro4, registro5);
		
		System.out.println("Ejercicio 1: ");
		
		Set<Registro> conjunto = lista.stream().filter((Registro u)->{return u.getEntrada().isAfter(LocalDate.of(2023, 11, 10));}).collect(Collectors.toSet());
		System.out.println(conjunto);
		
		System.out.println("Ejercicio 2: ");
		lista.stream().filter(u->u.getEntrada().equals(LocalDate.of(2023,11,12))).sorted((o1,o2)->o1.getUsuario().compareTo(o2.getUsuario())).map(u->u.getUsuario()).forEach(u->System.out.println(u));
		
		System.out.println("Ejercicio 3: ");
		long n = lista.stream().filter(u->u.getEntrada().isAfter(LocalDate.of(2023, 11, 3)) && u.getEntrada().isBefore(LocalDate.of(2023, 11, 13))).map(u->u.getUsuario()).count();
		System.out.println(n);
		
		System.out.println("Ejercicio 4: ");
		boolean b = lista.stream().anyMatch(u->u.getEntrada().equals(LocalDate.of(2023, 11, 4)));
		System.out.println(b);
		
		doIf(lista,new ConsumerFake(), new PredicateFake());
		doIfGenerico(lista,new ConsumerFake(), new PredicateFake());
	}

	public static void doIf(List<Registro> lista, Consumer<Registro> c, Predicate<Registro> p) {
		Iterator<Registro> it = lista.iterator();
		while(it.hasNext()) {
			Registro r = it.next();
			if(p.test(r)) {
				c.accept(r);
			}
		}
	}
	
	public static <T> void doIfGenerico (List<T> lista, Consumer<T> c, Predicate<T> p) {
		Iterator<T> it = lista.iterator();
		while(it.hasNext()) {
			T r = it.next();
			if(p.test(r)) {
				c.accept(r);
			}
		}
	}
}
