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
