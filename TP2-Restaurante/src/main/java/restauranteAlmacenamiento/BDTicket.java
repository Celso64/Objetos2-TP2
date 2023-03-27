package restauranteAlmacenamiento;

import java.time.LocalDate;

import baseDeDatos.TicketDAO;
import restaurante.Ticket;

public class BDTicket implements Ticket {

	private TicketDAO ticketDatos;

	public BDTicket(TicketDAO ticketDatos) {
		super();
		this.ticketDatos = ticketDatos;
	}

	@Override
	public void registrarPago(LocalDate fecha, Double monto) {

		this.ticketDatos.create(fecha, monto);

	}

}
