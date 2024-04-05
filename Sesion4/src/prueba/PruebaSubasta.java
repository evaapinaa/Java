package prueba;

import subastas.Subasta;

public class PruebaSubasta {

	public static void main(String[] args) {
		
		Subasta subasta1 = new Subasta("Teléfono móvil", "Juan");
		System.out.println("Subasta1: "+subasta1.getNombreProducto()+", "+subasta1.getPropietario());
		
		subasta1.pujar("Pedro", 100);
		
		System.out.println("Mayor puja de la subasta1: "+subasta1.getPujaMayor().getPujador()+", "+subasta1.getPujaMayor().getCantidad());
		
		subasta1.pujar("Enrique", 50);
		System.out.println("Mayor puja de la subasta1: "+subasta1.getPujaMayor().getPujador()+", "+subasta1.getPujaMayor().getCantidad());
		
		subasta1.ejecutar();
		
		 if (subasta1.pujar("Enrique", 200)) {
	            System.out.println("Puja aceptada");
	        } else {
	            System.out.println("Puja no aceptada");
	        }
	    }
	}


