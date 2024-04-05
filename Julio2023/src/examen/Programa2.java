package examen;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Programa2 {
    public static void main(String[] args) {
        // Prueba del método entradasExclusivas
        Map<Integer, String> mapa1 = new HashMap<>();
        mapa1.put(1, "A");
        mapa1.put(2, "B");

        Map<Integer, String> mapa2 = new HashMap<>();
        mapa2.put(2, "B");
        mapa2.put(3, "C");

        Map<Integer, String> entradasExclusivas = Utilidad.entradas(mapa1, mapa2);
        System.out.println("Entradas exclusivas: " + entradasExclusivas);

        // Prueba del método touch
        try {
            Utilidad.touch("fichero1.txt", "fichero2.txt", "fichero3.txt");
            System.out.println("Todos los ficheros han sido creados correctamente.");
        } catch (IOException e) {
            System.err.println("Error al crear los ficheros: " + e.getMessage());
        }
    }
}
