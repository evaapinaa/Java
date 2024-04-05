import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ProcesoTelevoto {
	
	public final static Fases FASE_POR_DEFECTO = Fases.CONFIGURACION;
	public final static int VOTOS_POR_DEFECTO = 0;
	
	private final String descipcion;
	private final String organizador;
	private Fases fase;
	private final Collection<Persona> censo;
	private Map<String, Integer> votos;
	private Collection<Persona> votantes;
	
	public Collection<Persona> getCenso() {
		return Collections.unmodifiableCollection(censo);
	}
	public String getDescipcion() {
		return descipcion;
	}
	public Fases getFase() {
		return fase;
	}
	public Collection<String> getOpcionesVoto() {
		return votos.keySet();
	}
	public String getOrganizador() {
		return organizador;
	}
	public Collection<Persona> getVotantes() {
		return Collections.unmodifiableCollection(votantes);
	}
	public Map<String, Integer> getVotos() {
		return Collections.unmodifiableMap(votos);
	}
	public boolean isActivo() {
		if(!fase.equals(Fases.RESULTADOS)) {
			return true;
		}
		return false;
	}
	public int getNumeroElectores() {
		return censo.size();
	}
	
	public ProcesoTelevoto(String descipcion, String organizador, Collection<Persona> censo) {
		super();
		this.descipcion = descipcion;
		this.organizador = organizador;
		this.fase = FASE_POR_DEFECTO;
		this.censo = censo;
		this.votos = new HashMap<>();
		votos.put("abstencion", VOTOS_POR_DEFECTO);
		this.votantes = new HashSet<Persona>();
	}
	
	public Persona obtenerPersona(String dni) {
		if(dni == null) {
			throw new IllegalArgumentException("El dni no puede ser nulo");
		}
		if(dni.isEmpty()) {
			throw new IllegalArgumentException("El dni no puede ser una cadena vacía");
		}
		for(Persona p : censo) {
			if(p.getDni().equals(dni)) {
				return p;
			}
		}
		return null;
	}
	
	public boolean isPersonaCenso(String dni) {
		if(dni == null) {
			throw new IllegalArgumentException("El dni no puede ser nulo");
		}
		if(dni.isEmpty()) {
			throw new IllegalArgumentException("El dni no puede ser una cadena vacía");
		}
		for(Persona p : censo) {
			if(p.getDni().equals(dni)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean opcionVotar(String opcion) {
		if(!fase.equals(Fases.CONFIGURACION)) {
			throw new IllegalStateException("La fase debe estar en configuracion para esta funcionalidad");
		}
		if(opcion == null) {
			throw new IllegalArgumentException("El dni no puede ser nulo");
		}
		if(opcion.isEmpty()) {
			throw new IllegalArgumentException("El dni no puede ser una cadena vacía");
		}
		if(!getOpcionesVoto().contains(opcion)) {
			getOpcionesVoto().add(opcion);
			votos.put(opcion, 0);
			return true;
		}
		return false;
	}
	
	public boolean iniciarVotacion() {
		if(!fase.equals(Fases.CONFIGURACION)) {
			throw new IllegalStateException("La fase debe estar en configuracion para esta funcionalidad");
		}
		 if (getOpcionesVoto().size() >= 2) {
	            fase = Fases.VOTACION;
	            return true;
	        }
	        return false;
	}
	
	public boolean votar(String dni, String opcion) {
		if (!fase.equals(Fases.VOTACION)) {
            throw new IllegalStateException("Para votar la fase debe estar en votación");
        }
		if(dni == null) {
			throw new IllegalArgumentException("El dni no puede ser nulo");
		}
		if(dni.isEmpty()) {
			throw new IllegalArgumentException("El dni no puede ser una cadena vacía");
		}
		if(opcion == null) {
			throw new IllegalArgumentException("El dni no puede ser nulo");
		}
		if(opcion.isEmpty()) {
			throw new IllegalArgumentException("El dni no puede ser una cadena vacía");
		}
		Persona persona = obtenerPersona(dni);
        if (persona != null && !votantes.contains(persona) && getOpcionesVoto().contains(opcion)) {
            votos.put(opcion, votos.get(opcion) + 1);
            votantes.add(persona);
            return true;
        }
        return false;
	}
	
	public boolean votar(String dni) {
		if(dni == null) {
			throw new IllegalArgumentException("El dni no puede ser nulo");
		}
		if(dni.isEmpty()) {
			throw new IllegalArgumentException("El dni no puede ser una cadena vacía");
		}
		return votar(dni, "abstencion");
	}
	
	 public void finalizarVotacion() {
		 if (!fase.equals(Fases.VOTACION)) {
			 throw new IllegalStateException("Para finalizar la votación, la fase debe estar en votación");
		 }
		 fase = Fases.RESULTADOS;
	 }
	 
	 public List<Resultado> consultarResultados() {
		 if (!fase.equals(Fases.RESULTADOS)) {
			 throw new IllegalStateException("El proceso no está en la fase de resultados.");
	       }
		 return getVotos().keySet().stream().sorted((o1,o2) -> getVotos().get(o2) - getVotos().get(o1)).map(u->new Resultado(u, getVotos().get(u))).collect(Collectors.toList());
	 }
} 
