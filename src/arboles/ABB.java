package arboles;

import java.util.ArrayList;

public class ABB extends AB {

	int nodosInsertados;

	public ABB() {
		this.nodosInsertados = 0;
	}
	
	public Nodo buscar(Integer valor) {
		return ( this.raiz == null ) ? null : buscar(this.raiz, valor);
	}
	
	private Nodo buscar(Nodo n, Integer elem) {
		
		if( n.info == elem ) {
			return n;
		}else {
			Nodo izq =  null;
			Nodo der =  null;
			
			if(n.hi != null) izq = buscar(n.hi, elem);
			
			if(n.hd != null) der = buscar(n.hd, elem);
			
			//Decisión de implementación: si esta en ambos lado, mostramos el izquierdo primero
			if (izq != null) {
				return izq;
			}else {
				return der;
			}
		}
	}

	public void insertar(Integer n) {
		this.raiz = insertar(n, this.raiz);
		nodosInsertados++;
	}

	private Nodo insertar(Integer num, Nodo nodo) {
		if (nodo == null)
			return new Nodo(num);

		if (num < nodo.info) {
			nodo.hd = insertar(num, nodo.hd);
		} else {
			nodo.hi = insertar(num, nodo.hi);
		}

		return nodo;
	}

	// BOOLEAN BALANCEADO
	public boolean balanceado() {
		return balanceado(raiz);
	}

	private boolean balanceado(Nodo nodo) {
		if (nodo == null)
			return true;
		else {
			int altIzq = (nodo.hi == null) ? 0 : altura(nodo.hi);
			int altDer = (nodo.hd == null) ? 0 : altura(nodo.hd);
			return Math.abs(altIzq - altDer) <= 1 && balanceado(nodo.hi) && balanceado(nodo.hd);
		}
	}

	public ArrayList<Integer> inOrden() {
		ArrayList<Integer> listInorden = new ArrayList<>();
		return inorden(this.raiz, listInorden);
	}

	private ArrayList<Integer> inorden(Nodo nodo, ArrayList<Integer> listInorden) {
		if (nodo != null) {
			// acomodo izq
			listInorden = inorden(nodo.hi, listInorden);
			// meto raiz
			listInorden.add(nodo.info);
			// acomodo der
			listInorden = inorden(nodo.hd, listInorden);

		}
		return listInorden;
	}
	

	public int nodosInsertados()
	{
		return (this.raiz==null) ? 0: nodosInsertados(this.raiz);
	}
	
	private int nodosInsertados(Nodo nodo)
	{
		int cantIzq= (nodo.hi == null) ? 0 : nodosInsertados(nodo.hi);
		int cantDer= (nodo.hd == null) ? 0 : nodosInsertados(nodo.hd);
		return 1 +cantIzq+ cantDer;	
	}
	
	public boolean irep()
	{
		return ((this.nodosInsertados() ==  this.nodosInsertados)) ? true : false;
	}
	
	public void romperIrep()
	{
		this.nodosInsertados++;
	}
	/*
	private int cantNodosIzq(NodoABB<Integer> nodo)
	{
		int cantIzq= (nodo.izq == null) ?0 : cantNodosIzq(nodo.izq);
		return cantIzq;
		
	}
	private int cantNodosDer(NodoABB<Integer> nodo)
	{
		int cantDer= (nodo.der == null) ?0 : cantNodosDer(nodo.der);
		return cantDer;
		
	}
	
	/*
	private int cantNodosIzq(NodoABB<Integer> nodo)
	{
		int cantIzq= (nodo.izq == null) ?0 : cantNodosIzq(nodo.izq);
		return cantIzq;
		
	}
	private int cantNodosDer(NodoABB<Integer> nodo)
	{
		int cantDer= (nodo.der == null) ?0 : cantNodosDer(nodo.der);
		return cantDer;
		
	}
	
	/*public boolean eliminar(Integer valor) {
		Nodo aux = this.raiz;
		Nodo padre = this.raiz;
		boolean hijoIzq = true;

		while (aux.info != valor) {
			padre = aux;

			if (valor < aux.info) {
				hijoIzq = true;
				aux = aux.hi;
			} else {
				hijoIzq = false;
				aux = aux.hi;
			}

			if (aux == null) {
				System.out.println("no encontro el nodo");
				return false;
			}
		} // ---- while

		if (aux.hi == null && aux.hd == null) { // pregunto si es hoja
			if (aux == this.raiz) {
				this.raiz = null;
			} else if (hijoIzq) {
				padre.hi = null;
			} else {
				padre.hd = null;
			}
		} else if (aux.hd == null) {
			if (aux == this.raiz) {
				this.raiz = aux.hd;
			} else if (hijoIzq) {
				padre.hi = aux.hi;
			} else {
				padre.hd = aux.hi;
			}
		} else if (aux.hi == null) {
			if (aux == this.raiz) {
				this.raiz = aux.hd;
			} else if (hijoIzq) {
				padre.hi = aux.hd;
			} else {
				padre.hd = aux.hi;
			}
		} else {

			Nodo nodo = reemplazarNodo(aux);
			if (aux == this.raiz) {
				this.raiz = nodo;
			} else if (hijoIzq) {
				padre.hi = nodo;
			} else {
				padre.hd = nodo;
			}
			nodo.hi = aux.hi;
		}
		System.out.println("encontro a nuestro nodo a eliminar");
		return true;
	}
	
	
	public Nodo reemplazarNodo(Nodo n) {
		Nodo nodo = n;
		Nodo reemplazar = n;
		Nodo aux = n.hd;
		
		while(aux != null) {
			n = reemplazar;
			reemplazar = aux;
			aux = aux.hi;
		}
		
		if( reemplazar != n.hd) {
			nodo.hi = reemplazar.hd;
			reemplazar.hd = reemplazar.hd;
		}
		System.out.println("nodo reemplazo es :"+ reemplazar);
		return reemplazar;
	}*/


}

