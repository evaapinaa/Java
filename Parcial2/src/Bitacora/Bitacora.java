package Bitacora;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class Bitacora implements Cloneable {
	
	private final String nombre;
	private List<Entrada> lista;
	
	public List<Entrada> getLista() {
		return new ArrayList<Entrada>(lista);
	}
	
	protected List<Entrada> getListaProtegido() {
		return lista;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public int getNumEntradas() {
		return lista.size();
	}
	
	public Bitacora(String nombre) {
		super();
		this.nombre = nombre;
		this.lista = new ArrayList<Entrada>();
	}
	
	public boolean registrarEntrada(String suceso) {
		if(!suceso.isEmpty()) {
			Entrada e = new Entrada(suceso);
			lista.add(e);
			return true;
		}
		return false;
	}

	@Override
	public int hashCode() {
		return Objects.hash(lista, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bitacora other = (Bitacora) obj;
		if (lista == null) {
			if(other.getLista() != null) {
				return false;
			}
			else if (!lista.equals(other.getLista())) {
				return false;
			}
		if(nombre == null) {
			if(other.nombre != null) {
				return false;
			}
			else if (!nombre.equals(other.nombre)) {
				return false;
			}
		}
		}
		return true;
		// return Objects.equals(lista, other.lista) && Objects.equals(nombre, other.nombre);
	}

	@Override
	public String toString() {
		return getClass().getName()+"[nombre=" + nombre + ", lista=" + lista + "]";
	}
	
	private Bitacora getCopiaSuperficial() {
		try {
			Bitacora copiaSuperficial = (Bitacora) super.clone();
			return copiaSuperficial;
		} catch(CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public Bitacora clone() {
		Bitacora copia = getCopiaSuperficial();
		// COPIA PROFUNDA
		copia.lista = new ArrayList<Entrada>(this.getNumEntradas());
		return copia;
	}
	
	public List<Entrada> getEntradas(Comparator<Entrada> criterio) {
		List<Entrada> entradasOrdenadas = new ArrayList<Entrada>(lista);
		entradasOrdenadas.sort(criterio);
		return entradasOrdenadas;
	}
}

