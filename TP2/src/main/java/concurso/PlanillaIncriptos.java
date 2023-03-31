package concurso;

import java.time.LocalDate;

public interface PlanillaIncriptos {

	void incribirParticipante(LocalDate fecha, Long idParticipante, Long idConcurso);

}
