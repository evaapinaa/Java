package Practicas;

public class Dinero {
	
	public static final Dinero CINCO_CENT = new Dinero(1,0,0,0,0,0);
	public static final Dinero DIEZ_CENT = new Dinero(0,1,0,0,0,0);
	public static final Dinero VEINTE_CENT = new Dinero(0,0,1,0,0,0);
	public static final Dinero CINCUENTA_CENT = new Dinero(0,0,0,1,0,0);
	public static final Dinero UN_EURO = new Dinero(0,0,0,0,1,0);
	public static final Dinero DOS_EUROS = new Dinero(0,0,0,0,0,1);
	public static final Dinero NADA = new Dinero(0,0,0,0,0,0);
	
	private static final double CINCOCENT = 0.05;
	private static final double DIEZCENT = 0.1;
	private static final double VEINTECENT = 0.2;
	private static final double CINCUENTACENT = 0.5;
	private static final double UNEURO = 1.0;
	private static final double DOSEUROS = 2.0;
	
	private final int n5cent;
	private final int n10cent;
	private final int n20cent;
	private final int n50cent;
	private final int n1euro;
	private final int n2euros;
	
	public int getN5cent() {
		return n5cent;
	}

	public int getN10cent() {
		return n10cent;
	}

	public int getN20cent() {
		return n20cent;
	}

	public int getN50cent() {
		return n50cent;
	}

	public int getN1euro() {
		return n1euro;
	}

	public int getN2euros() {
		return n2euros;
	}
	
	public double getTotal() {
		return getN5cent() * CINCOCENT + getN10cent() * DIEZCENT + getN20cent() * VEINTECENT + getN50cent() * CINCUENTACENT + getN1euro() * UNEURO + getN2euros() * DOSEUROS;
	}

	public Dinero(int n5cent,int n10cent,int n20cent,int n50cent,int n1euro, int n2euros) {
		this.n5cent = n5cent;
		this.n10cent = n10cent;
		this.n20cent = n20cent;
		this.n50cent = n50cent;
		this.n1euro = n1euro ;
		this.n2euros = n2euros;
	}
	
	public Dinero sumar(Dinero dinero) {
		int sum1 = n5cent + dinero.getN5cent();
		int sum2 = n10cent + dinero.getN10cent();
		int sum3 = n20cent + dinero.getN20cent();
		int sum4 = n50cent + dinero.getN50cent();
		int sum5 = n1euro + dinero.getN1euro();
		int sum6 = n2euros + dinero.getN2euros();
		return new Dinero(sum1,sum2,sum3,sum4,sum5,sum6);
		
	}

	
}
