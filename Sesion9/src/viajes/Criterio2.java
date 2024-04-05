package viajes;

import java.util.Comparator;

public class Criterio2 implements Comparator<Reserva>{

	@Override
	public int compare(Reserva o1, Reserva o2) {
		return o1.getCodigo().compareTo(o2.getCodigo());
	}

}
