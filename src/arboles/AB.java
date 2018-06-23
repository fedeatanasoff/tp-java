package arboles;

public class AB {
	Nodo raiz;
	
	public AB() {
		this.raiz = null;
	}
	
	public int altura() {
		return (this.raiz == null) ? 0 : altura(raiz);
	}
	
	protected int altura(Nodo nodo) {
		int altIzq = (nodo.izq == null) ? 0 : altura(nodo.izq) ;
		int altDer = (nodo.der == null) ? 0 : altura(nodo.der) ;
		return 1 + Math.max(altIzq, altDer);
	}
	
	public Nodo buscar(int valor) {
		return ( this.raiz == null ) ? null : buscar(this.raiz, valor);
	}
	
	private Nodo buscar(Nodo n, int elem) {
		// cambie equals por == 
		if( n.info == elem ) {
			return n;
		}else {
			Nodo izq =  null;
			Nodo der =  null;
			
			if(n.izq != null) izq = buscar(n.izq, elem);
			
			if(n.der != null) der = buscar(n.der, elem);
			
			//Decisión de implementación: si esta en ambos lado, mostramos el izquierdo primero
			if (izq != null) {
				return izq;
			}else {
				return der;
			}
		}
	}
	
	public int cantNodos() {
		return (this.raiz == null) ? 0 : cantNodos(this.raiz);
	}
	
	private int cantNodos(Nodo nodo) {
		int cantIzq = (nodo.izq == null) ? 0 : cantNodos(nodo.izq);
		int cantDer = (nodo.der == null) ? 0 : cantNodos(nodo.der);
		
		return 1 + cantIzq + cantDer;
	}

	public boolean balanceado() {
		return balanceado(raiz);
	}

	private boolean balanceado(Nodo nodo) {
		if (nodo == null)
			return true;
		else {
			int altIzq = (nodo.izq == null) ? 0 : altura(nodo.izq);
			int altDer = (nodo.der == null) ? 0 : altura(nodo.der);
			return Math.abs(altIzq - altDer) <= 1 && balanceado(nodo.izq) && balanceado(nodo.der);
		}
	}
	
	@Override
	public String toString() {
		return (this.raiz == null) ? "" : toString(this.raiz);
	}
	
	private String toString( Nodo nodo ) {
		String ret = nodo.toString() + " ";
		if (nodo.izq != null) ret = ret + toString(nodo.izq)+ " ";
		if (nodo.der != null) ret = ret + toString(nodo.der)+ " ";
		
		return ret;		
	}
	
	
}
