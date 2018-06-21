package arboles;

public class ABB<Integer> extends AB<Integer> {
	
	int nodosCant;
	
	public ABB() {
		this.nodosCant = 0;
	};

	boolean pertenece(int x, Nodo<Integer> nodo) { 
		if (nodo == null) return false;
		
		if (x < nodo.info) return pertenece(x, nodo.izq); 
		if (x > nodo.info) return pertenece(x, nodo.der); 
		
		return (x == nodo.info); 
		}
	
	public void insertar(int n) {
		this.raiz = insertar(n, this.raiz);
		nodosCant++;
	}
	
	private Nodo<Integer> insertar (int num, Nodo<Integer> nodo){
		if(nodo == null) return new Nodo<Integer>(num);
		
		if( num < nodo.info) {
			nodo.der=insertar(num, nodo.der);
		}else {
			nodo.izq=insertar(num, nodo.izq);
		}			
		
		return nodo;
	}
	
	public void eliminar(int x)
	{
		this.raiz= eliminar(x, this.raiz);	
	}

	protected Nodo<Integer> eliminar(int x, Nodo<Integer> nodo) {
		if (nodo == null)
			return null;
		if (x == nodo.info) {
			// Es una hoja o tiene un solo hijo: devolver el otro.
			// (No hace falta recursión cuando hay un solo hijo.)
			if (nodo.izq == null)
				return nodo.der;
			if (nodo.der == null)
				return nodo.izq;
			// Tiene dos hijos: intercambiar por el maximo de la izquierda.
			nodo.info = maxVal(nodo.izq);
			nodo.izq = eliminar(nodo.info, nodo.izq);
		} else if (x < nodo.info) {
			nodo.izq = eliminar(x, nodo.izq);
		} else if (x > nodo.info) {
			nodo.der = eliminar(x, nodo.der);
		}
		return nodo;
	}

	private int maxVal(Nodo<Integer> nodo) {
		while (nodo.der != null) {
			nodo = nodo.der;
		}
		return nodo.info;
	}
	
	// BOOLEAN BALANCEADO
	public boolean balanceado() {
		return balanceado(raiz);
	}

	private boolean balanceado(Nodo<Integer> nodo) {
		if (nodo == null)
			return true;
		else {
			int altIzq = (nodo.izq == null) ? 0 : super.altura(nodo.izq);
			int altDer = (nodo.der == null) ? 0 : super.altura(nodo.der);
			return Math.abs(altIzq - altDer) <= 1 && balanceado(nodo.izq) && balanceado(nodo.der);
		}
	}
	
}
