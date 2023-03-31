package fakeObjects;

import java.time.LocalDate;

import restaurante.Ticket;

public class FakeTicket implements Ticket {

	private Boolean ultimaLlamadaCorrecta;

	public FakeTicket() {
		this.ultimaLlamadaCorrecta = false;
	}

	@Override
	public void registrarPago(LocalDate fecha, Double monto) {

		this.ultimaLlamadaCorrecta = true;

	}

	public Boolean getUltimaLlamadaCorrecta() {
		return ultimaLlamadaCorrecta;
	}

	public void resetUltimoLlamado() {
		this.ultimaLlamadaCorrecta = false;
	}

}
