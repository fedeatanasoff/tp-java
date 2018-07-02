package arboles;

public class prueba {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		ABB arbol = new ABB();

		
		
		arbol.insertar(8);
		arbol.insertar(4);
		arbol.insertar(2);
		arbol.insertar(6);
		arbol.insertar(3);
		arbol.insertar(1);
		arbol.insertar(7);
		arbol.insertar(15);
		arbol.insertar(10);
		arbol.insertar(13);
		//arbol.insertar(18);
		//arbol.insertar(22);*/
		
		
		System.out.println(arbol.toString());
		//arbol.setearAltura(arbol.raiz);
		arbol.eliminar(2);
		System.out.println(arbol.toString());
	}

}
