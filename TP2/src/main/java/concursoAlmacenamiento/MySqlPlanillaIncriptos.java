package concursoAlmacenamiento;

import java.time.LocalDate;

import baseDeDatos.ConcursoDAO;
import concurso.Concurso;
import concurso.Participante;
import concurso.PlanillaIncriptos;

public class MySqlPlanillaIncriptos implements PlanillaIncriptos {

	private ConcursoDAO concursoBD;

	public MySqlPlanillaIncriptos(ConcursoDAO concursoDAO) {
		this.concursoBD = concursoDAO;
	}

	@Override
	public void incribirParticipante(LocalDate fecha, Participante participante, Concurso concurso) {

		this.concursoBD.create(fecha, concurso.getID(), participante.getID());

	}

}
