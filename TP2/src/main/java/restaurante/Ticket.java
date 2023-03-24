package restaurante;

import java.time.LocalDate;

public interface Ticket {

	void registrarPago(LocalDate fecha, Double monto);

}
