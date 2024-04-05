package examen;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Tramo implements Comparable<Tramo>{
	
	private final DayOfWeek dia;
	private final int horaInicio;
	private final int horaFinal;
	
	public DayOfWeek getDia() {
		return dia;
	}
	public int getHoraFinal() {
		return horaFinal;
	}
	public int getHoraInicio() {
		return horaInicio;
	}
	
	public Tramo(DayOfWeek dia, int horaInicio, int horaFinal) {
		super();
		if(dia == null) {
			throw new IllegalArgumentException("El día debe ser un enumerado distinto de null.");
		}
		if(horaInicio < 0) {
			throw new IllegalArgumentException("La hora inicial debe ser un número valido.");
		}
		if(horaFinal < 0) {
			throw new IllegalArgumentException("La hora final debe ser un número valido.");
		}
		this.dia = dia;
		this.horaInicio = horaInicio;
		this.horaFinal = horaFinal;
	}
	
	public boolean compruebaDentro(LocalDateTime fecha) {
		if(LocalDate.now().getDayOfWeek().equals(dia) && (fecha.getHour() >= horaInicio && fecha.getHour() < horaFinal)) {
			return true;
		}
		return false;
	}
	
	public Tramo valueOf(String cadena1, String cadena2, String cadena3) {
		if(cadena1 == null || cadena2 == null || cadena3 == null) {
			throw new NullPointerException("La cadena no puede ser null");
		}
		boolean valido = false;
		for(DayOfWeek d : DayOfWeek.values()) {
			if (d.name().equals(cadena1)) {
				valido = true;
				break;
			}
			
		}
		if(valido == false) {
			throw new IllegalArgumentException("La cadena dia no coincide con los del enumerado");
		}
		
		Integer.parseInt(cadena2);
		if(Integer.parseInt(cadena2) < 0 || Integer.parseInt(cadena3) < 0) {
			throw new NumberFormatException("Las horas deben ser enteros válidos");
		}
		
		return new Tramo(DayOfWeek.valueOf(cadena1), Integer.parseInt(cadena2), Integer.parseInt(cadena3));
	}
	
	@Override
	public int compareTo(Tramo o2) {
		int c = getDia().compareTo(o2.getDia());
		if (c == 0) {
			return getHoraInicio() - o2.getHoraInicio();
		}
		return c;
	}
	
	@Override
	public String toString() {
		return getClass().getName()+"[dia=" + dia + ", horaInicio=" + horaInicio + ", horaFinal=" + horaFinal + "]";
	}
	

	public static Tramo valueOf2 (String cadena1, String cadena2, String cadena3) {
		try {
			Tramo tramo;
			tramo = new Tramo(DayOfWeek.valueOf(cadena1),
			Integer.parseInt(cadena2), Integer.parseInt(cadena3));
			return tramo;
		} catch (IllegalArgumentException e1) {
			System.err.println("Parámetros no válidos. Introduzca un día de la semana, hora de inicio y hora de finalización.");
			return null;
		} catch (NullPointerException e2) {
			System.err.println("Parámetros no válidos. Introduzca un día de la semana, hora de inicio y hora de finalización.");
			return null;
		}
	}

	// en el main
	//TramoHorario tramoValue2 = TramoHorario.valueOf("hola", "3", "10");
	//if (tramoValue2!=null)
		//System.out.println(tramoValue2.toString());

}


