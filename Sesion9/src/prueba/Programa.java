package prueba;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import viajes.Premium;
import viajes.ComparadorViajes;
import viajes.Criterio1;
import viajes.Criterio2;
import viajes.Reserva;
import viajes.Selectivo;
import viajes.Viaje;

public class Programa {
	public static void main(String[] args) {
		Viaje viaje = new Viaje("José Antonio","Seat León","Murcia-Cartagena",LocalDate.of(2023, 12, 9));
		Selectivo selectivo = new Selectivo("José Antonio", "Seat León","Murcia–Campus", LocalDate.of(2023, 12, 11),4);
		selectivo.addVetado("Beatriz");
		Premium premium = new Premium("José Antonio", "Seat León","Murcia-Barcelona", LocalDate.of(2023, 12, 15),6);
		
		Reserva r1 = viaje.realizarReserva("Alberto", 2);
		System.out.println("Alberto -> r="+r1);
		
		Reserva r2 = selectivo.realizarReserva("Enrique", 3);
		System.out.println("Enrique -> r="+r2);
		
		Reserva r3 = selectivo.realizarReserva("Beatriz", 1);
		System.out.println("Beatriz -> r="+r3);
		
		Reserva r4 = premium.realizarReserva("Ana", 2);
		System.out.println("Ana -> r="+r4);
		
		premium.cancelar(r4.getCodigo());
		
		
		//Ej2
		List<Viaje> viajes = new ArrayList<Viaje>();
		Collections.addAll(viajes, viaje,selectivo,premium);
		viajes.sort(null);
		System.out.println("Viajes ordenados = "+viajes);
		for(Viaje v: viajes) {
			if(v instanceof Selectivo) {
				((Selectivo)v).removeVetado("Beatriz");
			}
			System.out.println(v);
		}
		
		
		//Ej3
		
		List<Viaje> copias = new ArrayList<Viaje>(3);
		for(Viaje v: viajes) {
			Viaje copia = v.clone();
			copias.add(copia);
			if(copia instanceof Premium) {
				List<Reserva> reservas = copia.getReservas();
				for(Reserva r: reservas) {
					((Premium)copia).cancelar(r.getCodigo());
				}
			}
		}
		System.out.println("Copias = "+copias);
		
		copias.sort(new ComparadorViajes());
		System.out.println("Copias ordenadas por ruta: "+copias);
		
		
		selectivo.realizarReserva("Antonio", 1);
		List<Reserva> ord1 = selectivo.getReservas(new Criterio1());
		System.out.println("Lista ordenada por usuario y fecha"+ord1);
		List<Reserva> ord2 = selectivo.getReservas(new Criterio2());
		System.out.println("Lista ordenada por usuario y fecha"+ord2);
		
		
	}
}
