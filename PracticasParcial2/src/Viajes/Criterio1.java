package Viajes;

import java.util.Comparator;

public class Criterio1 implements Comparator<Reserva>{
	
	@Override
	public int compare(Reserva r1, Reserva r2) {
		int c = r1.getUsuario().compareTo(r2.getUsuario());
		if (c == 0) return r2.getFechaReserva().compareTo(r2.getFechaReserva());
		return c;
	}
}
