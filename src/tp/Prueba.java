package tp;

import java.util.ArrayList;
import java.util.Random;

public class Prueba {

	public static void main(String[] args) {
		
		ArrayList<String> jugs = new ArrayList<>();
		jugs.add("j1");
		jugs.add("j2");
		jugs.add("j3");
		jugs.add("j4");
		
		Jenga jenga1 = new Jenga(8, jugs);		
		// test1;
		/*int alturaInicial = jenga1.altura();
		jenga1.Jugar();
		jenga1.Jugar();
		jenga1.Jugar();
		System.out.println(alturaInicial +","+ jenga1.altura());
		System.out.println(alturaInicial != jenga1.altura());*/
		
		// MODO - Automatico
		while( jenga1.perdedor().equals("") ) {
			jenga1.Jugar();
			//jenga1.mostrar();
			System.out.println(jenga1.toString());
		}
		System.out.println("el perdedor es "+jenga1.perdedor());
		
		System.out.println("los ganadores son "+jenga1.ganador());
		
		
		
	}
}