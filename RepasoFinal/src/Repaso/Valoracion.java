package Repaso;

import java.time.LocalDate;

public class Valoracion {
	private final String usuario;
	private final LocalDate fechaCreacion;
	private final int nota;
	private final String comentario;
	
	public String getComentario() {
		return comentario;
	}
	public LocalDate getFechaCreacion() {
		return fechaCreacion;
	}
	public int getNota() {
		return nota;
	}
	public String getUsuario() {
		return usuario;
	}
	
	public Valoracion(String usuario, int nota, String comentario) {
		if(usuario == null) {
			throw new IllegalArgumentException("El usuario no puede ser null");
		}
		if(usuario.isEmpty()) {
			throw new IllegalArgumentException("El usuario no puede ser vacio");
		}
		if(nota > 5 || nota < 1) {
			throw new IllegalArgumentException("La nota debe ser un entero entre 1 y 5.");
		}

		this.usuario = usuario;
		this.fechaCreacion = LocalDate.now();
		this.nota = nota;
		this.comentario = comentario;
	}
	
	public Valoracion(String usuario, int nota) {
		this(usuario, nota, null);
	}
	@Override
	public String toString() {
		return getClass().getName()+"[usuario=" + usuario + ", fechaCreacion=" + fechaCreacion + ", nota=" + nota
				+ ", comentario=" + comentario + "]";
	}
	
	
	
	
	
	
}
