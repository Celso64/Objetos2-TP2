package concurso;

import java.io.OutputStream;

import persistencia.Persistencia;

public class ArchivoPlanillaInscriptos implements PlanillaIncriptos {

	private OutputStream salida;

	public void incribirParticipante(Persistencia destino, String mensaje, OutputStream salida) {
		try {
			this.salida.write(mensaje.getBytes());
		} catch (Exception e) {

		}
	}

}
