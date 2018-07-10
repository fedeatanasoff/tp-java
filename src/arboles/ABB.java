package arboles;

import java.util.ArrayList;

public class ABB extends AB {

	int nodosInsertados;
	int altura;

	public ABB() {
		this.nodosInsertados = 0;
	}

	public boolean esRaiz(Nodo nodo) {
		return this.raiz == nodo;
	}

	public boolean esHoja(Nodo nodo) {
		return nodo.hi == null && nodo.hd == null;
	}

	public boolean esInterno(Nodo nodo) {
		return !esHoja(nodo);
	}

	public Nodo buscar(Integer valor) {
		return (this.raiz == null) ? null : buscar(this.raiz, valor);
	}

	private Nodo buscar(Nodo n, Integer elem) {

		if (n.info == elem) {
			return n;
		} else {
			Nodo izq = null;
			Nodo der = null;

			if (n.hi != null)
				izq = buscar(n.hi, elem);

			if (n.hd != null)
				der = buscar(n.hd, elem);

			// Decisión de implementación: si esta en ambos lado, mostramos el izquierdo
			// primero
			if (izq != null) {
				return izq;
			} else {
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
		setearAltura(nodo);
		return nodo;
	}

	public int altura(Nodo nodo) {
		int altura = 0;

		if (esInterno(nodo)) {

			if (nodo.hi != null) {
				altura = Math.max(altura, altura(nodo.hi));
			}

			if (nodo.hd != null) {
				altura = Math.max(altura, altura(nodo.hd));
			}
			altura++;
		}
		return altura;
	}

	public void setearAltura(Nodo nodo) {
		nodo.setAltura(altura(nodo));
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

	public int nodosInsertados() {
		return (this.raiz == null) ? 0 : nodosInsertados(this.raiz);
	}

	private int nodosInsertados(Nodo nodo) {
		int cantIzq = (nodo.hi == null) ? 0 : nodosInsertados(nodo.hi);
		int cantDer = (nodo.hd == null) ? 0 : nodosInsertados(nodo.hd);
		return 1 + cantIzq + cantDer;
	}

	/*
	 * // BOOLEAN BALANCEADO VIEJO public boolean balanceado() { return
	 * balanceado(raiz); }
	 * 
	 * private boolean balanceado(Nodo nodo) { if (nodo == null) return true; else {
	 * int altIzq = (nodo.hi == null) ? 0 : altura(nodo.hi); int altDer = (nodo.hd
	 * == null) ? 0 : altura(nodo.hd); return Math.abs(altIzq - altDer) <= 1 &&
	 * balanceado(nodo.hi) && balanceado(nodo.hd); } }
	 */

	public boolean balanceado() {
		return (this.raiz == null) ? true : balanceado1(this.raiz);
	}

	private boolean balanceado1(Nodo n) {
		boolean condicion = true;
		int altizq = 0;
		int altder = 0;

		if (n.hi != null) {
			altizq = n.altura;
			condicion = condicion && balanceado(n.hi);
		}
		if (n.hd != null) {
			altder = n.altura;
			condicion = condicion && balanceado(n.hd);
		}
		int dif = Math.abs(altizq - altder);
		return condicion && dif <= 1;
	}

	// romper IREP
	public boolean irep() {
		return ((this.nodosInsertados() == this.nodosInsertados)) ? true : false;
	}

	private boolean balanceado(Nodo nodo) {
		if (nodo == null) {
			return true;
		} else {
			int altIzq = (nodo.hi == null) ? 0 : nodo.hi.altura;
			int altDer = (nodo.hd == null) ? 0 : nodo.hd.altura;
			return Math.abs(altIzq - altDer) <= 1 && balanceado(nodo.hi) && balanceado(nodo.hd);
		}
	}

	public void romperIrep() {
		this.nodosInsertados++;
	}

	public void eliminar(Integer valor) {
		if (buscar(valor) != null) {
			this.raiz = eliminar(valor, this.raiz);
			nodosInsertados--;

		} else
			System.out.println("No esta");
	}

	private Nodo eliminar(Integer x, Nodo nodo) {
		if (nodo.equals(null))
			return null;
		if (x.equals(nodo.info)) {
			// Es una hoja o tiene un solo hijo: devolver el otro.
			// (No hace falta recursión cuando hay un solo hijo.)
			if (nodo.hi == null) {
				// setearAltura(nodo.hd);
				return nodo.hd;
			}

			if (nodo.hd == null) {
				// setearAltura(nodo.hi);
				return nodo.hi;
			}

			// Tiene dos hijos: intercambiar por el maximo de la izquierda.
			nodo.info = maxVal(nodo.hi);
			nodo.hi = eliminar(nodo.info, nodo.hi);

		} else if (x.compareTo(nodo.info) < 0) {
			nodo.hi = eliminar(x, nodo.hi);
		} else if (x.compareTo(nodo.info) > 0) {
			nodo.hd = eliminar(x, nodo.hd);
		}
		// SETEO LA ALTURA
		setearAltura(nodo);
		return nodo;
	}

	private int maxVal(Nodo nodo) {
		while (nodo.hd != null) {
			nodo = nodo.hd;
		}
		return nodo.info;
	}

	public void rebalancear() {
		this.raiz = null;
		ArrayList<Integer> nodosArbol = inOrden();

		rebalancear(nodosArbol);
	}

	private void rebalancear(ArrayList<Integer> nodosArbol) {
		ArrayList<Integer> nodosIzq = new ArrayList<Integer>();
		ArrayList<Integer> nodosDer = new ArrayList<Integer>();

		Integer menores = 0;
		Integer mayores = nodosArbol.size() / 2 + 1;

		if (nodosArbol.size() > 0) {
			int pivote = nodosArbol.get(nodosArbol.size() / 2);
			insertar(pivote);
			while (menores.compareTo(nodosArbol.size() / 2) < 0) {
				nodosIzq.add(nodosArbol.get(menores));
				menores++;
			}
			while (mayores.compareTo(nodosArbol.size()) < 0) {
				nodosDer.add(nodosArbol.get(mayores));
				mayores++;
			}
			if (nodosIzq != null) rebalancear(nodosIzq);
			if (nodosDer != null) rebalancear(nodosDer);
		}
	}
	// IENESIMO
	/*public int iesimo(int pos)
	{
		if(raiz==null || this.cantNodos<pos-1)
			return -1;
		if (pos==cantNodosIzq(raiz))
			return raiz.elemento;
		if (pos< cantNodosIzq(raiz))
			return iesimo(pos, raiz.izq);
		else
			return iesimo( raiz.der,pos,cantNodosIzq(raiz)+1);
	}
	
	private int iesimo(int pos, NodoABB nodo)
	{
		if (pos==cantNodosIzq(nodo))
			return  (Integer)nodo.elemento;
		if (pos<cantNodosIzq(nodo))
			return iesimo(pos, nodo.izq);
		else 
			return iesimo(nodo.der,pos,  cantNodosIzq(nodo)+1);
	}
	
	private int iesimo(NodoABB nodo, int pos,int cantNodos)
	{
		if(pos==cantNodosIzq(nodo)+cantNodos) 
			return (Integer) nodo.elemento;
		if(pos>cantNodosDer(nodo)+cantNodos) 
			return iesimo(nodo.izq, pos, cantNodos);
		else
			return iesimo(nodo.der, pos, cantNodosIzq(nodo)+cantNodos+1);
		
	}*/

}
