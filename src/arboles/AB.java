package arboles;

public class AB<integer> {
	Nodo raiz;
	
	public AB() {
		this.raiz = null;
	}
	
	public int altura() {
		return (this.raiz == null) ? 0 : altura(raiz);
	}
	
	private int altura(Nodo nodo) {
		int altIzq = (nodo.izq == null) ? 0 : altura(nodo.izq) ;
		int altDer = (nodo.der == null) ? 0 : altura(nodo.der) ;
		return 1 + Math.max(altIzq, altDer);
	}
}
