package prueba;

import maquinas.Dinero;
import maquinas.Maquina;

public class PruebaPrograma {

	public static void main(String[] args) {
		Maquina maquina1 = new Maquina("Agua", 0.60, 10);
		
		maquina1.insertarDinero(Dinero.UN_EURO);
		
		maquina1.devolverDinero();
		
		maquina1.insertarDinero(Dinero.CINCUENTA_CENT);
		
		if(maquina1.comprar()) {
			System.out.println("Compra realizada con éxito.");
		}
		else {
			float resto = (float) (maquina1.getPrecio() - maquina1.getDineroTransaccion().getTotal());
			System.out.println("Compra fallida. Falta "+resto+" €.");
		}
		 
		maquina1.insertarDinero(Dinero.VEINTE_CENT);
		
		if(maquina1.comprar()) {
			System.out.println("Compra realizada con éxito.");
		}
		else {
			System.out.println("Compra fallida. No ha insertado el dinero suficiente.");
		}
		
		System.out.println("Stock de la máquina: "+maquina1.getStock());
		System.out.println("Dinero acumulado: "+maquina1.getDineroAcumulado().getTotal());
		System.out.println("Dinero transacción: "+maquina1.getDineroTransaccion().getTotal());
		
	}

}
