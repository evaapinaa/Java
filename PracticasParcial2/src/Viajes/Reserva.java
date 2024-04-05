package Viajes;

import java.time.LocalDate;
import java.util.UUID;

public class Reserva {
	
	// ATRIBUTOS
	private final String codigoReserva;
	private final String usuario;
	private final int numeroPlazas;
	private final LocalDate fechaReserva;
	
	// MÉTODOS CONSULTA
	public String getCodigoReserva() {
		return codigoReserva;
	}
	
	public String getUsuario() {
		return usuario;
	}
	
	public int getNumeroPlazas() {
		return numeroPlazas;
	}
	
	public LocalDate getFechaReserva() {
		return fechaReserva;
	}
	
	// CONSTRUCTOR
	public Reserva(String usuario, int numeroPlazas) {
		this.usuario = usuario;
		this.numeroPlazas = numeroPlazas;
		this.fechaReserva = LocalDate.now();
		this.codigoReserva = UUID.randomUUID().toString();
	}

	
	
}