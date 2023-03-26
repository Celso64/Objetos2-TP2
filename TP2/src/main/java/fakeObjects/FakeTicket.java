package fakeObjects;

import java.time.LocalDate;

import restaurante.Ticket;

public class FakeTicket implements Ticket {

	@Override
	public void registrarPago(LocalDate fecha, Double monto) {

		System.out.println("El dia " + fecha.toString() + " se facturo " + monto);

	}

}
