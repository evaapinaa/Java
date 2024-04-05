package examen;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Calendario {
	
	private final String nombre;
	private final Map<Evento,List<Recordatorio>> eventos;
	
	public List<Evento> getEventos() {
		return new ArrayList<>(eventos.keySet());
	}
	public String getNombre() {
		return nombre;
	}
	public int getNumeroEventos() {
		return getEventos().size();
	}
	public List<Recordatorio> obtenerTodosRecordatorios() {
        List<Recordatorio> todosRecordatorios = new ArrayList<>();
        for (List<Recordatorio> recordatorios : eventos.values()) {
            todosRecordatorios.addAll(recordatorios);
        }
        return todosRecordatorios;
    }
	
	public Calendario(String nombre) {
		super();
		this.nombre = nombre;
		this.eventos = new HashMap<>();
	}
	
	public List<Recordatorio> obtenerTodosRecordatorios(Evento evento) {
		List<Recordatorio> todosRecordatorios = new ArrayList<>();
		for(Evento e : eventos.keySet()) {
			if(e.equals(evento)) {
				todosRecordatorios.addAll(eventos.get(e));
			}
		}
		return todosRecordatorios;
    }
	
	private boolean verificarSolapamiento(Evento nuevoEvento) {
        for (Evento evento : eventos.keySet()) {
            if (nuevoEvento.solapaTiempo(evento)) {
                return true;
            }
        }
        return false;
    }
	
	public Evento añadirEvento(String nombre, LocalDateTime inicio, int minutos) {
		if(nombre == null) {
			throw new IllegalArgumentException("El nombre no puede ser nulo");
		}
		if(nombre.isEmpty()) {
			throw new IllegalArgumentException("El nombre no puede estar vacio");
		}
		if(inicio == null) {
			throw new IllegalArgumentException("El inicio no puede ser nulo");
		}
		if(minutos <= 0) {
			throw new IllegalArgumentException("El numero de minutos tiene que ser un entero mayor que 0");
		}
		Evento e = new Evento(nombre, inicio, inicio.plusMinutes(minutos));
		if(verificarSolapamiento(e)) {
			throw new IllegalStateException("El nuevo evento no se puede solapar con ninguno otro");
		}
		eventos.put(e, new ArrayList<>());
		return e;
	}
	
	public Evento añadirEvento(String nombre, LocalDate fecha) {
		return añadirEvento(nombre, fecha.atStartOfDay(), 24*3600);
	}
	
	public boolean borrarEvento(Evento e) {
		if(eventos.containsKey(e)) {
			eventos.remove(e);
			return true;
		}
		return false;
	}
	
	public Recordatorio crearRecordatorio(Evento e, int min) {
		if(eventos.containsKey(e)) {
			 Recordatorio nuevoRecordatorio = new Recordatorio(e, min);
		     List<Recordatorio> recordatorios = eventos.get(e);
		     for(Recordatorio r : recordatorios) {
		    	 if(r.getFechaHora().equals(nuevoRecordatorio.getFechaHora())) return null;
		        }
		     recordatorios.add(nuevoRecordatorio);
			return nuevoRecordatorio;
			}
		return null;
	}
	
	public Recordatorio crearRecordatorio(Evento e) {
		return crearRecordatorio(e, Recordatorio.ANTELACION_POR_DEFECTO);
	}
	
	public List<Evento> getEventosFuturos() {
		return eventos.keySet().stream().filter(u->u.getInicio().isAfter(LocalDateTime.now())).sorted((o1,o2)->o1.getInicio().compareTo(o2.getInicio())).collect(Collectors.toList());
	}
}
