package Sesion10;

import java.time.LocalDate;
import java.util.function.Predicate;

public class PredicateFake implements Predicate<Registro>{
	
	@Override
	public boolean test(Registro r) {
		return r.getEntrada().isEqual(LocalDate.of(2023, 11, 12));
	}
}
