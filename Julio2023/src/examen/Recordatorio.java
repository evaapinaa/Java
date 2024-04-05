package examen;

import java.time.LocalDateTime;

public class Recordatorio {
	
	public static final int ANTELACION_POR_DEFECTO = 30;
	
	private final Evento evento;
	private final LocalDateTime fechaHora;
	
	public Evento getEvento() {
		return evento;
	}
	public LocalDateTime getFechaHora() {
		return fechaHora;
	}
	
	public Recordatorio(Evento evento, LocalDateTime fechaHora) {
		super();
		this.evento = evento;
		this.fechaHora = fechaHora;
	}
	
	public Recordatorio(Evento evento, int antelacion) {
		this(evento,LocalDateTime.now().plusMinutes(antelacion));
	}
	
	public Recordatorio(Evento evento) {
		this(evento,LocalDateTime.now().plusMinutes(ANTELACION_POR_DEFECTO));
	}
	
}
