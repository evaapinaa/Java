package prueba;

import subastas.Subasta;
import subastas.SubastaLimitada;
import subastas.SubastaMinima;
import subastas.SubastaTemporal;
import java.util.ArrayList;

public class PruebaSubasta {

	public static void main(String[] args) {
		
		String usuario1 = "Juan";
		String usuario2 = "Enrique";
		
		SubastaLimitada limitada = new SubastaLimitada("Disco duro", usuario1, 1);
		SubastaTemporal temporal = new SubastaTemporal("Teclado", usuario1, 3);
		SubastaMinima minima = new SubastaMinima("Impresora láser", usuario1, 100);
		
		ArrayList<Subasta> lista = new ArrayList<Subasta>();
		lista.add(limitada);
		lista.add(temporal);
		lista.add(minima);
		
		for(Subasta s: lista) {
			System.out.println("Producto subastado: " + s.getNombreProducto());
			
			// PUJAS ENRIQUE
			if (s.pujar(usuario2, 10)) {
	            System.out.println("Puja aceptada");
	        } else {
	            System.out.println("Puja no aceptada");
	        }
			
			if (s.pujar(usuario2, 20)) {
	            System.out.println("Puja aceptada");
	        } else {
	            System.out.println("Puja no aceptada");
	        }
			
			// COMPRUEBA SI ESTA ABIERTA
			if (s.isAbierta()) {
				if(s.ejecutar()) {
					System.out.println("La subasta se ha ejecutado con éxito.");
				}
				else {
					System.out.println("La subasta no se ha ejecutado.");
				}
			}
			
			System.out.println("Mayor puja de la subasta: "+s.getPujaMayor().getPujador()+", "+s.getPujaMayor().getCantidad()+"\n");
		}
			
	}

}
