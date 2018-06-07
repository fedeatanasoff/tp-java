package tp;

import java.util.Random;

public class Prueba {

	public static void main(String[] args) {

		
		Jenga jenga1 = new Jenga(6,"jugador 1", "jugador 2");
		
		
		// test1;
		/*int alturaInicial = jenga1.altura();
		jenga1.Jugar();
		jenga1.Jugar();
		jenga1.Jugar();
		System.out.println(alturaInicial +","+ jenga1.altura());
		System.out.println(alturaInicial != jenga1.altura());*/
		
		// MODO - Automatico
		while( jenga1.ganador().equals("") ) {
			jenga1.Jugar();
			jenga1.mostrar();
		}
		System.out.println("el ganador es "+jenga1.ganador());
		
		
		
	}
}