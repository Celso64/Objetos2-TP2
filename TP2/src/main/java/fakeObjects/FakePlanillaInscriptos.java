package fakeObjects;

import java.time.LocalDate;

import concurso.Concurso;
import concurso.Participante;
import concurso.PlanillaIncriptos;

public class FakePlanillaInscriptos implements PlanillaIncriptos {

	@Override
	public void incribirParticipante(LocalDate fecha, Participante participante, Concurso concurso) {

		System.out.println("Participante " + participante.getID() + " se inscribio el " + fecha.toString()
				+ " al concurso nº" + concurso.getID());

	}

}
