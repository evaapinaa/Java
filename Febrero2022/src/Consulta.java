import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Predicate;

public class Consulta implements Cloneable {
// IMPORTANTE: definir constantes para los valores por defecto
	
	private static final int HORA_INICIO_DEFECTO = 9;
	private static final int HORA_CIERRE_DEFECTO = 20;
	private static final int CUPO_DEFECTO = 4;
	
	private String medico;
	private int horaInicio; // valor entre 0 y 23
	private int horaCierre; // valor entre 0 y 23
	private Set<String> pacientes;
	private TreeSet<Cita> citas;
	private Set<LocalDate> fechas;
	private int cupo;
	
	
	public String getMedico() {
		return medico;
	}
	public int getHoraInicio() {
		return horaInicio;
	}
	public int getHoraCierre() {
		return horaCierre;
	}
	public Set<String> getPacientes() {
		return new TreeSet<String>(pacientes);
	}
	public TreeSet<Cita> getCitas() {
		return new TreeSet<Cita>(citas);
	}
	public Set<LocalDate> getFechas() {
		return new TreeSet<LocalDate>(fechas);
	}
	public int getCupo() {
		return cupo;
	}
	public void setMedico(String medico) {
		this.medico = medico;
	}
	public void setHoraInicio(int horaInicio) {
		this.horaInicio = horaInicio;
	}
	public void setHoraCierre(int horaCierre) {
		this.horaCierre = horaCierre;
	}
	public void setCupo(int cupo) {
		this.cupo = cupo;
	}
	public boolean registrar (String paciente) {
		return pacientes.add(paciente);
	}
	public boolean baja (String paciente) {
		return pacientes.remove(paciente);
	}
	public boolean addFecha (LocalDate fecha) {
		if (fecha.isEqual(LocalDate.now()) || fecha.isAfter(LocalDate.now())) {
			return fechas.add(fecha);
		}
		return fechas.add(fecha);
	}
	public int numCitas (LocalDate fecha, int hora) {
		int contador=0;
		for (Cita cita : this.citas) {
		if (cita.getFechaHora().isEqual(LocalDateTime.of(fecha.getYear(),fecha.getMonthValue(), fecha.getDayOfMonth(), hora, 0))) {
			contador++;
			}
		}
		return contador;
	}
	public boolean hayHueco (LocalDate fecha, int hora) {
		if (fechas.contains(fecha) && getHoraInicio()<=hora && hora<=getHoraCierre() && numCitas(fecha, hora)<=getCupo())
			return true;
		return false;
	}
	public boolean hayHueco (int hora) {
		return hayHueco(LocalDate.now(), hora);
	}
	public Cita registrarCita (String paciente, LocalDate fecha, int hora) {
		if (pacientes.contains(paciente) && hayHueco(fecha, hora)) {
				Cita cita = new Cita(paciente, fecha, hora);
				citas.add(cita);
				return cita;
		}
		return null;
		
	}
	
	private Consulta copiaSuperficial() {
		try {
			Consulta copiaSuperficial = (Consulta)super.clone();
			return copiaSuperficial;
		} catch (CloneNotSupportedException e) {
			System.err.println("La clase no es cloneable");
		}
		return null;
	}
	
		@Override
	public Consulta clone() {
		Consulta copia = copiaSuperficial();
		// Corregimos el aliasing
		copia.pacientes = getPacientes();
		copia.citas = getCitas();
		copia.fechas = getFechas();
		return copia;
	}

	public Consulta(String medico, int horaInicio, int horaCierre, int cupo, LocalDate ...fechas) {
		//2d: Condición 1: medico (cuidado con los String: comprobar si es null o vacio)
		if (medico==null || medico=="") {
			throw new IllegalArgumentException("El medico tiene que ser una cadena de texto no vacía");
		}
		this.medico = medico;
		// Condición 2: hora inicio entre 0 y 23 y menor que la hora de cierre
		if ((horaInicio<0 || horaInicio>23) && horaInicio<horaCierre) {
			throw new IllegalArgumentException("La hora de incio tiene que ser anterior a la hora de cierre y estar comprendida entre las 0 y 23 horas");
		}
		this.horaInicio = horaInicio;
		// Condicion 3: hora cierre entre 0 y 23
		if (horaCierre<0 || horaCierre>23) {
			throw new IllegalArgumentException("La hora de cierre tiene que estar comprendida entre las 0 y 23 horas.");
		}
		this.horaCierre = horaCierre;
		// Condicion 4: cupo positivo
		if (cupo<0) {
			throw new IllegalArgumentException("El cupo es el numero de personas que puede atender el medico en una hora (positivo).");
		}
		this.cupo = cupo;
		// Condicio 5: las fechas tienen que ser igual o posteriores a hoy
		for (LocalDate fecha : fechas) {
			if (fecha.isBefore(LocalDate.now())) {
					throw new IllegalArgumentException("Las fechas disponibles de antención deben ser iguales o posteriores al dia de hoy, no anteriores");
			}
		}
		this.fechas = new TreeSet<>();
		this.pacientes = new TreeSet<>();
		// MUY IMPORTANTE CONJUNTO ORDENADO QUE SIGUE EL CRITERIO IMPLEMENTADO
		this.citas = new TreeSet<>(new ComparatorCita());
		for (LocalDate fecha : fechas) {
			this.fechas.add(fecha);
		}
	}
	
	// OJO utilizar el this para el constructor
		public Consulta(String medico, LocalDate ... fechas) {
			this(medico, HORA_INICIO_DEFECTO, HORA_CIERRE_DEFECTO, CUPO_DEFECTO, fechas);
		}
	
		

		// 2e: utiliza predicate
		// Corrección Begoña: Set<Cita> getCitas(Predicate<Cita> criterio)
		public Set<Cita> getCitas (Predicate<Cita> criterio){
			Set<Cita> lista = new TreeSet<>(new ComparatorCita());
				citas.stream()
					.filter(c->criterio.test(c))
						.forEach(c->lista.add(c));
				return lista;
		}
		// Ojo metodo protected para que pueda cancelar la cita la clase consultaEspecialista
		protected boolean cancelarCita (Cita cita) { // Propiedad CUPO?????
			boolean masCitas = false;
			if (citas.remove(cita)) {
				for (Cita c : citas) {
					if (cita.getPaciente().equals(c.getPaciente())) {
						masCitas = true;
					}
				}
				if (!masCitas) {
					pacientes.remove(cita.getPaciente());
				}
				return true;
			}
			return false;
		}
}

	