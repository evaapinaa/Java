package sesion11;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

enum CategoriaProfesional{ A1, A2, B, C1, C2}

public class Funcionario {
	public final static double SMI = 1080;  //Salario Minimo Interprofesional
	
	private final String nombre;
	private final LocalDate nacimiento;
	private final LocalDate contrato;
	private CategoriaProfesional categoria;
	private double salario;
	
	public Funcionario(String nombre, LocalDate nacimiento, LocalDate contrato, double salario, CategoriaProfesional categoria) {
		super();
		this.nombre = nombre;
		this.nacimiento = nacimiento;
		this.contrato = contrato;
		this.salario = salario;
		this.categoria = categoria;
	}

	public String getNombre() {
		return nombre;
	}

	public LocalDate getNacimiento() {
		return nacimiento;
	}
	
	//propiedad calculada
	public int getEdad() {
		return (int)ChronoUnit.YEARS.between(nacimiento, LocalDate.now());
	}
	
	public int getAnyosServicio() {
		return (int)ChronoUnit.YEARS.between(contrato, LocalDate.now());
	}

	public LocalDate getContrato() {
		return contrato;
	}

	public double getSalario() {
		return salario;
	}
	
	public void subirSueldo(double porcentaje) {
		salario += (salario * porcentaje)/100;
	}
	
	public CategoriaProfesional getCategoria() {
		return categoria;
	}
	
	public void setCategoria(CategoriaProfesional categoria) {
		this.categoria = categoria;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() 
				+ "[nombre=" + nombre 
				+ ",\n nacimiento=" + nacimiento 
				+ ",\n contrato=" + contrato
				+ ",\n categoria=" + categoria
				+ ",\n salario=" + salario 
				+ ",\n edad=" + getEdad() 
				+ ",\n añosServicio=" + getAnyosServicio() 
				+ "]";
	}

	
}
