package baseDeDatos;

import java.time.LocalDate;

public interface ConcursoDAO {

	void create(LocalDate fecha, Long idConcurso, Long idParticipante);

}
