package concursoalmacenamiento;

import java.io.OutputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import concurso.PlanillaIncriptos;

public class ArchivoPlanillaInscriptos implements PlanillaIncriptos {

	private OutputStream salida;
	private DateTimeFormatter formato;

	public ArchivoPlanillaInscriptos(OutputStream salida) {
		this.salida = Objects.requireNonNull(salida);
	}

	public ArchivoPlanillaInscriptos(OutputStream salida, DateTimeFormatter formatoFecha) {
		this(salida);
		this.formato = (Optional.ofNullable(formatoFecha)).orElse(DateTimeFormatter.ISO_DATE);
		;
	}

	public void incribirParticipante(LocalDate fecha, Long idParticipante, Long idConcurso) {

		String fechaString = fecha.format(formato).toString();

		StringBuffer stringBuffer = new StringBuffer(24);

		List<String> partesDelMensaje = List.of(fechaString, ", ", idParticipante.toString(), ", ",
				idConcurso.toString(), "\n");

		partesDelMensaje.forEach(stringBuffer::append);

		String mensaje = stringBuffer.toString();

		try {
			this.salida.write(mensaje.getBytes());
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}

}
