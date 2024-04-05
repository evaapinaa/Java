package Bitacora;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class BitacoraInteligente extends Bitacora {
	
	private HashMap<String,List<String>> mapa;
	
	public Set<String> getPalabrasProhibidas(){
		return new HashSet<String>(mapa.keySet());
	}
	
	public List<String> getSpam(){
		Set<String> spam = new HashSet<String>();
		for(List<String> value: mapa.values()){
			spam.addAll(value);
		}
		return new ArrayList<String>(spam);
	}
	
	public BitacoraInteligente(String suceso, String ... palabrasProhibidas) {
		super(suceso);
		mapa = new HashMap<String,List<String>>();
		
		for(String clave: palabrasProhibidas) {
			List<String> valor = new LinkedList<String>();
			mapa.put(clave, valor);
		}
	}
	
	@Override
	public boolean registrarEntrada(String suceso) {
		for(String palabra : getPalabrasProhibidas() ) {
			if(suceso.contains(palabra)) {
				mapa.get(palabra).add(suceso);
				return false;
			}
		}
		return super.registrarEntrada(suceso);
		
	}
	
	@Override
	public BitacoraInteligente clone() {
		BitacoraInteligente copia = (BitacoraInteligente)super.clone();
		
		// COPIA PROFUNDA
		copia.mapa = new HashMap<String,List<String>>();
		for(String clave: mapa.keySet()){
			List<String> valor =  new LinkedList<String>();
			copia.mapa.put(clave,valor);
		}
		return copia;
	}
	
}
