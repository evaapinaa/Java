package Sesion10;

import java.time.LocalDate;

public class Registro {
	private final String usuario;
	private final LocalDate entrada;
	
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
	@Override
	public String toString() {
		return getClass().getName()+"[usuario=" + usuario + ", entrada=" + entrada + "]";
	}
	
	
}
