package tp;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class Jenga {

	ArrayList<Nivel> niveles; // inicializo
	String perdedor;
	String ganador;
	int turno;	
	int jugada;
	ArrayList<String> players;
	
	// constructor: crea los niveles
	public Jenga(int cantNiv, ArrayList<String> jugadores) {
		this.players = jugadores;
		this.turno = 0;
		this.ganador= "";
		this.perdedor= "";
		
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

	public int altura() {
		return this.niveles.size();
	}

	private void agregarNivel() {
		Nivel n = new Nivel(0);
		niveles.add(n);
	}
	
	public String perdedor() {	
		return getPerdedor();
	}
	
	public String ganador() {
		return this.ganador;
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
			return niv.getPiezas().get(4);
		}
	}
	
	public int chequear(Nivel niv) {
		if(niv.getPiezas().get(0) == 0 && niv.getPiezas().get(1) == 1 && niv.getPiezas().get(2) == 1) {
			return 1;
		}else if ((niv.getPiezas().get(0) == 1 && niv.getPiezas().get(1) == 1 && niv.getPiezas().get(2) == 0)) {
			return 1;
		}else if (niv.getPiezas().get(0) == 0 && niv.getPiezas().get(1) == 1 && niv.getPiezas().get(2) == 0) {
			return 5;
		}else if (niv.getPiezas().get(0) == 0 && niv.getPiezas().get(1) == 0 && niv.getPiezas().get(2) == 1 ) {
			return 100;
		}else if (niv.getPiezas().get(0) == 1 && niv.getPiezas().get(1) == 0 && niv.getPiezas().get(2) == 0) {
			return 100;
		}else if (niv.getPiezas().get(0) == 0 && niv.getPiezas().get(1) == 0 && niv.getPiezas().get(2) == 0) {
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
				System.out.println("---------- Jugada Nº "+(jugada +1)+" -------------");
				System.out.println("Nivel Elegido: "+indiceNivel +" - Pieza Elegida:"+indicePieza);
				System.out.println("es el turno de: "+this.players.get(turno));
				Nivel ultimo = niveles.get(niveles.size() - 1);				
				niveles.get(indiceNivel).setearPieza(indicePieza);
				
				if (probabilidad(indiceNivel)) {
					System.out.println("PERDISTE. ");
					//encontre perdedor y lo seteo					
					setPerdedor(this.players.get(turno));
					
					
				/*	Iterator<String> it = players.iterator();
					while (it.hasNext()) {
						this.ganador.append(it.next());
					}*/
					for (String nombre : players) {
						if( !nombre.equals(getPerdedor()) ) {
							this.ganador += nombre + " - ";
						}
					}

					
					

					
					
					System.out.println("ha perdido el jugador: "+ getPerdedor());	
					System.out.println("---------- Fin Del Juego ----------");
				} else {
					System.out.println("EL JUEGO SIGUE..");
					if (ultimo.estaCompleto()) {
						agregarNivel();
						ultimo = niveles.get(niveles.size() - 1);
						ultimo.agregarPieza();
					} else {
						ultimo.agregarPieza();
					}
					
					if( turno == this.players.size() -1){
						turno = 0;
					}else{
						turno++;
					}
					
					jugada++;
					
					System.out.println("---------- Fin Vuelta ----------");
					
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println(e);
		}		
	}

	@Override
	public String toString() {
		return " " + niveles + "";
	}	

	/*void mostrar() {
		int contador= 0;
		for (int i = 0; i < niveles.size(); i++) {
			contador++;
			System.out.println(" - ");

			for (int j = 0; j < niveles.get(i).piezas.size(); j++) {
				System.out.print("" + niveles.get(i).piezas.get(j) );
			}
		}
		System.out.println("");
	}*/

		
}