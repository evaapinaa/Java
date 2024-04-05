package subastas;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class SubastaTemporal extends SubastaLimitada {
	// ATRIBUTOS 
	private int periodoFijo;
	private LocalDateTime inicio;
	
	// METODOS DE CONSULTA
	public int getPeriodoFijo() {
		return periodoFijo;
	}
	public int getHorasRestantes() {
		return periodoFijo - (int) ChronoUnit.HOURS.between(inicio,LocalDateTime.now());
	}
	
	// CONSTUCTOR
	public SubastaTemporal(String NombreProducto, String propietario,int periodoFijo) {
		super(NombreProducto, propietario, periodoFijo * 2);
		this.periodoFijo = periodoFijo;
		this.inicio = LocalDateTime.now();
	}
	
	// METODOS
	@Override
	public boolean pujar(String pujador, double cantidad) {
		if (getHorasRestantes() > 0) {
				return super.pujar(pujador, cantidad);
            }
        
        return false;
    }
	
	@Override
    public boolean ejecutar() {
        if (getHorasRestantes() <= 0) {
            return super.ejecutar();
        }
        return false;
    }
}
