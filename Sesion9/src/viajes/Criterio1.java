package viajes;

import java.util.Comparator;

public class Criterio1 implements Comparator<Reserva>{

	@Override
	public int compare(Reserva o1, Reserva o2) {
		if(o1.getUsuario().compareTo(o2.getUsuario()) == 0) {
			return o1.getFecha().compareTo(o2.getFecha());
		}
		return o1.getUsuario().compareTo(o2.getUsuario());
	}
}
