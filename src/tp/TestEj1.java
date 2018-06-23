package tp;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class TestEj1 {
	private Jenga jenga1, jenga2;
	ArrayList<String> jugadores;

	@Before
	public void setUp() {
		jugadores = new ArrayList<String>();
		jugadores.add("jug0");
		jugadores.add("jug1");
		jugadores.add("jug2");
		
		jenga1 = new Jenga(10, jugadores);
		jenga2 = new Jenga(10, jugadores);
	}

	@Test
	public void test1() {
		int alturaInicial = jenga1.altura();
		jenga1.Jugar();
		jenga1.Jugar();
		jenga1.Jugar();
		// System.out.println(alturaInicial +","+ jenga1.altura());
		// deberia cambiar la altura
		assertTrue(alturaInicial != jenga1.altura());
	}
	/*
	@Test
	public void test2() {
		int nivel = jenga2.primerNivelPosible();
		jenga2.quitar(nivel, 0);
		jenga2.quitar(nivel, 1);
		jenga2.quitar(nivel, 2);
		System.out.println(jenga2.ganador());
		// deberia haberse caido el jenga!
		assertTrue(!jenga2.ganador().equals(""));
	}*/
}
