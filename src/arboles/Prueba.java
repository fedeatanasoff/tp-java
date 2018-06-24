package arboles;

public class Prueba {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		ABB abBalanceado, abVacio, abDesbalanceado;
		abVacio = new ABB();
		abDesbalanceado = new ABB();
		abDesbalanceado.insertar(5);
		abDesbalanceado.insertar(6);
		abDesbalanceado.insertar(1);
		
		abBalanceado = new ABB();
		abBalanceado.insertar(8);
		abBalanceado.insertar(3);
		abBalanceado.insertar(10);
		abBalanceado.insertar(1);
		abBalanceado.insertar(6);
		abBalanceado.insertar(4);
		abBalanceado.insertar(7);
		abBalanceado.insertar(14);
		abBalanceado.insertar(9);
		
		/*System.out.println(abBalanceado.balanceado());
		System.out.println(abVacio.balanceado());*/
		System.out.println(abDesbalanceado.balanceado());
		System.out.println(abDesbalanceado.toString());
		//abDesbalanceado.rebalancear();
		//System.out.println(abDesbalanceado.buscar(2));
		//abDesbalanceado.borrar(4);
		//System.out.println(abDesbalanceado.toString());
		
		//System.out.println();
	}

}
