package examen;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class RestauranteAforo extends Restaurante {
	
	private static final int AFORO_DEFECTO = 30;
	private final int aforo;
	private Map<Servicio, Integer> ServicioPlazas;
	

	public RestauranteAforo(String nombre, int aforo) {
		super(nombre);
		this.aforo = aforo;
		this.ServicioPlazas = new HashMap<>();
	}
	public RestauranteAforo(String nombre) {
		this(nombre, AFORO_DEFECTO);
	}
	public int getAforo() {
		return aforo;
	}
	public Map<Servicio, Integer> getServicioPlazas() {
		return new HashMap<>(ServicioPlazas);
	}
	public void setServicioAforo(Map<Servicio, Integer> servicioPlazas) {
		ServicioPlazas = servicioPlazas;
	}
	
	@Override
	public boolean addServicio(Tipo tipo, LocalDate fecha) {
		Servicio servicio = new Servicio(tipo, fecha);
		ServicioPlazas.put(servicio, aforo);
		return super.addServicio(tipo, fecha);
	}
	
	@Override
	public boolean addServicio(Tipo tipo) {
		return addServicio(tipo, LocalDate.now());
	}
	
	@Override
	public String asistirServicio(Tipo tipo) {
		Servicio servicio = new Servicio(tipo, LocalDate.now());
		if (ServicioPlazas.containsKey(servicio) && ServicioPlazas.get(servicio)>0) {
			ServicioPlazas.put(servicio, ServicioPlazas.get(servicio)-1);
			return super.asistirServicio(tipo);
		} else {
			return null;
		}
	}

	public String asistirServicio(Tipo tipo, int asistentes) {
		Servicio servicio = new Servicio(tipo, LocalDate.now());
		if (ServicioPlazas.containsKey(servicio) && ServicioPlazas.get(servicio)-asistentes>=0) {
			ServicioPlazas.put(servicio, ServicioPlazas.get(servicio)-asistentes);
			return super.asistirServicio(tipo);
		}
		return null;
	}
	public int disponibilidad (Tipo tipo, LocalDate fecha) {
		Servicio servicio = new Servicio (tipo, fecha);
		int plazas = -1;
		if (ServicioPlazas.containsKey(servicio)) {
			plazas = ServicioPlazas.get(servicio);
		}
		return plazas;
	}
	
	@Override
	public RestauranteAforo clone() {
		return (RestauranteAforo)super.clone();
	}
	

}
