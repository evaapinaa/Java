
public class Resultado {
	
	public final static int VOTOS_POR_DEFECTO = 0;
	
	private String opcionVoto;
	private int numeroVotos;
	
	public int getNumeroVotos() {
		return numeroVotos;
	}
	public String getOpcionVoto() {
		return opcionVoto;
	}
	
	public Resultado(String opcionVoto, int numeroVotos) {
		super();
		this.opcionVoto = opcionVoto;
		this.numeroVotos = numeroVotos;
	}
	
	public Resultado(String opcionVoto) {
		this(opcionVoto, VOTOS_POR_DEFECTO);
	}
	
	
}
