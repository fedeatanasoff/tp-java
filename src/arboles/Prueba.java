package arboles;

public class Prueba {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		ABB<Integer> arbol = new ABB<>();
		arbol.insertar(10);
		arbol.insertar(5);
		
		arbol.insertar(12);
		arbol.insertar(1);
		arbol.insertar(11);
		
		System.out.println(arbol.toString());
		System.out.println(arbol.balanceado());
		
	}

}
