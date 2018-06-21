package arboles;

public class Prueba {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		ABB<Integer> arbol = new ABB<>();
		arbol.insertar(15);
		arbol.insertar(10);
		
		arbol.insertar(9);
		arbol.insertar(21);
		arbol.insertar(18);
		arbol.insertar(27);
		
		System.out.println(arbol.toString());
		System.out.println(arbol.balanceado());
		arbol.eliminar(11);
		
		System.out.println(arbol.toString());
		System.out.println(arbol.balanceado());
		System.out.println(arbol.cantNodos());
		
	}

}
