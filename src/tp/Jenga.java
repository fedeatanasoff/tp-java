package tp;

import java.util.ArrayList;
import java.util.Random;

public class Jenga {

	Torre torre;

	public Jenga(int niveles, ArrayList<String> jugadores) {
		torre = new Torre(niveles, jugadores);
	}

	public StringBuilder ganador() {
		return torre.ganador();
	}

	public String perdedor() {
		return torre.perdedor();
	}

	public int altura() {
		return torre.niveles.size();
	}

	public int primerNivelPosible() {
		Random ran = new Random();
		int nivel = ran.nextInt(torre.niveles.size() - 1);
		int cont1 = 3;
		int cont2 = 3;

		/*
		 * PREGUNTO SI EL NIVEL ELEGIDO POR EL RANDOM NO ESTA COMPLETO QUE LO VUELVA A
		 * SETEAR EN UN MAXIMO DE 3 OPORTUNIDADES
		 */

		if (!torre.niveles.get(nivel).estaCompleto()) {
			while (cont1 <= 3) {
				nivel = ran.nextInt(torre.niveles.size() - 1);
				cont1++;
			}
		} else
			return nivel;

		/*
		 * PREGUNTO SI EL NIVEL ELEGIDO NO TIENE DOS PIEZAS, QUE LO VUELVA A SETEAR EN
		 * UN MAXIMO DE 3 OPORTUNIDADES
		 */

		if (!torre.niveles.get(nivel).dosPiezasDer() || !torre.niveles.get(nivel).dosPiezasIzq()
				|| !torre.niveles.get(nivel).medioVacio()) {
			while (cont2 <= 3) {
				nivel = ran.nextInt(torre.niveles.size() - 1);
				cont2++;
			}
		} else
			return nivel;

		return nivel;
	}

	void Jugar() {
		int nivel = primerNivelPosible();
		Nivel niv = new Nivel();
		niv = torre.niveles.get(nivel);
		int pieza = torre.piezaRecomendada(niv);

		quitar(nivel, pieza);
	}

	void quitar(int nivel, int pieza) {
		torre.mover(nivel, pieza);
	}

	@Override
	public String toString() {
		return " " + torre.niveles + "";
	}
}