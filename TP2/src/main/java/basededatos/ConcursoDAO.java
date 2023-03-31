package basededatos;

import java.time.LocalDate;

public interface ConcursoDAO {

	void create(LocalDate fecha, Long idConcurso, Long idParticipante);

}
