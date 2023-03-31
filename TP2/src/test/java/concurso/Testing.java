package concurso;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import fakeobjects.FakeNotificador;
import fakeobjects.FakePlanillaInscriptos;

class Testing {

	private FakePlanillaInscriptos registrador = new FakePlanillaInscriptos();
	private FakeNotificador notificador = new FakeNotificador();

	@Test
	void elParticipanteSeAgregoEnFecha() {
		this.resetBooleans();
		Concurso c = new Concurso(1L, LocalDate.now().minusDays(1L), 10, registrador, notificador);
		Participante p = new Participante(1L, "JUAN");

		c.sumarParticipante(p);

		Boolean registro = registrador.getUltimoUsofueCorrecto();
		Boolean notificacion = registrador.getUltimoUsofueCorrecto();

		assertEquals(0, p.getPuntos());
		assertTrue(registro);
		assertTrue(notificacion);
	}

	@Test
	void elParticipanteSeAgregoElPrimerDia() {
		this.resetBooleans();
		Concurso c = new Concurso(2L, LocalDate.now(), 10, registrador, notificador);
		Participante p = new Participante(2L, "JUAN");

		c.sumarParticipante(p);

		Boolean registro = registrador.getUltimoUsofueCorrecto();
		Boolean notificacion = registrador.getUltimoUsofueCorrecto();

		assertEquals(10, p.getPuntos());
		assertTrue(registro);
		assertTrue(notificacion);

	}

	@Test
	void elParticipanteSeAgregoFueraDeFecha() {
		this.resetBooleans();
		Concurso c = new Concurso(LocalDate.of(2023, 1, 10), 1, registrador, notificador);
		Participante p = new Participante(1L, "JUAN");

		Exception exception = assertThrows(Exception.class, () -> {
			c.sumarParticipante(p);
		});

		String msjEsperado = "Plazo Vencido";
		String msjActual = exception.getMessage();
		Boolean registro = registrador.getUltimoUsofueCorrecto();
		Boolean notificacion = registrador.getUltimoUsofueCorrecto();

		assertTrue(msjEsperado.equals(msjActual));
		assertFalse(registro);
		assertFalse(notificacion);
	}

	private void resetBooleans() {
		this.registrador.resetUltimoUso();
		this.notificador.resetUltimoUso();
	}

}
