package Repaso;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public class Cita {
	
	private final String paciente;
	private final LocalDateTime fechaHora;

	public LocalDateTime getFechaHora() {
		return fechaHora;
	}
	public String getPaciente() {
		return paciente;
	}
	public boolean isActiva() {
		return LocalDateTime.now().isBefore(fechaHora);
	}
	
	public Cita(String paciente, LocalDateTime fechaHora) {
		super();
		this.paciente = paciente;
		this.fechaHora = fechaHora;
	}
	
	public Cita(String paciente, LocalDate fecha, int hora) {
		this(paciente,LocalDateTime.of(fecha.getYear(), fecha.getMonthValue(),fecha.getDayOfMonth(),hora,0));
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(fechaHora, paciente);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cita other = (Cita) obj;
		return Objects.equals(fechaHora, other.fechaHora) && Objects.equals(paciente, other.paciente);
	}
	@Override
	public String toString() {
		return getClass().getName()+"[paciente=" + paciente + ", fechaHora=" + fechaHora + ", isActiva()=" + isActiva() + "]";
	}
	
	
	
}
