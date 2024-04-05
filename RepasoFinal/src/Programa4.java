import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import Repaso.Utilidades;

public class Programa4 {

	public static void main(String[] args) throws IOException {
		
		List<String> lista = new ArrayList<String>();
		
		Collections.addAll(lista, "2022-04-23", "22-05-18", "2022-30-05", "2022-05-10");
		
		List<LocalDate> list = Utilidades.listaFechas("2022-04-23", "22-05-18", "2022-30-05", "2022-05-10");
		System.out.println(list);
		
		Utilidades.escribirArchivo(lista, "citas.txt");
	}

}
