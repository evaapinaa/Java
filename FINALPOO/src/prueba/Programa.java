package prueba;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import eventos.Evento;
import eventos.Libre;
import eventos.Marcador;
import eventos.Restringido;

public class Programa {

	public static void main(String[] args) {
		Libre libre = new Libre("Real Madrid - F.C. Barcelona",1);
		libre.apostar("Juan", new Marcador(5,0));
		libre.apostar("Pepe", new Marcador(1,3));
		
		Set<Marcador> opciones = new HashSet<Marcador>();
		Collections.addAll(opciones, new Marcador(2,0),new Marcador(2,1),new Marcador(0,2),new Marcador(1,2));
		
		Restringido restringido = new Restringido("Alcaraz vs Djokovic", 3,opciones);
		restringido.apostar("Juan",new Marcador(2,0));
		restringido.apostar("Pedro",new Marcador(2,1));
		restringido.apostar("Pepe",new Marcador(2,0));
		
		List<Evento> eventos = new ArrayList<Evento>(2);
		Collections.addAll(eventos, libre, restringido);
		for(Evento e: eventos) {
			e.apostar("Enrique", new Marcador(5,0));
		}
		for(Evento e: eventos) {
			System.out.println(e);
		}
		for(Evento e: eventos) {
			if(e instanceof Restringido) {
				int cont = 0;
				for(Marcador m : e.getMapa().values()) {
					if(m.equals(new Marcador(2,0))) {
						cont++;
					}
				}
				System.out.println(e.getNombre()+" -> Apuestas con (2,0) = "+cont);
			}
		}
		
		libre.cerrarEvento();
		restringido.cerrarEvento();
		
		libre.setResultado(new Marcador(5,0));
		restringido.setResultado(new Marcador(2,0));
		
		for(Evento e: eventos) {
			System.out.println(e.consultarGanadores());
			
		}
	}

}
