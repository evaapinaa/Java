package examen;

import java.time.LocalDate;

public class Video {
	
	public static final double COSTE_POR_DEFECTO = 0.0;
	public static final Clasificacion CLASIFICACION_POR_DEFECTO = Clasificacion.TODOS_LOS_PUBLICOS;
	
	private final LocalDate fechaPrimeraEmision;
	private final String serie;
	private final int temporada;
	private final int capitulo;
	//private final String identificador; CALCULADA
	private final double coste;
	private final Clasificacion clasificacion;
	
	public int getCapitulo() {
		return capitulo;
	}
	public Clasificacion getClasificacion() {
		return clasificacion;
	}
	public double getCoste() {
		return coste;
	}
	public LocalDate getFechaPrimeraEmision() {
		return fechaPrimeraEmision;
	}
	public String getSerie() {
		return serie;
	}
	public int getTemporada() {
		return temporada;
	}
	public String getIdentificador() {
		return serie+" "+temporada+"."+capitulo;
	}
	
	public Video(LocalDate fechaPrimeraEmision, String serie, int temporada, int capitulo, double coste, Clasificacion clasificacion) {
		super();
		if(fechaPrimeraEmision == null) {
			throw new IllegalArgumentException("La fecha de primera emisión no puede ser un valor nulo.");
		}
		if(serie == null) {
			throw new IllegalArgumentException("La serie no puede ser un valor nulo.");
		}
		if(serie.isEmpty()) {
			throw new IllegalArgumentException("La serie no puede ser una cadena vacía.");
		}
		if(temporada <= 0) {
			throw new IllegalArgumentException("La temporada debe ser un numero entero a partir de 1.");
		}
		if(temporada <= 0) {
			throw new IllegalArgumentException("El capítulo debe ser un numero entero a partir de 1.");
		}
		if(coste < 0.0) {
			throw new IllegalArgumentException("El coste debe ser un número real válido a partir de 0, no puede ser negativo.");
		}
		if(clasificacion == null) {
			throw new IllegalArgumentException("La clasificación no puede ser un valor nulo.");
		}
		
		this.fechaPrimeraEmision = fechaPrimeraEmision;
		this.serie = serie;
		this.temporada = temporada;
		this.capitulo = capitulo;
		this.coste = coste;
		this.clasificacion = clasificacion;
	}
	
	public Video(String serie, int temporada, int capitulo) {
		this(LocalDate.now(),serie,temporada,capitulo,COSTE_POR_DEFECTO,CLASIFICACION_POR_DEFECTO);
	}
	
	@Override
	public String toString() {
		return getClass().getName()+"[fechaPrimeraEmision=" + fechaPrimeraEmision + ", serie=" + serie + ", temporada=" + temporada
				+ ", capitulo=" + capitulo + ", coste=" + coste + ", clasificacion=" + clasificacion
				+ ", identificador=" + getIdentificador() + "]";
	}
	
	
}
