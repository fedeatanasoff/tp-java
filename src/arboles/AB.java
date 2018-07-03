package arboles;

public class AB {
	Nodo raiz;
	
	public AB(){
		this.raiz = null;
	}
	
	public boolean estaVacio() {
		return this.raiz == null;
	}
	
	
	
	public void insertar(Integer elem) {
		Nodo nuevo = new Nodo(elem);
		if (raiz == null)
			raiz = nuevo;
		else
			insertar(raiz, nuevo);
	}

	private void insertar(Nodo padre, Nodo nuevo) {
		if (padre.hi == null)
			padre.hi = nuevo;
		else if (padre.hd == null)
			padre.hd = nuevo;
		else
			// Decisión de implementación: genera el arbol a derecha
			insertar(padre.hd, nuevo);
	}
	
	int cantRango(int desde, int hasta) {
		return cantRango(desde, hasta, this.raiz);
	}
	
	private int cantRango(int desde, int hasta, Nodo nodo) {
		if( nodo == null) return 0;
		int cant = 0;
		
		if( desde <= nodo.info && nodo.info <= hasta) {
			cant = 1;
		}
		
		return cant + cantRango(desde, hasta, nodo.hi) + cantRango(desde, hasta, nodo.hd);
	}
	
	/*
	 * 
	 * public int altura() {
		return (this.raiz == null) ? 0 : altura(raiz);
	}
	protected int altura(Nodo nodo) {
		int altIzq = (nodo.hi == null) ? 0 : altura(nodo.hi) ;
		int altDer = (nodo.hd == null) ? 0 : altura(nodo.hd) ;
		return 1 + Math.max(altIzq, altDer);
	}	*/
		
	@Override
	public String toString() {
		return (this.raiz == null) ? "" : toString(this.raiz);
	}
	
	private String toString( Nodo nodo ) {
		String ret = nodo.toString() + " ";
		if (nodo.hi != null) ret = ret + toString(nodo.hi)+ " ";
		if (nodo.hd != null) ret = ret + toString(nodo.hd)+ " ";
		
		return ret;		
	}
	
	
	
}
