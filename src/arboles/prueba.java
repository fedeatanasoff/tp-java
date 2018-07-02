package arboles;

public class prueba {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		ABB arbol = new ABB();

		Nodo n1 = new Nodo(8);
		Nodo n2 = new Nodo(5);
		Nodo n3 = new Nodo(3);
		Nodo n4 = new Nodo(2);
		Nodo n5 = new Nodo(9);
		
		arbol.insertar(8);
		arbol.insertar(4);
		arbol.insertar(2);
		arbol.insertar(6);
		arbol.insertar(3);
		arbol.insertar(1);
		arbol.insertar(7);
		arbol.insertar(15);
		//arbol.insertar(18);
		//arbol.insertar(22);*/
		
		
		System.out.println(arbol.toString());
		//arbol.setearAltura(arbol.raiz);
		arbol.eliminar(2);
		System.out.println(arbol.toString());
	}

}
