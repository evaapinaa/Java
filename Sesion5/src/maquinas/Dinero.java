package maquinas;

public class Dinero {
	// CONSTANTES
	public static final Dinero CINCO_CENT = new Dinero(1, 0, 0, 0, 0, 0);
	public static final Dinero DIEZ_CENT = new Dinero(0, 1, 0, 0, 0, 0);
	public static final Dinero VEINTE_CENT = new Dinero(0, 0, 1, 0, 0, 0);
	public static final Dinero CINCUENTA_CENT = new Dinero(0, 0, 0, 1, 0, 0);
	public static final Dinero UN_EURO = new Dinero(0, 0, 0, 0, 1, 0);
	public static final Dinero DOS_EURO = new Dinero(0, 0, 0, 0, 0, 1);
	public static final Dinero NADA = new Dinero(0, 0, 0, 0, 0, 0);
	
	// VALOR DE LAS MONEDAS
	public static final double CINCOCENT = 0.05;
	public static final double DIEZCENT = 0.1;
	public static final double VEINTECENT = 0.2;
	public static final double CINCUENTACENT = 0.5;
	public static final double UNEURO = 1.0;
	public static final double DOSEUROS = 2.0;
	
	// ATRIBUTOS
	private final int cincoCent;
	private final int diezCent;
	private final int veinteCent;
	private final int cincuentaCent;
	private final int unEuro;
	private final int dosEuros;
	
	// METODOS DE CONSULTA
	public int getCincoCent() {
		return cincoCent;
	}
	public int getDiezCent() {
		return diezCent;
	}
	public int getVeinteCent() {
		return veinteCent;
	}
	public int getCincuentaCent() {
		return cincuentaCent;
	}
	public int getUnEuro() {
		return unEuro;
	}
	public int getDosEuros() {
		return dosEuros;
	}
	
	public double getTotal() {
		return getCincoCent() * CINCOCENT + getDiezCent() * DIEZCENT + getVeinteCent() * VEINTECENT + getCincuentaCent() * CINCUENTACENT + getUnEuro() * UNEURO + getDosEuros() * DOSEUROS;
	}
	
	
	// CONSTRUCTOR
	public Dinero(int cincoCent, int diezCent, int veinteCent, int cincuentaCent, int unEuro, int dosEuros) {
		this.cincoCent = cincoCent;
		this.diezCent = diezCent;
		this.veinteCent = veinteCent;
		this.cincuentaCent = cincuentaCent;
		this.unEuro = unEuro;
		this.dosEuros = dosEuros;
	}
	
	// METODOS
	public Dinero suma(Dinero dinero) {
		int nuevo5cent = cincoCent + dinero.getCincoCent();
		int nuevo10cent = diezCent + dinero.getDiezCent();
		int nuevo20cent = veinteCent + dinero.getVeinteCent();
		int nuevo50cent = cincuentaCent + dinero.getCincuentaCent();
		int nuevo1euro = unEuro + dinero.getUnEuro();		
		int nuevo2euros = dosEuros + dinero.getDosEuros();
		
		return new Dinero(nuevo5cent, nuevo10cent, nuevo20cent, nuevo50cent, nuevo1euro, nuevo2euros);
		
	}
	
}
