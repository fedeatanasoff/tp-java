package tp;

import java.util.ArrayList;
import java.util.Iterator;

public class Nivel {

	private ArrayList<Integer> piezas;
	
	// constructor: creo las piezas
	public Nivel() {
		piezas = new ArrayList<>();
		for (int i = 0; i < 3; i++) {
			piezas.add(1);
		}
	}
	
	public Nivel(int cero) {
		piezas = new ArrayList<>();
		for (int i = 0; i < 3; i++) {
			piezas.add(cero);
		}
	}

	public ArrayList<Integer> getPiezas() {
		return piezas;
	}

	public void setPiezas(ArrayList<Integer> piezas) {
		this.piezas = piezas;
	}	

	boolean estaDisponible(int indice) {
		if (piezas.get(indice) == 1) {
			return true;
		}
		return false;
	}

	void agregarPieza() {
		for (int i = 0; i < piezas.size(); i++) {
			if (piezas.get(i) == 0) {
				piezas.set(i, 1);
				break;
			}
		}
	}

	boolean estaCompleto() {
		boolean res = true;
		for (int i = 0; i < piezas.size(); i++) {
			res = res && piezas.get(i) == 1;
		}
		return res;
	}	
	
	boolean dosPiezasIzq() {
		
		if(piezas.get(0) == 1 && piezas.get(1) == 1 && piezas.get(2) == 0) {
			return true;
		}else {
			return false;
		}
	}
	
	boolean dosPiezasDer() {
		if(piezas.get(0) == 0 && piezas.get(1) == 1 && piezas.get(0) == 1) {
			return true;
		}else {
			return false;
		}
	}
	
	boolean medioVacio() {
		if(piezas.get(0) == 1 && piezas.get(1) == 0 && piezas.get(0) == 1) {
			return true;
		}else {
			return false;
		}
	}
	
	boolean medioSolo() {
		if(piezas.get(0) == 0 && piezas.get(1) == 1 && piezas.get(0) == 0) {
			return true;
		}else {
			return false;
		}
	}
	
	
	boolean esVacio() {
		if(piezas.get(0) == 0 && piezas.get(1) == 0 && piezas.get(0) == 0) {
			return true;
		}else {
			return false;
		}
	}
	
 
	public void setearPieza(int indicePieza) {
		piezas.set(indicePieza, 0);
	}	
	
	@Override
	public String toString() {
		String mostrar = "";
		Iterator<Integer> it = piezas.iterator();
		while( it.hasNext()) {
			mostrar+= it.next();
		}
		
		return "["+mostrar+"]"+"\n";
		
		//return ""+ piezas + "\n";
	}
}
