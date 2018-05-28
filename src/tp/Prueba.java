package tp;

import java.util.Random;

public class Prueba {

	public static void main(String[] args) {

		
		Jenga juego = new Jenga(3,"jugador 1", "jugador 2");
		
		//juego.quitar(0, 2);
		//System.out.println("test ganadr : "+juego.getGanador());
		//juego.quitarPieza(0, 0);
		//juego.quitarPieza(0, 0);
		//System.out.println(juego.toString());
		Random rd = new Random();
		int nivel = rd.nextInt(juego.niveles.size()-1);
		int pieza = rd.nextInt(3);
		
		int contador = 0;
		/*while( juego.ganador().equals("vacio") ) {
			juego.quitar(nivel, pieza);
			System.out.println("cantidad de vueltas "+contador);
			contador++;
			juego.mostrar();
		}*/
		
		System.out.println(juego.ganador());
		//System.out.println(juego.piezaRecomendada());
		//System.out.println(juego.primerNivelPosible());
		//System.out.println(juego.ganador());
		//System.out.println(juego.niveles.get(0).chequear());
		
		
		//juego.mostrar();
		
	}

}