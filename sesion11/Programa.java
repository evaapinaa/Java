package sesion11;

import java.time.LocalDate;
import java.time.Month;
import java.util.Collections;
import java.util.LinkedList;

public class Programa {
		
	public static void main(String[] args) {
		LocalDate hoy = LocalDate.now();
				
		//Empleado con 2 años de trabajo en la empresa
		Funcionario e1 = new Funcionario("Andrés", LocalDate.of(1996, hoy.getMonth(), hoy.getDayOfMonth()),
											LocalDate.of(2021, 1, 1), Funcionario.SMI, CategoriaProfesional.C1);
		
		//Empleado contratado hoy
		Funcionario e2 = new Funcionario("Elvira", LocalDate.of(1998, hoy.getMonth(), hoy.getDayOfMonth()),
				LocalDate.now(), 1500, CategoriaProfesional.B);
		
		//Empleados con 25 años de trabajo en la empresa
		Funcionario e3 = new Funcionario("Rosario", LocalDate.of(1973, hoy.getMonth(), hoy.getDayOfMonth()),
											LocalDate.of(1998, 1, 1), 2800, CategoriaProfesional.A1);
		
		Funcionario e4 = new Funcionario("Rogelio", LocalDate.of(1973, Month.MAY, 10),
											LocalDate.of(1998, 6, 1), 2500, CategoriaProfesional.A2);
		
		//Empleado con 65 años
		Funcionario e5 = new Funcionario("Amaya",LocalDate.of(1958, Month.FEBRUARY, 24),
											LocalDate.of(1988, 1, 1), 3500, CategoriaProfesional.A1);
		
		LinkedList<Funcionario> funcionarios = new LinkedList<>();
		
		Collections.addAll(funcionarios, e1, e2, e3, e4, e5);
		
		//Escribe el mensaje "Felicidades {nombre}" para todos
		//los funcionarios que sea hoy su cumpleaños, ordenados
		//por orden alfabético
		
		funcionarios.stream().filter(u->u.getNacimiento().getMonth().equals(LocalDate.now().getMonth()) && u.getNacimiento().getDayOfMonth() == LocalDate.now().getDayOfMonth()).sorted((o1,o2)->o1.getNombre().compareTo(o2.getNombre())).map(u->u.getNombre()).forEach(u-> System.out.println("Felicidades "+u));
		
		// Sube un 5% el sueldo a todos los funcionarios con al menos 25 años de 
		// servicio. Muestra la colección de usuarios para comprobar el cambio.
		funcionarios.stream().filter(u->u.getAnyosServicio() >= 25).forEach(u-> u.subirSueldo(5));
		System.out.println(funcionarios);
		
		
		//Comprueba que no exista ningún funcionario que cobre menos del SMI
		boolean b = funcionarios.stream().noneMatch(u->u.getSalario()<Funcionario.SMI);
		System.out.println(b);
		
	
		//Muestra los funcionarios que cobran más del SMI ordenados
		//por categorías y a igualdad de categoría ordenador según
		// los años de servicio (de menos a mas).
		
		funcionarios.stream().filter(u->u.getSalario() > Funcionario.SMI)
		.sorted((o1,o2) -> {
			int x = o1.getCategoria().compareTo(o2.getCategoria());
			if(x == 0) {
				return o1.getAnyosServicio()-o2.getAnyosServicio();
			}
			return x;
		})
		.map(u->u.getNombre()).forEach(u->System.out.println(u));
		
		
		//Muestra en la consola cuantos empleados pueden jubilarse (65 años)
		long c = funcionarios.stream().filter(u->u.getEdad() >= 65).count();
		System.out.println(c);
	}

}
