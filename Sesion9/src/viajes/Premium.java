package viajes;

import java.time.LocalDate;

public class Premium extends Viaje {

	public Premium(String propietario, String coche, String ruta, LocalDate salida, int plazas) {
		super(propietario, coche, ruta, salida,plazas);
	}
	public Premium(String propietario, String coche, String ruta, LocalDate salida) {
		this(propietario,coche,ruta,salida,PLAZAS_OFRECIDAS_POR_DEFECTO);
	}
	
	//FUNCIONALIDAD
	public boolean cancelar(String codigo) {
		Reserva r = getReservaCodigo(codigo);
		if(r!=null) {
			return getReservasProtegido().remove(r);			
		}
		return false;
	}
	
	
	
	@Override
	public Premium clone() {
		Premium copia = (Premium) super.clone();
		
		//PROFUNDA
		
		return copia;
	}
	
	
	
	
	
	
	
	
	
}
