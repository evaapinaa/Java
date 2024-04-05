package Bitacora;

import java.time.LocalDate;

public class Entrada implements Comparable<Entrada>{
	
	private final String suceso;
	private final LocalDate fecha;
	
	public LocalDate getFecha() {
		return fecha;
	}
	
	public String getSuceso() {
		return suceso;
	}
	
	public Entrada(String suceso) {
		super();
		this.suceso = suceso;
		this.fecha = LocalDate.now();	
	}
	
	
	@Override
	public String toString() {
		return "Entrada [suceso=" + suceso + ", fecha=" + fecha + "]";
	}

	@Override
	public int compareTo(Entrada o2) {
		int c = this.getFecha().compareTo(o2.getFecha());
		if (c == 0) {
			return -1*(this.getSuceso().compareTo(o2.getSuceso()));
		}
		return c;
	}
	
}
