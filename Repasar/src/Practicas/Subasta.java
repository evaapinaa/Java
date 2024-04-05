package Practicas;

import java.util.LinkedList;

public class Subasta {
	
	public static final int CANTIDAD = 1;
	
	private String nombreProducto;
	private String propietario;
	private boolean abierta;
	private LinkedList<Puja> listaPujas;
	
	public String getNombreProducto() {
		return nombreProducto;
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
		if (!listaPujas.isEmpty()) {
			return listaPujas.getLast();
		}
		return null;
	}
	
	public Subasta(String nombreProducto, String propietario) {
		this.nombreProducto = nombreProducto;
		this.propietario = propietario;
		this.abierta = true;
		this.listaPujas = new LinkedList<Puja>();
	}
	
	public boolean pujar(String pujador, double cantidad) {
		if (abierta == true && getPropietario() != pujador) {
			if(getPujaMayor() == null || getPujaMayor().getCantidad() < cantidad) {
				Puja puja = new Puja(pujador,cantidad);
				listaPujas.add(puja);
				return true;
			}
		}
		return false;
	}
	
	public boolean pujar(String pujador) {
		double cantidad = CANTIDAD;
		if(getPujaMayor() != null) {
			cantidad = getPujaMayor().getCantidad() + CANTIDAD;
		}
		return pujar(pujador, cantidad);
	}
	
	public boolean ejecutar() {
		if (!getListaPujas().isEmpty() && abierta) {
			this.abierta = false;
			return true;
		}
		return false;
	}

}
