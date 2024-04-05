package pruebas;

import geometria.Circulo;
import geometria.Punto;

public class PruebaCirculo {

	public static void main(String[] args) {
		Punto punto1 = new Punto(2,3);
		Circulo circulo1 = new Circulo(punto1,3);
		
		System.out.println("Circulo 1 -> centro: ["+circulo1.getCentro().getX()+","+circulo1.getCentro().getY()+"]");
		System.out.println("Circulo 1 -> radio: "+circulo1.getRadio());
		System.out.println("Circulo 1 -> perimetro: "+circulo1.getPerimetro());
		
		Circulo circulo2 = new Circulo();
		System.out.println("Circulo 2 -> centro: ["+circulo2.getCentro().getX()+","+circulo2.getCentro().getY()+"]");
		System.out.println("Circulo 2 -> radio: "+circulo2.getRadio());
		System.out.println("Circulo 2 -> perimetro: "+circulo2.getPerimetro());
	
		circulo1.desplazar(3, 2);
		System.out.println("Circulo 1 -> centro: ["+circulo1.getCentro().getX()+","+circulo1.getCentro().getY()+"]");
		System.out.println("Circulo 1 -> radio: "+circulo1.getRadio());
		System.out.println("Circulo 1 -> perimetro: "+circulo1.getPerimetro());	
		
		circulo2.escalar(150);
		System.out.println("Circulo 2 -> centro: ["+circulo2.getCentro().getX()+","+circulo2.getCentro().getY()+"]");
		System.out.println("Circulo 2 -> radio: "+circulo2.getRadio());
		System.out.println("Circulo 2 -> perimetro: "+circulo2.getPerimetro());
		
		Circulo circulo3 = new Circulo();
		System.out.println("Circulo 3 -> centro: ["+circulo3.getCentro().getX()+","+circulo3.getCentro().getY()+"]");
		System.out.println("Circulo 3 -> radio: "+circulo3.getRadio());
		System.out.println("Circulo 3 -> perimetro: "+circulo3.getPerimetro());
		
		Circulo circulo4 = new Circulo(punto1,5);
		circulo1.desplazar(3, 2);
		
		System.out.println("Circulo 1 -> centro: ["+circulo1.getCentro().getX()+","+circulo1.getCentro().getY()+"]");
		System.out.println("Circulo 4 -> centro: ["+circulo4.getCentro().getX()+","+circulo4.getCentro().getY()+"]");
	
		Punto punto2 = new Punto(circulo4.getCentro().getX(),circulo4.getCentro().getY());
		punto2.desplazarPunto(1, 0);
		System.out.println("Punto 2 -> ["+punto2.getX()+","+punto2.getY()+"]");
		System.out.println("Circulo 4 -> centro: ["+circulo4.getCentro().getX()+","+circulo4.getCentro().getY()+"]");
		System.out.println("Circulo 4 -> radio: "+circulo4.getRadio());
		System.out.println("Circulo 4 -> perimetro: "+circulo4.getPerimetro());	
		
		Punto punto3 = circulo1.getCentro();
		punto3.desplazarPunto(1, 4);
		
		// No porque con desplazarPunto podríamos cambiar el valor
	}
		

}
