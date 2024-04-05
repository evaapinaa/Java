package Prueba;

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
		List<Registro> lista = new LinkedList<Registro>();
		Collections.addAll(lista, 
				new Registro("Pedro",LocalDate.of(2023, 11, 11)),
				new Registro("Juan",LocalDate.of(2023, 11, 4)),
				new Registro("Martina",LocalDate.of(2023, 11, 12)),
				new Registro("Andrea",LocalDate.of(2023, 11, 4)),
				new Registro("Pedro",LocalDate.of(2023, 11, 12)));
		
		Set<String> usuarios = lista.stream().filter(x->x.getEntrada().isAfter(LocalDate.of(2023, 11, 10))).map(t->t.getUsuario()).collect(Collectors.toSet());
		lista.stream().filter(x->x.getEntrada().equals(LocalDate.of(2023, 11, 10))).map(x->x.getUsuario()).sorted().forEach(x -> System.out.println(x));;
		
		long cont = lista.stream().filter(x->x.getEntrada().isAfter(LocalDate.of(2023, 11, 3)) && x.getEntrada().isBefore(LocalDate.of(2023, 11, 12))).count();
		System.out.println(cont);
		
		boolean b1 = lista.stream().anyMatch(x->x.getEntrada().equals(LocalDate.of(2023,11,4)));
		System.out.println("Algún usuario ha reservado el 4/11/2023: "+b1);
	
		doIf(lista,r->System.out.println(r),r->r.getEntrada().isEqual(LocalDate.of(2023,11, 12)));
		
	}
	// Ejercicio 2
	public static void doIf(List<Registro> lista, Consumer<Registro> c, Predicate<Registro> p) {
		Iterator<Registro> it = lista.iterator();
		while(it.hasNext()) {
			Registro r=it.next();
			if(p.test(r)) {
				c.accept(r);
			}
		}
	}
	
	public static <T> void doIfGenerico(List<T> lista, Consumer<T> c, Predicate<T> p) {
		Iterator<T> it = lista.iterator();
		while(it.hasNext()) {
			T r=it.next();
			if(p.test(r)) {
				c.accept(r);
			}
		}
	}
	
	

}
