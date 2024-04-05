package Bitacora;

import java.util.Comparator;

public class ComparatorFecha implements Comparator<Entrada> {

	@Override
	public int compare(Entrada e1, Entrada e2) {
		return  (e1.getFecha().compareTo(e2.getFecha()));
	}
}
