package Prueba;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import Bitacora.Bitacora;
import Bitacora.BitacoraInteligente;

public class PruebaBitacora {

	public static void main(String[] args) {
		
		Bitacora b1 = new Bitacora("basica1");
		BitacoraInteligente b2 = new BitacoraInteligente("inteligente1", "facebook", "thepiratebay");
		BitacoraInteligente b3 = new BitacoraInteligente("inteligente2", "foto", "descargar");
		
		List<Bitacora> lista = new ArrayList<Bitacora>();
		
		Collections.addAll(lista,b1,b2,b3);
		
		for(Bitacora b: lista) {
			b.registrarEntrada("Se ha producido un error en el servicio");
			b.registrarEntrada("Puedes descargar el driver desde thepiratebay");
			b.registrarEntrada("Las fotos están publicadas en facebook");
			
			System.out.println("Bitacora "+b.getNombre()+" -> entradas = "+b.getNumEntradas());
			
			if(b instanceof BitacoraInteligente){
				BitacoraInteligente bi = (BitacoraInteligente)b;
				System.out.println("BitacoraInteligente "+bi.getNombre()+" -> spam = "+bi.getSpam());
			}
			
		}

	}

}
