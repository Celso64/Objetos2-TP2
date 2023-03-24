package concursoAlmacenamiento;

import java.io.OutputStream;

import concurso.PlanillaIncriptos;

public class ArchivoPlanillaInscriptos implements PlanillaIncriptos {

	private OutputStream salida;

	public ArchivoPlanillaInscriptos(OutputStream salida) {
		this.salida = salida;
	}

	public void incribirParticipante(String mensaje) {
		try {
			this.salida.write(mensaje.getBytes());
		} catch (Exception e) {

		}
	}

}
