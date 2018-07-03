package arboles;

public class p {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ABB arbol = new ABB();
		arbol.insertar(5);
		arbol.insertar(3);
		arbol.insertar(1);
		arbol.insertar(8);
		
		System.out.println(arbol.toString());
		System.out.println("nodos insertados: "+arbol.nodosInsertados);
		arbol.eliminar(3);
		System.out.println(arbol.toString());
		System.out.println("nodos insertados: "+arbol.nodosInsertados);
		System.out.println("cantidad de nodos que cumplen con el rango: "+arbol.cantRango(1, 10));
	}

}
