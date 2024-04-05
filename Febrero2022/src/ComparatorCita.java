

import java.util.Comparator;

public class ComparatorCita implements Comparator<Cita>{
	
	@Override
	public int compare(Cita c1, Cita c2) {
		int c = c1.getFechaHora().compareTo(c2.getFechaHora());
		if(c == 0) {
			return c1.getPaciente().compareTo(c2.getPaciente());
		}
		return c;
	}
}
