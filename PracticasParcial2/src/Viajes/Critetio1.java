package Viajes;

import java.util.Comparator;

public class Critetio1 implements Comparator<Viaje>{
	
	@Override
	public int compare(Viaje v1, Viaje v2) {
		return v1.getRuta().compareTo(v2.getRuta());
	}
}
