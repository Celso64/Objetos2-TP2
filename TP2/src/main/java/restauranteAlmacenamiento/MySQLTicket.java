package restauranteAlmacenamiento;

import java.time.LocalDate;

import baseDeDatos.TicketDAO;
import restaurante.Ticket;

public class MySQLTicket implements Ticket {

	private TicketDAO ticketDatos;

	public MySQLTicket(TicketDAO ticketDatos) {
		super();
		this.ticketDatos = ticketDatos;
	}

	@Override
	public void registrarPago(LocalDate fecha, Double monto) {

		this.ticketDatos.create(fecha, monto);

	}

}
