package concurso;

import java.io.OutputStream;

import persistencia.Persistencia;

public interface PlanillaIncriptos {
	
	void incribirParticipante(Persistencia destino, String mensaje, OutputStream salida);

}
