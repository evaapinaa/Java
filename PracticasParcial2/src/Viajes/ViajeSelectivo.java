package Viajes;

import java.time.LocalDate;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class ViajeSelectivo extends Viaje  {
	
	// ATRIBUTOS
	private Set<String> usuariosVetados;
		
	// METODO CONSULTA Y MODIFICACION
	public Set<String> getUsuariosVetados() {
		//return new HashSet<String>(usuariosVetados);
		return Collections.unmodifiableSet(usuariosVetados);
	}
	
	public void setUsuariosVetados(Set<String> usuariosVetados) {
		this.usuariosVetados = usuariosVetados;
	}
	
	public void add(String usuario) {
		usuariosVetados.add(usuario);
	}
	
	public void remove(String usuario) {
		usuariosVetados.remove(usuario);
	}
	
	// CONSTRUCTOR
	public ViajeSelectivo(String propietario, String coche, String ruta, LocalDate fechaSalida, int numPlazas) {
		super(propietario, coche, ruta, fechaSalida, numPlazas);
		this.usuariosVetados= new HashSet<>();
	}
	
	public ViajeSelectivo(String propietario, String coche, String ruta, LocalDate fechaSalida) {
		super(propietario, coche, ruta, fechaSalida, PLAZAS_OFRECIDAS);
	}
	
	@Override
	public Reserva realizarReserva(String usuario, int numPlazas) {
		if (usuariosVetados.contains(usuario)) {
            return null;
        }
		return super.realizarReserva(usuario, numPlazas);
	}

	@Override
	public String toString() {
		return super.toString()	+ "[ usuarios vetados = " + getUsuariosVetados()
				+ "]";
	}
	
	@Override
	public ViajeSelectivo clone() {
		ViajeSelectivo copia = (ViajeSelectivo)super.clone();
		
		// COPIA PROFUNDA
		copia.usuariosVetados = new HashSet<String>(usuariosVetados); 
		return copia;
	}


	
}
