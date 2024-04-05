package Viajes;

import java.time.LocalDate;

public class ViajePremium extends Viaje {
	
	// CONSTRUCTOR
	public ViajePremium(String propietario, String coche, String ruta, LocalDate fechaSalida, int numPlazas) {
		super(propietario, coche, ruta, fechaSalida, numPlazas);
		
	}
	
	// METODOS
	public boolean cancelarReservas(String codigoReserva) {
		if(getFechaSalida().isAfter(LocalDate.now())) {
			for(Reserva r: getListaReservas()) {
				if(r.getCodigoReserva().equals(codigoReserva)) {
					getListaReservas().remove(r);
					return true;
				}
			}
		}
		return false;
	}

	// NO HACE FALTA, NO HAY ATRIBUTOS NUEVOS
	@Override
	public String toString() {
		return super.toString();
	}
	
	@Override
	public ViajePremium clone() {
		ViajePremium copia = (ViajePremium)super.clone();
		
		return copia;
	}
}
