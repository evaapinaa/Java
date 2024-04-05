package pruebas;

import geometria.Punto;
import geometria.Rectangulo;

public class PruebaRectangulo {

	public static void main(String[] args) {
		
		Punto VIIr1 = new Punto(3,1);
		Punto VSDr1 = new Punto(5,6);
		
		Rectangulo rect1 = new Rectangulo(VIIr1,VSDr1);
		System.out.println("Rectangulo 1: ladoX: " + rect1.getLadoX()+", ladoY:"+rect1.getLadoY());
		System.out.println("Perimetro rectangulo 1: " + rect1.getPerimetro());
		
		System.out.print("Rectangulo 1 : VII["+rect1.getVerticeII().getX()+","+rect1.getVerticeII().getY()+"]");
		System.out.print(", VSD["+rect1.getVerticeSD().getX()+","+rect1.getVerticeSD().getY()+"]");
		System.out.print(", VID["+rect1.getVerticeID().getX()+","+rect1.getVerticeID().getY()+"]");
		System.out.println(", VSI["+rect1.getVerticeSI().getX()+","+rect1.getVerticeSI().getY()+"]");
		
		rect1.desplazar(0, -7);
		System.out.print("Rectangulo 1 desplazado : VII["+rect1.getVerticeII().getX()+","+rect1.getVerticeII().getY()+"]");
		System.out.print(", VSD["+rect1.getVerticeSD().getX()+","+rect1.getVerticeSD().getY()+"]");
		System.out.print(", VID["+rect1.getVerticeID().getX()+","+rect1.getVerticeID().getY()+"]");
		System.out.println(", VSI["+rect1.getVerticeSI().getX()+","+rect1.getVerticeSI().getY()+"]");
	
		rect1.escalar(50);
		System.out.println("Rectangulo 1: ladoX: " + rect1.getLadoX()+", ladoY:"+rect1.getLadoY());
		System.out.print("Rectangulo 1 escalado : VII["+rect1.getVerticeII().getX()+","+rect1.getVerticeII().getY()+"]");
		System.out.print(", VSD["+rect1.getVerticeSD().getX()+","+rect1.getVerticeSD().getY()+"]");
		System.out.print(", VID["+rect1.getVerticeID().getX()+","+rect1.getVerticeID().getY()+"]");
		System.out.println(", VSI["+rect1.getVerticeSI().getX()+","+rect1.getVerticeSI().getY()+"]");
		
		System.out.println("Perimetro rectangulo 1: " + rect1.getPerimetro());
	
		// PRUEBA CON OTRO RECTANGULO
		
//		Punto VIIr2 = new Punto(5,4);
		//Rectangulo rect2 = new Rectangulo(VIIr2,1,2);
//		System.out.println("Rectangulo 2: ladoX: " + rect2.getLadoX()+", ladoY:"+rect2.getLadoY());
//		System.out.print("Rectangulo 2 : VII["+rect2.getVerticeII().getX()+","+rect2.getVerticeII().getY()+"]");
//		System.out.print(", VSD["+rect2.getVerticeSD().getX()+","+rect2.getVerticeSD().getY()+"]");
//		System.out.print(", VID["+rect2.getVerticeID().getX()+","+rect2.getVerticeID().getY()+"]");
//		System.out.println(", VSI["+rect2.getVerticeSI().getX()+","+rect2.getVerticeSI().getY()+"]");
//		
//		System.out.println("Perimetro rectangulo 2: " + rect2.getPerimetro());
//		
//		rect2.desplazar(1, 1);
//		System.out.print("Rectangulo 2 desplazado : VII["+rect2.getVerticeII().getX()+","+rect2.getVerticeII().getY()+"]");
//		System.out.print(", VSD["+rect2.getVerticeSD().getX()+","+rect2.getVerticeSD().getY()+"]");
//		System.out.print(", VID["+rect2.getVerticeID().getX()+","+rect2.getVerticeID().getY()+"]");
//		System.out.println(", VSI["+rect2.getVerticeSI().getX()+","+rect2.getVerticeSI().getY()+"]");
//		
//		rect2.escalar(50);
//		System.out.print("Rectangulo 2 escalado : VII["+rect2.getVerticeII().getX()+","+rect2.getVerticeII().getY()+"]");
//		System.out.print(", VSD["+rect2.getVerticeSD().getX()+","+rect2.getVerticeSD().getY()+"]");
//		System.out.print(", VID["+rect2.getVerticeID().getX()+","+rect2.getVerticeID().getY()+"]");
//		System.out.println(", VSI["+rect2.getVerticeSI().getX()+","+rect2.getVerticeSI().getY()+"]");
//		System.out.println("Perimetro rectangulo 2: " + rect2.getPerimetro());
//		System.out.println("Rectangulo 2: ladoX: " + rect2.getLadoX()+", ladoY:"+rect2.getLadoY());
//	
	}
}
