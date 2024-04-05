package Viajes;

import java.util.Comparator;

public class Criterio2 implements Comparator<Reserva> {
	
	@Override 
	public int compare(Reserva r1, Reserva r2) {
		return r1.getCodigoReserva().compareTo(r2.getCodigoReserva());
	}
}
