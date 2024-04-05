package Prueba;

import java.time.LocalDate;

public class Registro {
	private final String usuario;
	private final LocalDate entrada; //fecha de entrada
	
	public LocalDate getEntrada() {
		return entrada;
	}
	public String getUsuario() {
		return usuario;
	}
	
	public Registro(String usuario, LocalDate entrada) {
		super();
		this.usuario = usuario;
		this.entrada = entrada;
	}
	
	
}
