package concurso;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import fakeObjects.FakePlanillaInscriptos;

class Testing {

	@Test
	void elParticipanteSeAgregoEnFecha() {
		Concurso c = new Concurso(1L, LocalDate.now().minusDays(1L), 10, new FakePlanillaInscriptos());
		Participante p = new Participante(1L, "JUAN");

		c.sumarParticipante(p);

		assertEquals(0, p.getPuntos());

	}

	@Test
	void elParticipanteSeAgregoElPrimerDia() {
		Concurso c = new Concurso(2L, LocalDate.now(), 10, new FakePlanillaInscriptos());
		Participante p = new Participante(2L, "JUAN");

		c.sumarParticipante(p);

		assertEquals(10, p.getPuntos());

	}

	@Test
	void elParticipanteSeAgregoFueraDeFecha() {
		Concurso c = new Concurso(LocalDate.of(2023, 1, 10), 10, new FakePlanillaInscriptos());
		Participante p = new Participante(1L, "JUAN");

		Exception exception = assertThrows(RuntimeException.class, () -> {
			c.sumarParticipante(p);
		});

		String msjEsperado = "Plazo Vencido";
		String msjActual = exception.getMessage();

		assertTrue(msjEsperado.contains(msjActual));

	}

}
