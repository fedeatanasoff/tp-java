package tp;

import java.util.ArrayList;
import java.util.Random;

public class Torre {
	ArrayList<Nivel> niveles;
	ArrayList<String> players;
	String perdedor;
	StringBuilder ganador;
	int turno;
	int jugada;

	public Torre(int cantNiv, ArrayList<String> jugadores) {
		this.players = jugadores;
		this.turno = 0;
		this.ganador = new StringBuilder("");
		this.perdedor = "";

		niveles = new ArrayList<Nivel>();
		for (int i = 0; i < cantNiv; i++) {
			Nivel niv = new Nivel();
			niveles.add(niv);
		}
	}

	public String getPerdedor() {
		return perdedor;
	}

	private void setPerdedor(String ganador) {
		this.perdedor = ganador;
	}

	public String perdedor() {
		return getPerdedor();
	}

	public StringBuilder ganador() {
		return this.ganador;
	}

	void agregarNivel() {
		Nivel n = new Nivel(0);
		niveles.add(n);
	}

	public int piezaRecomendada(Nivel niv) {
		Random r = new Random();
		int random = r.nextInt(3);

		if (niv.estaCompleto()) {
			return random;
		} else if (niv.dosPiezasDer()) {
			return 2;
		} else if (niv.dosPiezasIzq()) {
			return 0;
		} else if (niv.medioVacio()) {
			return 0;
		} else if (niv.medioSolo()) {
			return 1;
		} else {
			System.out.println(niv.toString());
			return niv.getPiezas().get(4);
		}
	}

	public boolean probabilidad(int niv) {
		Random r = new Random();
		int random = r.nextInt(99) + 1;
		Nivel nivel = new Nivel();
		nivel = this.niveles.get(niv);
		int proba = 0;

		System.out.println("porcentaje de probabilidad: " + nivel.chequear() + "%");
		System.out.println("niveles encima: " + ((this.niveles.size() - 1) - niv));

		proba += nivel.chequear() * ((this.niveles.size() - 1) - niv);
		System.out.println("numero random: " + random + " y la probabilidad de perder era del " + proba + "%");

		if (random < proba) {
			return true;
		} else {
			return false;
		}
	}

	void mover(int indiceNivel, int indicePieza) {

		try {
			if (!this.niveles.get(indiceNivel).estaDisponible(indicePieza)) {
				System.out.println("nivel: " + indiceNivel + " - pieza :" + indicePieza);
				throw new Exception("la pieza no esta disponible");
			} else {
				System.out.println("---------- Jugada Nº " + (jugada + 1) + " -------------");
				System.out.println("Es el turno de: " + this.players.get(turno));
				System.out.println("Nivel Elegido: " + indiceNivel + " - Pieza Elegida:" + indicePieza);

				Nivel ultimo = this.niveles.get(this.niveles.size() - 1);
				this.niveles.get(indiceNivel).setearPieza(indicePieza);

				if (this.probabilidad(indiceNivel)) {
					System.out.println("PERDISTE. ");
					// encontre perdedor y lo seteo
					setPerdedor(this.players.get(turno));

					// seteo ganador
					for (String player : this.players) {
						if (!player.equals(getPerdedor()) && !getPerdedor().equals("")) {
							this.ganador.append(player).append(" - ");
						}
					}

					System.out.println("ha perdido el jugador: " + getPerdedor());
					System.out.println("---------- Fin De la jugada ----------");
				} else {
					System.out.println("EL JUEGO SIGUE..");
					if (ultimo.estaCompleto()) {
						this.agregarNivel();
						ultimo = this.niveles.get(this.niveles.size() - 1);
						ultimo.agregarPieza();
					} else {
						ultimo.agregarPieza();
					}

					if (turno == this.players.size() - 1) {
						turno = 0;
					} else {
						turno++;
					}

					jugada++;
					System.out.println("---------- Fin Vuelta ----------");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
		}
	}

}
