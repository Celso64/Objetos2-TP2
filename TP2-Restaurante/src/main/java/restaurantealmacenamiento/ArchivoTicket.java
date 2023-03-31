package restaurantealmacenamiento;

import java.io.OutputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.Optional;

import restaurante.Ticket;

public class ArchivoTicket implements Ticket {

	private OutputStream salida;
	private DateTimeFormatter formato;

	public ArchivoTicket(OutputStream salida) {
		this.salida = Objects.requireNonNull(salida);
	}

	public ArchivoTicket(OutputStream salida, DateTimeFormatter formatoFecha) {
		this(salida);
		this.formato = (Optional.ofNullable(formatoFecha)).orElse(DateTimeFormatter.ISO_DATE);
	}

	@Override
	public void registrarPago(LocalDate fecha, Double monto) {

		try {

			String fechaString = fecha.format(formato).toString();

			StringBuffer cadena = new StringBuffer(fechaString);
			cadena.append(" || ").append(monto.toString()).append("\n");

			String registro = cadena.toString();

			this.salida.write(registro.getBytes());
		} catch (Exception e) {

		}

	}

}
