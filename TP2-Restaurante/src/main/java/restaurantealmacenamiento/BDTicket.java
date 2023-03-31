package restaurantealmacenamiento;

import java.time.LocalDate;
import java.util.Objects;

import basededatos.TicketDAO;
import restaurante.Ticket;

public class BDTicket implements Ticket {

	private TicketDAO ticketDatos;

	public BDTicket(TicketDAO ticketDatos) {
		super();
		this.ticketDatos = Objects.requireNonNull(ticketDatos);
	}

	@Override
	public void registrarPago(LocalDate fecha, Double monto) {

		this.ticketDatos.create(fecha, monto);

	}

}
