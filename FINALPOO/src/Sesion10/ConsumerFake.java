package Sesion10;

import java.util.function.Consumer;

public class ConsumerFake implements Consumer<Registro>{
	
	@Override
	public void accept(Registro r) {
		System.out.println(r);
	}
	
}
