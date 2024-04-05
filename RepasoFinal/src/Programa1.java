import java.time.DayOfWeek;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import Repaso.Tramo;

public class Programa1 {

	public static void main(String[] args) {
		
		Tramo t1 = new Tramo(DayOfWeek.MONDAY, 9, 12);
        Tramo t2 = new Tramo(DayOfWeek.MONDAY, 15, 18);
        Tramo t3 = new Tramo(DayOfWeek.FRIDAY, 10, 14);
        Tramo t4 = new Tramo(DayOfWeek.SATURDAY, 8, 11);

		List<Tramo> tramos = new LinkedList<Tramo>();
		Collections.addAll(tramos, t1, t2, t3, t4);
		
		long cuenta = tramos.stream().filter(u->u.getDia().equals(DayOfWeek.MONDAY)).count();
		System.out.println("Hay "+cuenta+" tramos correspondientes a Lunes");
		
		boolean b = tramos.stream().anyMatch(u-> u.getDia().equals(DayOfWeek.SATURDAY) || u.getDia().equals(DayOfWeek.SUNDAY));
		System.out.println("¿Existe algún tramo correspondiente al fin de semana?: " + b);
	
	}

}
