package pruebas;

import geometria.Direccion;
import geometria.Punto;

public class ProgramaSesion3 {

	public static void main(String[] args) {
		
		Punto punto1 = new Punto(1,1);
		System.out.println("Punto1 = "+punto1.getX()+","+punto1.getY());
		
		Direccion[] direcciones = Direccion.values();
		
		for(Direccion direccion : direcciones) {
			punto1.desplazarPunto(direccion);
			System.out.println("Desplazando "+direccion);
			System.out.println("Punto1 = "+punto1.getX()+","+punto1.getY());
		
		}
		
		Punto punto2 = new Punto(4,2);
		
		// Opcion A
		Punto[] puntos = new Punto[2];
		puntos[0] = punto1;
		puntos[1] = punto2;
		
		// Opcion B
		//Punto[] puntos2 = {punto1,punto2};
		
		//Opcion C
		//Punto[] puntos3 = new Punto[] {punto1,punto2};
		
		for(Punto punto : puntos) {
			System.out.println("Punto = "+punto.getX()+","+punto.getY());
		}
		
		double distancia = punto1.distancia(punto2);
		System.out.println("Distancia Punto1 y Punto2: "+distancia);
	
		Punto.mayorDistancia(puntos);
		Punto puntoAlejado = Punto.mayorDistancia(punto1,punto2);
		System.out.println("Punto mas alejado = ["+puntoAlejado.getX()+","+puntoAlejado.getY()+"]");

	}
	
}
