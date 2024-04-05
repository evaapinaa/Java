package prueba;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import viajes.Reserva;
import viajes.Viaje;
import viajes.ViajePremium;
import viajes.ViajeSelectivo;

public class PruebaPrograma {

	public static void main(String[] args) {
		//LocalDate.of()
		Viaje viaje1 = new Viaje("José Antonio","Seat León","Murcia-Cartagena",2023,12,9);
		
		ViajeSelectivo viaje2 = new ViajeSelectivo("José Antonio","Seat León","Murcia-Campus",2023,12,11,4);
		Set<String> uVetados = new HashSet<String>();
		uVetados.add("Beatriz");
		viaje2.setUsuariosVetados(uVetados);
		
		ViajePremium viaje3 = new ViajePremium("José Antonio","Seat León","Murcia-Barcelona",2023,12,15,6);
		
		Reserva reservaAlberto = viaje1.realizarReserva("Alberto", 2);
		System.out.println(reservaAlberto);
		
		Reserva reservaEnrique = viaje2.realizarReserva("Enrique", 3);
		System.out.println("Reserva de "+reservaEnrique.getUsuario()+": "+reservaEnrique.getCodigoReserva());
		
		Reserva reservaBeatriz = viaje2.realizarReserva("Beatriz", 1);
		System.out.println(reservaBeatriz);
		
		Reserva reservaAna = viaje3.realizarReserva("Ana", 2);
		System.out.println("Reserva de "+reservaAna.getUsuario()+": "+reservaAna.getCodigoReserva());
		
		if(viaje3.cancelarReservas(reservaAna.getCodigoReserva())) {
			System.out.println("Reserva cancelada");
		}
		else {
			System.out.println("Reserva no cancelada");
		}
	
		List<Viaje> viajes = new ArrayList<Viaje>();
		Collections.addAll(viajes, viaje1, viaje2, viaje3);
		for(Viaje viaje : viajes) {
			if (viaje instanceof ViajeSelectivo) {
				((ViajeSelectivo)viaje).remove("Beatriz");
			}
			System.out.println(viaje.toString());
		}
		
		List<Viaje> copias = new ArrayList<Viaje>(3);
		for(Viaje viaje : viajes) {
			Viaje copia = viaje.clone();
			copias.add(copia);
			if (copia instanceof ViajePremium) {
				List<Reserva> reservas = copia.getListaReservas();
				for(Reserva r: reservas) {
					((ViajePremium)copia).cancelarReservas(r.getCodigoReserva());
				}
			}
		}
		System.out.println("copias="+copias);
	}

}
