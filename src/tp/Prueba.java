package tp;

import java.util.Random;

public class Prueba {

	public static void main(String[] args) {

		
		Jenga juego = new Jenga(3,"jugador 1", "jugador 2");
		
		//juego.quitarPieza(0, 2);
		//juego.quitarPieza(0, 0);
		//juego.quitarPieza(0, 0);
		//System.out.println(juego.toString());
		/*String comillas = "";
		int prueba = 0;
		while( juego.ganador().equals(comillas) ) {
			juego.quitar(0, 2);
			juego.quitar(0, 1);
			juego.mostrar();
		}
		
		System.out.println(juego.ganador());*/
		System.out.println(juego.piezaRecomendada());
		System.out.println(juego.primerNivelPosible());
		//System.out.println(juego.ganador());
		//System.out.println(juego.niveles.get(0).chequear());
		
		
		//juego.mostrar();
		
	}

}