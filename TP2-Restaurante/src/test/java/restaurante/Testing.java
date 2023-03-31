package restaurante;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import fakeObjects.FakeTicket;

class Testing {

	private Tarjeta tarjetaDeCredito;
	private FakeTicket ticket = new FakeTicket();

	@Test
	void ProbandoVisa() {
		ticket.resetUltimoLlamado();
		tarjetaDeCredito = new Visa();
		Bebida bebida = new Bebida(900.0);
		Cuenta cuenta = new Cuenta(ticket);

		cuenta.addProducto(bebida);
		Double precio = tarjetaDeCredito.pagarCuenta(cuenta, Cuenta.PROPINA_MEDIA);
		Boolean seAlmaceno = ticket.getUltimaLlamadaCorrecta();

		assertTrue(seAlmaceno);
		assertEquals(899.19, precio);
	}

	@Test
	void ProbandoMasterCard() {
		ticket.resetUltimoLlamado();
		tarjetaDeCredito = new Mastercard();
		Comida comida = new Comida(900.0);
		Cuenta cuenta = new Cuenta(ticket);
		cuenta.addProducto(comida);
		Double precio = tarjetaDeCredito.pagarCuenta(cuenta, Cuenta.PROPINA_MEDIA);

		Boolean seAlmaceno = ticket.getUltimaLlamadaCorrecta();

		assertTrue(seAlmaceno);
		assertEquals(908.46, precio);
	}

	@Test
	void ProbandoComarcaPlus() {
		ticket.resetUltimoLlamado();
		tarjetaDeCredito = new ComarcaPlus();
		Comida comida = new Comida(900.0);
		Cuenta cuenta = new Cuenta(ticket);
		cuenta.addProducto(comida);
		Double precio = tarjetaDeCredito.pagarCuenta(cuenta, Cuenta.PROPINA_MEDIA);

		Boolean seAlmaceno = ticket.getUltimaLlamadaCorrecta();

		assertTrue(seAlmaceno);
		assertEquals(908.46, precio);
	}

	@Test
	void ProbandoViedma() {
		ticket.resetUltimoLlamado();
		tarjetaDeCredito = new Viedma();
		Comida comida = new Comida(900.0);
		Cuenta cuenta = new Cuenta(ticket);
		cuenta.addProducto(comida);
		Double precio = tarjetaDeCredito.pagarCuenta(cuenta, Cuenta.PROPINA_MEDIA);

		Boolean seAlmaceno = ticket.getUltimaLlamadaCorrecta();

		assertTrue(seAlmaceno);
		assertEquals(927.0, precio);
	}

}
