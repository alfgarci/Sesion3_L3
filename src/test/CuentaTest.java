package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import pkg.Cuenta;

class CuentaTest {

	private static Cuenta cuenta, c1, c2;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		c1 = new Cuenta("12345", "Titular_1", 50);
		c2 = new Cuenta("67890", "Titular_2", 0);
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	@DisplayName("Ingresar dinero")
	void testIngresar(TestInfo info) {
		double ingreso = 2500;
		double saldo = cuenta.getSaldo();
		cuenta.ingreso(ingreso);
		saldo += ingreso;
		assertEquals(saldo, cuenta.getSaldo());
	}
	
	@Test
	@DisplayName("Retirar dinero")
	void testRetirar(TestInfo info) {
		double retirar = 500;
		double saldo = cuenta.getSaldo();
		cuenta.reintegro(retirar);
		saldo -= retirar;
		assertEquals(saldo, cuenta.getSaldo());
	}
	
	@Test
	@DisplayName("Test Sesion3_L3")
	void testMovimiento(TestInfo info) {
		System.out.println("Ejecutando prueba: " + info.getTestMethod().get().getName());
		assertTrue(c1.reintegro(200));
		assertTrue(c2.reintegro(350));
		c1.ingreso(100);
		assertFalse(c2.reintegro(200));
		assertTrue(c2.reintegro(150));
		assertTrue(c1.reintegro(200));
		c2.ingreso(50);
		assertFalse(c2.reintegro(100));
		System.out.println(c1.toString() + c2.toString());
	}
}
