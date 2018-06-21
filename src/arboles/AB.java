package arboles;

public class AB<Integer> {
	Nodo<Integer> raiz;
	
	public AB() {
		this.raiz = null;
	}
	
	public int altura() {
		return (this.raiz == null) ? 0 : altura(raiz);
	}
	
	protected int altura(Nodo<Integer> nodo) {
		int altIzq = (nodo.izq == null) ? 0 : altura(nodo.izq) ;
		int altDer = (nodo.der == null) ? 0 : altura(nodo.der) ;
		return 1 + Math.max(altIzq, altDer);
	}
	
	/*public void agregar(int elemento) {
		Nodo<Integer> n = new Nodo<Integer>(elemento);
		if( raiz == null ) {
			raiz = n;
		}else {
			agregar(raiz, n);
		}
	}
	
	private void agregar(Nodo<Integer> padre, Nodo<Integer> nuevo) {
		if( padre.izq == null) {
			padre.izq = nuevo;
		}else {
			if( padre.der ==  null ) {
				padre.der = nuevo;
			}else {
				agregar(padre.der, nuevo);
			}
		}
	}*/
	
	
	
	public Nodo<Integer> buscar(int valor) {
		return ( this.raiz == null ) ? null : buscar(this.raiz, valor);
	}
	
	private Nodo<Integer> buscar(Nodo<Integer> n, int elem) {
		// cambie equals por == 
		if( n.info == elem ) {
			return n;
		}else {
			Nodo<Integer> izq =  null;
			Nodo<Integer> der =  null;
			
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
	
	private int cantNodos(Nodo<Integer> nodo) {
		int cantIzq = (nodo.izq == null) ? 0 : cantNodos(nodo.izq);
		int cantDer = (nodo.der == null) ? 0 : cantNodos(nodo.der);
		
		return 1 + cantIzq + cantDer;
	}
	
	// version1:
/*	public boolean balanceado() {
		return (raiz == null) ? true : balanceado(raiz);
	}

	private boolean balanceado(Nodo<Integer> nodo) {
		boolean ret = true;
		int altIzq = 0;
		int altDer = 0;
		if (nodo.izq != null) {
			altIzq = altura(nodo.izq);
			ret = ret && balanceado(nodo.izq);
		}
		if (nodo.der != null) {
			altDer = altura(nodo.der);
			ret = ret && balanceado(nodo.der);
		}
		ret = ret && Math.abs(altIzq - altDer) <= 1;
		return ret;
	}*/
	
	//version2:	a veces	conviene hacer 	el caso base sobre 	el nodo

	public boolean balanceado() {
		return balanceado(raiz);
	}

	private boolean balanceado(Nodo<Integer> nodo) {
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
	
	private String toString( Nodo<Integer> nodo ) {
		String ret = nodo.toString() + " ";
		if (nodo.izq != null) ret = ret + toString(nodo.izq)+ " ";
		if (nodo.der != null) ret = ret + toString(nodo.der)+ " ";
		
		return ret;		
	}
	
	
}
