package viajes;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Viaje implements Cloneable, Comparable<Viaje>{
	//CONSTANTE
	public static final int PLAZAS_OFRECIDAS_POR_DEFECTO = 1;
	//PROPIEDADES
	private final String propietario;
	private final String coche;
	private final String ruta;
	private final LocalDate salida;
	private final int plazasOfrecidas;
	private List<Reserva> reservas;
	
	//plazas reservadas		-> propiedad calculada
	//plazas disponibles	-> propiedad calculada
	
	//METODOS DE CONSULTA
	public int getPlazasReservadas() {
		int contador = 0;
		for(Reserva r: reservas) {
			contador+=r.getPlazas();
		}
		return contador;
	}
	public int getPlazasDisponibles() {
		return plazasOfrecidas - getPlazasReservadas();
	}
	public String getPropietario() {
		return propietario;
	}
	public String getCoche() {
		return coche;
	}
	public String getRuta() {
		return ruta;
	}
	public LocalDate getSalida() {
		return salida;
	}
	public int getPlazasOfrecidas() {
		return plazasOfrecidas;
	}
	public List<Reserva> getReservas() { //En la declaración de los métodos utilizamos las interfaces de las colecciones en vez de la clase de implementación.
		//Evitamos el aliasing en los atributos de tipo colección utilizando alguna de las 3 opciones: 
		
		//OP1: constructor copia 
		return new LinkedList<Reserva>(reservas);
		//OP2: método clone
		//return (List<Reserva>)(((LinkedList<Reserva>)reservas).clone());
		//OP3: vista no modificable
		//return Collections.unmodifiableList(reservas);
	}

	protected List<Reserva> getReservasProtegido(){
		return reservas;
	}
	
	//CONSTRUCTORES
	
	public Viaje(String propietario, String coche, String ruta, LocalDate salida, int plazasOfrecidas) {
		super();
		this.propietario = propietario;
		this.coche = coche;
		this.ruta = ruta;
		this.salida = salida;
		this.plazasOfrecidas = plazasOfrecidas;
		reservas = new LinkedList<Reserva>();
	}
	public Viaje(String propietario, String coche, String ruta, LocalDate salida) {
		this(propietario,coche,ruta,salida,PLAZAS_OFRECIDAS_POR_DEFECTO);
	}
	
	//FUNCIONALIDAD
	public Reserva realizarReserva(String usuario, int nPlazas) {
		if(getPlazasDisponibles()>=nPlazas && LocalDate.now().isBefore(salida)) {
			Reserva r = new Reserva(usuario,nPlazas);
			reservas.add(r);
			return r;
		}
		return null;
	}
	
	
	public Reserva getReservaCodigo(String codigo) {
		Reserva resultado = null;
		for(Reserva r: reservas) {
			if(r.getCodigo().equals(codigo)) {
				resultado = r;
				break;
			}
		}
		return resultado;
	}
	
	
	@Override
	public String toString() {
		return getClass().getSimpleName()+" [propietario=" + propietario + ", coche=" + coche + ", ruta=" + ruta + ", salida=" + salida
				+ ", plazasOfrecidas=" + plazasOfrecidas + ", reservas=" + reservas + ", plazas reservadas="
				+ getPlazasReservadas() + ", plazas disponibles=" + getPlazasDisponibles() + "]";
	}
	
	
	
	private Viaje getCopiaSuperficial() {
		try {
			Viaje copiaSuperficial = (Viaje)super.clone();
			return copiaSuperficial;
		}catch(CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public Viaje clone() {
		Viaje copia = getCopiaSuperficial();
		
		//PROFUNDA
		copia.reservas = new LinkedList<Reserva>(reservas);
				//(LinkedList<Reserva>)((LinkedList<Reserva>)reservas).clone(); 
				
		return copia;
	}
	
	@Override
	public int compareTo(Viaje o) {
		return this.getSalida().compareTo(o.getSalida());
	}
	
	public List<Reserva> getReservas(Comparator<Reserva> cReserva) {
		List<Reserva> resultado = getReservas();
		resultado.sort(cReserva);
		return resultado;
	}

	
	
	
	
	
	
	
	
	
}
