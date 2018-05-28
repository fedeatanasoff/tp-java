package tp;

import java.util.ArrayList;
import java.util.Random;

public class Jenga {

	ArrayList<Nivel> niveles; // inicializo
	String jugador1;
	String jugador2;
	String ganador;
	int cont=0;
	
	// constructor: crea los niveles
	public Jenga(int cantNiv, String j1, String j2) {
		this.jugador1 = j1;
		this.jugador2 = j2;

		niveles = new ArrayList<Nivel>();
		for (int i = 0; i < cantNiv; i++) {
			Nivel niv = new Nivel();
			niveles.add(niv);
		}
	}
	
	public String getJugador1() {
		return jugador1;
	}

	public void setJugador1(String jugador1) {
		this.jugador1 = jugador1;
	}

	public String getJugador2() {
		return jugador2;
	}

	public void setJugador2(String jugador2) {
		this.jugador2 = jugador2;
	}
	
	public int altura() {
		return this.niveles.size();
	}

	void agregarNivel() {
		Nivel n = new Nivel();
		for (int i = 0; i < n.piezas.size(); i++) {
			n.piezas.set(i, 0);
		}
		niveles.add(n);
	}
	
	public String ganador() {
		if(cont%2 == 0) {
			ganador = this.jugador2;
		}else {
			ganador = this.jugador1;
		}	
		return ganador;
	}
	
	int primerNivelPosible() {
		Random ran = new Random();
		int nivel = ran.nextInt(niveles.size() -1);
		return nivel;	
	}
	
	int piezaRecomendada() {
		Random ran = new Random();
		int pieza = ran.nextInt(3);
		return pieza;		
	}
	
	void jugar() {}
	
	void quitar(int indiceNivel, int indicePieza) {

		if (niveles.get(indiceNivel).estaDisponible(indicePieza)) {
			
			Random rd = new Random();
			int random = rd.nextInt(98) +1;
			Nivel ultimo = niveles.get(niveles.size() - 1);
			
			System.out.println("la pieza esta disponible para quitar");
			//System.out.println("niveles: " + niveles.size());
			//setearpieza() cambiar de valor la pieza que saque
			//System.out.println("seteeo pieza");
			niveles.get(indiceNivel).setearPieza(indicePieza);
			
			if (niveles.get(0).chequear() > random) {
				System.out.println("perdiste. " + "numero random: "+ random);
				System.out.println("ha ganado el jugador: "+ ganador());	
				
			}else {
				System.out.println("el juego sigue. El numero random es "+random);
				if (ultimo.estaCompleto()) {
					//System.out.println("el ultimo nivel esta completo");
					agregarNivel();
					ultimo = niveles.get(niveles.size() - 1);
					//System.out.println("niveles2: " + niveles.size());
					ultimo.agregarPieza(); // agrega la pieza
				} else {
					//System.out.println("el ultimo nivel no esta completo");
					ultimo.agregarPieza(); // agrega la pieza
				}
				
				this.ganador = "";
				System.out.println(this.ganador);
			}
			
		} else {
			System.out.println("");
			System.out.println("no esta diponible para quitar");
		}
		cont++;
	}	

	void mostrar() {
		int contador= 0;
		for (int i = 0; i < niveles.size(); i++) {
			contador++;
			System.out.println(" - ");

			for (int j = 0; j < niveles.get(i).piezas.size(); j++) {
				System.out.print("" + niveles.get(i).piezas.get(j) );
			}
		}
	}

	@Override
	public String toString() {
		return "[" + niveles + "]";
	}	
}
