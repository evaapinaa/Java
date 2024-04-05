

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

public class Utilidades {
	
	public static void eliminarCitasInactivas(Collection<Cita> citas) {
		Iterator<Cita> it = citas.iterator();
		while(it.hasNext()) {
			Cita cita = it.next();
			if(!cita.isActiva()) {
				it.remove();
			}
		}
	}
	
	public SortedMap<LocalDate,List<Cita>> construirMapaOrdenado(Collection<Cita> citas) {
		SortedMap<LocalDate,List<Cita>> mapaOrdenado = new TreeMap<LocalDate, List<Cita>>();
		for(Cita cita : citas) {
			LocalDate fechaCita = cita.getFechaHora().toLocalDate();
			if (!mapaOrdenado.containsKey(fechaCita)) {
				mapaOrdenado.put(fechaCita, new ArrayList<>());
			}
			mapaOrdenado.get(fechaCita).add(cita);
		}
		return mapaOrdenado;
	}
	
	public static <T> Collection<T> interseccion(Collection<T> coleccion1, Collection<T> coleccion2) {
		Set<T> intersection = new HashSet<>(coleccion1);
		intersection.retainAll(coleccion2);
		return intersection;
	}
	
	public static List<LocalDate> listaFechas(String...cadenas) {
		
		List<LocalDate> lista = new LinkedList<LocalDate>();
		for(String c : cadenas) {
			try {
				LocalDate fecha = LocalDate.parse(c);
				lista.add(fecha);
			} catch(DateTimeParseException e) {
				System.out.println(e);
				lista.add(null);
			}
			
		}
		
		return lista;
	}
	
	
	 public static <T> boolean sonDisjuntos(Collection<T> coleccion1, Collection<T> coleccion2) {
		 for(T obj : coleccion1) {
			 if(coleccion2.contains(obj)) {
				 return true;
			 }
		 }
		 return false;
	 }
	 // especifica que puede lanzarla
	 // si no lanza throws en cabecera, hay que hacer try catch
	 
	 public static <T> void escribirArchivo(List<T> lista, String nombre) throws IOException {
		 FileWriter fichero = new FileWriter(nombre);
		 int intentos = 0;
			 for(T obj : lista) {
				 String linea = obj.toString();
				 while(intentos < 5) {
					 try {
						 fichero.write(linea+"\n");
						 break;
					 }catch (IOException e) {
						 if (intentos == 5) System.err.println("No ha podido ser escrito el objeto en la posición " + lista.indexOf(obj));
					 }
				 }
			 }
		fichero.close();
	 }
}
