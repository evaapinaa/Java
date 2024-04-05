package viajes;

import java.util.Comparator;

public class ComparadorViajes implements Comparator<Viaje>{

	@Override
	public int compare(Viaje o1, Viaje o2) {
		return o1.getRuta().compareTo(o2.getRuta());
	}

	
}
