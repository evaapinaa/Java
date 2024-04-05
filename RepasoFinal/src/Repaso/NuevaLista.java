package Repaso;

import java.util.ArrayList;
import java.util.function.Predicate;

public class NuevaLista<T> extends ArrayList<T> {

	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final Predicate<T> predicate;

	 public NuevaLista(Predicate<T> predicate) {
		 this.predicate = predicate;
	 }

	public Predicate<T> getPredicate() {
		return predicate;
	}
	
	@Override
	public boolean add(T e) {
		if(predicate.test(e)) {
			return super.add(e);
		}
		return false;
	}
	
	
}
