import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import Repaso.Valoracion;

public class Programa3 {

	public static void main(String[] args) {
		
		Valoracion valoracion1 = new Valoracion("Ana", 5, "Buena valoración");
	    Valoracion valoracion2 = new Valoracion("Pepe", 5);
	    Valoracion valoracion3 = new Valoracion("Shrek", 5, "Excelente servicio");
	    Valoracion valoracion4 = new Valoracion("Benito", 5, "Muy recomendable");
	    
	    List<Valoracion> valoraciones = new LinkedList<Valoracion>();
	    Collections.addAll(valoraciones,  valoracion1, valoracion2, valoracion3, valoracion4);
	    
	    valoraciones.stream().sorted((o1,o2)->o1.getUsuario().compareTo(o2.getUsuario())).map(u->u.getUsuario()).forEach(u->System.out.println(u));;
	    
	    boolean b = valoraciones.stream().allMatch(u->u.getNota() == 5);
	    System.out.println("¿Todas las valoraciones tienen nota 5?: "+ b);
	}

}
