package tp;

import java.util.ArrayList;

public class Nivel {

	ArrayList<Integer> piezas;
	
	// constructor: creo las piezas
		public Nivel() {
			piezas = new ArrayList<>();
			for (int i = 0; i < 3; i++) {
				piezas.add(1);
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
 
	public void setearPieza(int indicePieza) {
		piezas.set(indicePieza, 0);
	}	

	public int chequear() {
		if((piezas.get(0) == 0 && piezas.get(1) == 1 && piezas.get(2) == 1) || (piezas.get(0) == 1 && piezas.get(1) == 1 && piezas.get(2) == 0) ) {
			return 10;
		}else if ((piezas.get(0) == 0 && piezas.get(1) == 1 && piezas.get(2) == 0)) {
			return 50;
		}else if ((piezas.get(0) == 0 && piezas.get(1) == 0 && piezas.get(2) == 1) || (piezas.get(0) == 1 && piezas.get(1) == 0 && piezas.get(2) == 0) || (piezas.get(0) == 0 && piezas.get(1) == 0 && piezas.get(2) == 0)) {
			return 100;
		}else {
			return 0;
		}
	}
	
	@Override
	public String toString() {
		return ""+ piezas + ""+"\n";
	}

	void imprimir() {
		for (int i = 0; i < piezas.size(); i++) {
			System.out.println(piezas.get(i));
		}
	}
}
