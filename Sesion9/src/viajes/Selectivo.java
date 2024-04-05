package viajes;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class Selectivo extends Viaje {
	//PROPIEDADES
	private Set<String> vetados;
		
	//METODOS DE CONSULTA
	public Set<String> getVetados() {
		return new HashSet<>(vetados);
	}
	
	//CONSTRUCTOR
	public Selectivo(String propietario, String coche, String ruta, LocalDate salida, int plazas) {
		super(propietario, coche, ruta, salida,plazas);
		vetados = new HashSet<>();
	}
	
	public Selectivo(String propietario, String coche, String ruta, LocalDate salida) {
		this(propietario,coche,ruta,salida,PLAZAS_OFRECIDAS_POR_DEFECTO);
	}
	
	
	
	//FUNCIONALIDAD
	public void addVetado(String usuario) {
		vetados.add(usuario);
	}
	public void removeVetado(String usuario) {
		vetados.remove(usuario);
	}

	@Override
	public Reserva realizarReserva(String usuario, int nPlazas) {
		if(vetados.contains(usuario)) {
			return super.realizarReserva(usuario, nPlazas);
		}
		return null;
	}

	@Override
	public String toString() {
		return super.toString()+" [vetados=" + vetados + "]";
	}
	
	@Override
	public Selectivo clone() {
		Selectivo copia = (Selectivo) super.clone();
		
		//PROFUNDA
		copia.vetados = new HashSet<>(vetados);
		return copia;
	}
	
	
}
