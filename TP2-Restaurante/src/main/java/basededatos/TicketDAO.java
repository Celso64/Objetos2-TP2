package basededatos;

import java.time.LocalDate;

public interface TicketDAO {

	void create(LocalDate fecha, Double monto);

}
