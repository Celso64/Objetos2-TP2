package concursoAlmacenamiento;

import java.io.OutputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import concurso.Concurso;
import concurso.Participante;
import concurso.PlanillaIncriptos;

public class ArchivoPlanillaInscriptos implements PlanillaIncriptos {

	private OutputStream salida;
	private DateTimeFormatter formato;

	public ArchivoPlanillaInscriptos(OutputStream salida) {
		this.salida = salida;
	}

	public ArchivoPlanillaInscriptos(OutputStream salida, DateTimeFormatter formatoFecha) {
		this(salida);
		this.formato = formatoFecha;
	}

	public void incribirParticipante(LocalDate fecha, Participante participante, Concurso concurso) {

		String fechaString = (this.formato == null) ? fecha.toString() : fecha.format(formato).toString();

		StringBuffer stringBuffer = new StringBuffer(fechaString);
		stringBuffer.append(", ").append(participante.getID().toString()).append(", ")
				.append(concurso.getID().toString()).append("\n");

		String mensaje = stringBuffer.toString();

		try {
			this.salida.write(mensaje.getBytes());
		} catch (Exception e) {

		}
	}

}
