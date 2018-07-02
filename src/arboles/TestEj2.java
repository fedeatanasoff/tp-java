package arboles;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class TestEj2 {
	ABB abBalanceado, abVacio, abDesbalanceado;

	@Before
	public void setUp() throws Exception {
		abVacio = new ABB();
		
		abDesbalanceado = new ABB();
		abDesbalanceado.insertar(5);
		abDesbalanceado.insertar(3);
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
	}

	@Test
	public void testBalanceado() {
		assertTrue(abBalanceado.balanceado());
		assertTrue(abVacio.balanceado());
		assertFalse(abDesbalanceado.balanceado());
	}
	
	@Test
	public void testIrep() {
		assertTrue(abVacio.irep());
		assertTrue(abDesbalanceado.irep());
		assertTrue(abBalanceado.irep());
		abBalanceado.romperIrep();
		assertFalse(abBalanceado.irep());
	}
	
	@Test
	public void testEliminar() {
		abBalanceado.eliminar(14);
		assertNull(abBalanceado.buscar(14));
	}
	
	@Test
	public void testAltura() {
		//System.out.println(abBalanceado.toString());
		assertTrue(abBalanceado.buscar(1).getAltura() == 0);
		abBalanceado.eliminar(3);
		assertFalse(abBalanceado.buscar(1).getAltura() == 0);
		//System.out.println(abBalanceado.toString());
	}
	
	
}
