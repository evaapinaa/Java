package Viajes;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Viaje implements Cloneable, Comparable<Viaje> {
	
	// CONSTANTE
	public static final int PLAZAS_OFRECIDAS = 1;
	
	// ATRIBUTOS
	private final String propietario;
	private final String coche;
	private final String ruta;
	private final LocalDate fechaSalida;
	private final int plazasOfrecidas;
	private List<Reserva> listaReservas;
	
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
		//return new LinkedList<Reserva>(listaReservas);
		// (List<Reserva>)(((LinkedList<Reserva>(listaReservas).clone())
		return Collections.unmodifiableList(listaReservas);
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

	
	// CONSTRUCTORES
	public Viaje(String propietario, String coche, String ruta, LocalDate fechaSalida, int plazasOfrecidas) {
		this.propietario = propietario;
		this.coche = coche;
		this.ruta = ruta;
		this.fechaSalida = fechaSalida;
		this.plazasOfrecidas = plazasOfrecidas;
		this.listaReservas = new LinkedList<Reserva>();
	}
	
	public Viaje(String propietario, String coche, String ruta, LocalDate fechaSalida) {
		this(propietario, coche, ruta, fechaSalida, PLAZAS_OFRECIDAS);
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

	@Override
	public String toString() {
		return getClass().getName()+"[propietario=" + propietario + ", coche=" + coche + ", ruta=" + ruta + ", fechaSalida="
				+ fechaSalida + ", plazasOfrecidas=" + plazasOfrecidas + ", listaReservas=" + listaReservas + "numero plazas reservadas" + getNumeroPlazasReservadas() + "plazas disponibles" + getPlazasDisponibles() + "]";
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
		// COPIA PROFUNDA
		copia.listaReservas = new LinkedList<Reserva>(listaReservas);
		return copia;
	}
	
	
	@Override
	public int compareTo(Viaje o2) {
		return this.getFechaSalida().compareTo(o2.getFechaSalida());
	}
	
	public List<Reserva> getListaReservas(Comparator<Reserva> criterio) {
		List<Reserva> resultado = getListaReservas();
		resultado.sort(criterio);
		return resultado;
	}
	}