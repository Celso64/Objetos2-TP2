package restauranteAlmacenamiento;

import java.io.OutputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import restaurante.Ticket;

public class ArchivoTicket implements Ticket {

	private OutputStream salida;
	private DateTimeFormatter formato;

	public ArchivoTicket(OutputStream salida) {
		this.salida = salida;
	}

	public ArchivoTicket(OutputStream salida, DateTimeFormatter formatoFecha) {
		this(salida);
		this.formato = formatoFecha;
	}

	@Override
	public void registrarPago(LocalDate fecha, Double monto) {

		try {

			String fechaString = (this.formato == null) ? fecha.toString() : fecha.format(formato).toString();

			StringBuffer cadena = new StringBuffer(fechaString);
			cadena.append(" || ").append(monto.toString()).append("\n");

			String registro = cadena.toString();

			this.salida.write(registro.getBytes());
		} catch (Exception e) {

		}

	}

}
