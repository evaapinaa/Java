package examen;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CalendarioAutomatico extends Calendario{
	
	private final int minutosAntelacion;
	private Map<Evento, List<Evento>> seriesEventos;
	
	public int getMinutosAntelacion() {
		return minutosAntelacion;
	}
	
	public CalendarioAutomatico(String nombre, int minutos) {
		super(nombre);
		this.minutosAntelacion = minutos;
	}
	
	public void registrarSerieEventos(String nombre, LocalDate inicio, int repeticiones) {
		Evento eventoInicial = new Evento(nombre, inicio.atStartOfDay(), inicio.atStartOfDay().plusDays(1));
		List<Evento> serie= new ArrayList<>();
		serie.add(eventoInicial);
		for(int i = 1; i<= repeticiones; i++) {
			Evento e2 = new Evento(nombre, inicio.atStartOfDay(), inicio.atStartOfDay().plusYears(i));
			serie.add(e2);
		}
		seriesEventos.put(eventoInicial, serie);
	}
	
	public boolean borrarEvento(Evento evento) {
	    boolean eventoEncontrado = false;

	    // Buscar si el evento es el inicial de alguna serie
	    if (seriesEventos.containsKey(evento)) {
	        seriesEventos.remove(evento);
	        eventoEncontrado = true;
	    } else {
	        for (List<Evento> serieEventos : seriesEventos.values()) {
	            if (serieEventos.contains(evento)) {
	                serieEventos.remove(evento); // Eliminar el evento de la serie
	                eventoEncontrado = true;
	                break;
	            }
	        }
	    }

	    return eventoEncontrado;
	}
	
	public Collection<Evento> consultarEventosHoy() {
		return seriesEventos.values().stream().flatMap(List::stream).filter(u->u.getInicio().toLocalDate().isEqual(LocalDate.now())).collect(Collectors.toList());

	}
	
	public void añadirRecordatorios(int antelacion) {
		seriesEventos.values().stream().flatMap(List::stream).filter(u->u.getInicio().isAfter(LocalDateTime.now())).forEach(u-> {
																													//LocalDateTime fechaRecordatorio = u.getInicio().minusMinutes(minutosAntelacion);
																													//Recordatorio recordatorio = new Recordatorio(u, fechaRecordatorio);
																													//añadirRecordatorios(antelacion)
																												 });
	}
	
}
