package viajes;

import java.time.LocalDate;
import java.util.UUID;

public class Reserva {
	//PROPIEDADES
	private final String codigo;
	private final String usuario;
	private final int plazas;
	private final LocalDate fecha;
	//MÉTODOS DE CONSULTA
	public String getCodigo() {
		return codigo;
	}
	public String getUsuario() {
		return usuario;
	}
	public int getPlazas() {
		return plazas;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	//CONSTRUCTOR
	public Reserva(String usuario, int plazas) {
		super();
		this.usuario = usuario;
		this.plazas = plazas;
		codigo = UUID.randomUUID().toString();
		fecha = LocalDate.now();
	}
	
	@Override
	public String toString() {
		return getClass().getSimpleName()+" [codigo=" + codigo + ", usuario=" + usuario + ", plazas=" + plazas + ", fecha=" + fecha + "]";
	}
}
