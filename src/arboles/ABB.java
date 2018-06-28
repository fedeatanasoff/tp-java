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

		if (num.compareTo(nodo.info) > 0) {
			nodo.hd = insertar(num, nodo.hd);
		} else {
			nodo.hi = insertar(num, nodo.hi);
		}

		return nodo;
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
	
	// romper IREP
	public boolean irep()
	{
		return ((this.nodosInsertados() ==  this.nodosInsertados)) ? true : false;
	}
	
	public void romperIrep()
	{
		this.nodosInsertados++;
	}
	
	public void eliminar(Integer valor) {
		this.raiz = eliminar(valor, this.raiz);
	}
	
	// ELIMINAR
	private Nodo eliminar(Integer x, Nodo nodo) {
		if (nodo.equals(null))
			return null;
		if (x.equals(nodo.info)) {
			// Es una hoja o tiene un solo hijo: devolver el otro.
			// (No hace falta recursión cuando hay un solo hijo.)
			if (nodo.hi == null)
				return nodo.hd;
			if (nodo.hd == null)
				return nodo.hi;
			// Tiene dos hijos: intercambiar por el maximo de la izquierda.
			nodo.info = maxVal(nodo.hi);
			nodo.hi = eliminar(nodo.info, nodo.hi);
			
		} else if (x.compareTo(nodo.info) < 0) {
			nodo.hi = eliminar(x, nodo.hi);
		} else if (x.compareTo(nodo.info) > 0) {
			nodo.hd = eliminar(x, nodo.hd);
		}
		return nodo;
	}

	private int maxVal(Nodo nodo) {
		while (nodo.hd != null) {
			nodo = nodo.hd;
		}
		return nodo.info;
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
		
	}*/

}

