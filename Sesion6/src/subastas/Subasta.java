package subastas;

import java.util.LinkedList;

public class Subasta {
	public static final int PUJA_MINIMA = 1;
	// ATRIBUTOS
	private String NombreProducto;
	private String propietario;
	private boolean abierta;
	private LinkedList<Puja> listaPujas;

	// METODOS DE CONSULTA
	public String getNombreProducto() {
		return NombreProducto;
	}
	
	public String getPropietario() {
		return propietario;
	}
	
	public boolean isAbierta() {
		return abierta;
	}
	
	public LinkedList<Puja> getListaPujas() {
		return new LinkedList<Puja>(listaPujas);
	}
	
	public Puja getPujaMayor() {
		if (listaPujas.isEmpty()) {
	        return null;
	    }
	
	    return listaPujas.getLast();
	}
	
	// CONSTRUCTOR
	public Subasta(String NombreProducto,String propietario) {
		this.NombreProducto = NombreProducto;
		this.propietario = propietario;
		this.abierta = true;
		this.listaPujas = new LinkedList<Puja>();
	}
	
	public boolean pujar(String pujador, double cantidad) {
		if (abierta && pujador != propietario) {
            if (getPujaMayor() == null || cantidad > getPujaMayor().getCantidad()) {
                Puja nuevaPuja = new Puja(pujador, cantidad);
                listaPujas.add(nuevaPuja);
                return true;
            }
        }
        return false;
    }

	public boolean pujar(String pujador) {
        double cantidad = PUJA_MINIMA;
        Puja pujaMayor = getPujaMayor();
        if (pujaMayor != null) {
            cantidad = pujaMayor.getCantidad() + 1;
        }
        return pujar(pujador, cantidad);
    }

	public boolean ejecutar() {
		if (!listaPujas.isEmpty() && abierta) {
			this.abierta = false;
			return true;
		}
		return false;
	}
		
	}

