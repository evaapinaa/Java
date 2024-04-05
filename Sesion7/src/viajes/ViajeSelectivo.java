package viajes;

import java.util.HashSet;
import java.util.Set;

public class ViajeSelectivo extends Viaje  {
	
	// ATRIBUTOS
	private Set<String> usuariosVetados;
		
	// METODO CONSULTA Y MODIFICACION
	public Set<String> getUsuariosVetados() {
		return new HashSet<String>(usuariosVetados);
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
	public ViajeSelectivo(String propietario, String coche, String ruta, int año, int mes, int dia, int numPlazas) {
		super(propietario, coche, ruta, año, mes, dia, numPlazas);
		this.usuariosVetados= new HashSet<>();
	}
	
	public ViajeSelectivo(String propietario, String coche, String ruta, int año, int mes, int dia) {
		super(propietario, coche, ruta, año, mes, dia, PLAZAS_OFRECIDAS);
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
		return super.toString()+ " [usuariosVetados=" + usuariosVetados + "]";
	}
	
	@Override
	public ViajeSelectivo clone() {
		ViajeSelectivo copia = (ViajeSelectivo)super.clone();
		// COPIA PROFUNDA
		copia.usuariosVetados = new HashSet<>(usuariosVetados);
		return copia;
	}
	
	
}
