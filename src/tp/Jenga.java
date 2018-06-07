package tp;

import java.util.ArrayList;
import java.util.Random;

public class Jenga {

	ArrayList<Nivel> niveles; // inicializo
	String jugador1;
	String jugador2;
	String ganador= "";
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
	
	public String getGanador() {
		return ganador;
	}

	public void setGanador(String ganador) {
		this.ganador = ganador;
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
		return getGanador();
	}
	
	public int primerNivelPosible() {
		Random ran = new Random();
		int nivel = ran.nextInt(niveles.size() -1);
		return nivel;	
	}
	
	public int piezaRecomendada(Nivel niv) {
		Random r = new Random();
		int random = r.nextInt(3);
		
		if(niv.estaCompleto()) {
			return random;
		}else if (niv.dosPiezasDer()) {
			return 2;
		}else if (niv.dosPiezasIzq()){
			return 0;
		}else if( niv.medioVacio()) {
			return 0;
		}else if (niv.medioSolo()) {
			return 1;
		}else {
			System.out.println(niv.toString());
			return niv.piezas.get(4);
		}
	}
	
	public int chequear(Nivel niv) {
		if(niv.piezas.get(0) == 0 && niv.piezas.get(1) == 1 && niv.piezas.get(2) == 1) {
			return 1;
		}else if ((niv.piezas.get(0) == 1 && niv.piezas.get(1) == 1 && niv.piezas.get(2) == 0)) {
			return 1;
		}else if (niv.piezas.get(0) == 0 && niv.piezas.get(1) == 1 && niv.piezas.get(2) == 0) {
			return 5;
		}else if (niv.piezas.get(0) == 0 && niv.piezas.get(1) == 0 && niv.piezas.get(2) == 1 ) {
			return 100;
		}else if (niv.piezas.get(0) == 1 && niv.piezas.get(1) == 0 && niv.piezas.get(2) == 0) {
			return 100;
		}else if (niv.piezas.get(0) == 0 && niv.piezas.get(1) == 0 && niv.piezas.get(2) == 0) {
			return 100;
		}else {
			return 0;
		}
	}
	
		
	public boolean probabilidad(int niv) {
		Random r = new Random();
		int random = r.nextInt(99) +1;
		Nivel check = new Nivel();
		check = this.niveles.get(niv);
		int proba = 0;
		
		System.out.println("porcentaje de probabilidad: "+chequear(check)+"%");
		System.out.println("niveles encima: " + ((this.niveles.size() -1) - niv));
		
		proba+= chequear(check) * ((this.niveles.size() -1) - niv)  ;
		System.out.println("numero random: "+ random+ " y la probabilidad de perder era del "+proba+"%");
		
		if(random < proba) {
			return true;
		}else {
			return false;
		}
	}
	
	void Jugar() {
		int nivel = primerNivelPosible();
		Nivel niv = new Nivel();
		niv = this.niveles.get(nivel);
		int pieza = piezaRecomendada(niv);
		
		quitar(nivel, pieza);
	}
	
	void quitar(int indiceNivel, int indicePieza) {
		
		try {
			if (!niveles.get(indiceNivel).estaDisponible(indicePieza)) {
				System.out.println("nivel: "+indiceNivel +" - pieza :"+indicePieza);
				throw new Exception("la pieza no esta disponible");
			}else {
				System.out.println("---------- Jugada Nº "+(cont +1)+" -------------");
				System.out.println("Nivel Elegido: "+indiceNivel +" - Pieza Elegida:"+indicePieza);
				Nivel ultimo = niveles.get(niveles.size() - 1);				
				
				niveles.get(indiceNivel).setearPieza(indicePieza);
				
				if (probabilidad(indiceNivel)) {
					System.out.println("PERDISTE. ");
					if(cont%2 == 0) {
						setGanador(this.jugador2);
					}else {
						setGanador(this.jugador1);
					}
					System.out.println("ha ganado el jugador: "+ getGanador());	
					System.out.println("---------- Fin Del Juego ----------");
					throw new Exception("se ha encontrado un ganador");
				} else {
					System.out.println("EL JUEGO SIGUE..");
					if (ultimo.estaCompleto()) {
						agregarNivel();
						ultimo = niveles.get(niveles.size() - 1);
						ultimo.agregarPieza();
					} else {
						ultimo.agregarPieza();
					}
					
					
					//System.out.println("el ganador es "+getGanador());
					System.out.println("---------- Fin Vuelta ----------");
					
				}
			}
		} catch(Exception e) {
			//this.ganador = "la pieza no esta disponible";
			e.printStackTrace();
			System.out.println(e);
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
		System.out.println("");
	}

	@Override
	public String toString() {
		return "[" + niveles + "]";
	}	
}