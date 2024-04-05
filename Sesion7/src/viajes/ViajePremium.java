package viajes;

import java.time.LocalDate;

public class ViajePremium extends Viaje {
	
	// CONSTRUCTOR
	public ViajePremium(String propietario, String coche, String ruta, int año, int mes, int dia, int numPlazas) {
		super(propietario, coche, ruta, año, mes, dia, numPlazas);
		
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

    // NO HAY QUE REDEFINIRLO SI NO HAY
	@Override
	public String toString() {
		return super.toString();
	}
	
	
}
