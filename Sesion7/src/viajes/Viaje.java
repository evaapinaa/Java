package viajes;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Viaje implements Cloneable {
	
	// CONSTANTE
	public static final int PLAZAS_OFRECIDAS = 1;
	
	// ATRIBUTOS
	private final String propietario;
	private final String coche;
	private final String ruta;
	private final LocalDate fechaSalida;
	private final int plazasOfrecidas;
	private List<Reserva> listaReservas;
	private List<Integer> lista;
	
	// METODOS DE CONSULTA
	public String getPropietario() {
		return propietario;
	}

	public String getCoche() {
		return coche;
	}

	public String getRuta() {
		return ruta;
	}

	public LocalDate getFechaSalida() {
		return fechaSalida;
	}

	public int getPlazasOfrecidas() {
		return plazasOfrecidas;
	}

	public List<Reserva> getListaReservas() {
		return new LinkedList<Reserva>(listaReservas);
		// (List<Reserva>)(((LinkedList<Reserva>(listaReservas).clone())
	}

	public int getNumeroPlazasReservadas() {
		int suma = 0;
		for(Reserva c : listaReservas) {
			suma+=c.getNumeroPlazas();
		}
		return suma;
	}

	public int getPlazasDisponibles() {
		return plazasOfrecidas - getNumeroPlazasReservadas();
	}

	public List<Integer> getLista() {
		return lista;
	}
	
	// CONSTRUCTORES
	public Viaje(String propietario, String coche, String ruta, int año, int mes, int dia, int plazasOfrecidas) {
		this.propietario = propietario;
		this.coche = coche;
		this.ruta = ruta;
		this.fechaSalida = LocalDate.of(año, mes, dia);
		this.plazasOfrecidas = plazasOfrecidas;
		this.listaReservas = new LinkedList<Reserva>();
	}
	
	public Viaje(String propietario, String coche, String ruta, int año, int mes, int dia) {
		this.propietario = propietario;
		this.coche = coche;
		this.ruta = ruta;
		this.fechaSalida = LocalDate.of(año, mes, dia);
		this.plazasOfrecidas = PLAZAS_OFRECIDAS;
		this.listaReservas = new LinkedList<Reserva>();
	}
	
	// METODOS
	public Reserva realizarReserva(String usuario, int numPlazas) {
		if(getPlazasDisponibles() >= numPlazas && fechaSalida.isAfter(LocalDate.now())) {
			Reserva nuevaReserva = new Reserva(usuario, numPlazas);
			listaReservas.add(nuevaReserva);
			return nuevaReserva;
		}
		return null;
	}
	
	public Reserva consultarReserva(String codigoReserva) {
		for(Reserva r: listaReservas) {
			if(r.getCodigoReserva().equals(codigoReserva)) {
				return r;
			}
		}
		return null;
	}
	
	// AÑADIR ATRIBUTOS CALCULADOS
	@Override
	public String toString() {
		return getClass().getName()+ " [propietario=" + propietario + ", coche=" + coche + ", ruta=" + ruta + ", fechaSalida="
				+ fechaSalida + ", plazasOfrecidas=" + plazasOfrecidas + ", listaReservas=" + getListaReservas() + ", lista="
				+ lista + "]";
	}

	private Viaje copiaSuperficial() {
		try {
			Viaje copiaSuperficial = (Viaje) super.clone();
			return copiaSuperficial;
		} catch(CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public Viaje clone() {
		// COPIA SUPERFICIAL SOLO
		Viaje copia = copiaSuperficial() ;
		// COPIA PROFUNDA
		copia.lista = new ArrayList<Integer>(this.lista);
		return copia;
	}
}
