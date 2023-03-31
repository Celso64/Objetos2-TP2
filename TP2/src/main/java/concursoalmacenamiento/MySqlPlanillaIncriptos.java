package concursoalmacenamiento;

import java.time.LocalDate;

import basededatos.ConcursoDAO;
import concurso.PlanillaIncriptos;

public class MySqlPlanillaIncriptos implements PlanillaIncriptos {

	private ConcursoDAO concursoBD;

	public MySqlPlanillaIncriptos(ConcursoDAO concursoDAO) {
		this.concursoBD = concursoDAO;
	}

	@Override
	public void incribirParticipante(LocalDate fecha, Long idParticipante, Long idConcurso) {
		this.concursoBD.create(fecha, idConcurso, idParticipante);
	}

}
