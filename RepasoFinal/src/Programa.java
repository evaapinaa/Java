import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import Repaso.Cita;

public class Programa {

	public static void main(String[] args) {
	    LocalDate fechaActual = LocalDate.now();
	    LocalDate ayer = fechaActual.minusDays(1);
	    LocalDate mañana = fechaActual.plusDays(2);
	    
	    Cita cita1 = new Cita("Paciente1", LocalDateTime.now());
	    Cita cita2 = new Cita("Paciente2", ayer, 14);
	    Cita cita3 = new Cita("Paciente3", mañana, 10);
	    Cita cita4 = new Cita("Paciente2", mañana, 12);
	    
	    List<Cita> citas = new LinkedList<Cita>();

	    Collections.addAll(citas, cita1, cita2, cita3, cita4);
	    
	    long c = citas.stream().filter(u-> u.getFechaHora().toLocalDate().equals(mañana)).count();
	    System.out.println("Número de citas para mañana: "+c);
	    
	    List<Cita> citasPaciente2 = citas.stream().filter(u->u.getPaciente().equals("Paciente2")).collect(Collectors.toList());
	    System.out.println(citasPaciente2);
	    
	}

}
