package examen;

import java.time.LocalDate;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Programa {

	public static void main(String[] args) {
		
		Video video1 = new Video(LocalDate.of(2017, 01, 07),"ST:Disco",1,1,5.0,Clasificacion.ADULTOS);
		Video video2 = new Video(LocalDate.of(2024, 01, 01),"ST:Disco",1,2,1.0,Clasificacion.DESDE_12_AÑOS);
		Video video3 = new Video(LocalDate.of(2024, 01, 05),"ST:Disco",2,1,2.0,Clasificacion.DESDE_7_AÑOS);
		Video video4 = new Video("ST:Gen",1,1);
		Video video5 = new Video("ST:Gen",1,2);
		
		List<Video> videos = new LinkedList<Video>();
		Collections.addAll(videos, video1, video2, video3, video4, video5);
		
		// EJERCICIO 11
		long cont = videos.stream().filter(u-> u.getTemporada() == 1 && u.getSerie().equals("ST:Disco")).count();
		System.out.println("Hay "+cont+" vídeos de la primera temporada de la serie ST:Disco");
		System.out.println();
		
		List<String> seriesMayorTemporadas = videos.stream().filter(new Predicate<Video>() {
			@Override
			public boolean test(Video v) {
				return v.getTemporada() > 1;
			}
		})
		.sorted((o1, o2)-> o1.getSerie().compareTo(o2.getSerie())).map(u->u.getSerie()).collect(Collectors.toList());
		
		System.out.println(seriesMayorTemporadas);
		System.out.println();
		
		// EJERCICIO 12 b)
		int año = Programa.getAño();
		videos.stream().filter(u->u.getFechaPrimeraEmision().getYear() == año).forEach(u->System.out.println(u));
		System.out.println();
		
		// EJERCICIO 13
		Map<Object, List<Video>> mapa = Utils.clasificar(videos, u->u.getClasificacion());
		System.out.println(mapa);
		System.out.println();
		
	}
	
	// EJERCICIO 12 a)
	public static int getAño() {
		int año = 0;
		Scanner sc = new Scanner(System.in);
		int intentos = 3;

		while(intentos > 0) {
			System.out.println("Introduce un año: ");
			String texto = sc.nextLine();
			    try {
			    	año = Integer.parseInt(texto);
			    	break;
			    } catch(NumberFormatException e) {
			    	System.err.println("Formato incorrecto, vuelva a intentarlo: " + e.getMessage());
			        intentos--;
			        if (intentos == 0) {
			        	System.err.println("Has agotado todos tus intentos, no se puede atender tu solicitud.");
			        }
			    } 
			}
			sc.close();
			return año;
		}
			

}
