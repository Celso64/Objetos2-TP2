package fakeobjects;

import java.time.LocalDate;

import concurso.PlanillaIncriptos;

public class FakePlanillaInscriptos implements PlanillaIncriptos {

	private Boolean ultimoUsofueCorrecto;

	@Override
	public void incribirParticipante(LocalDate fecha, Long idParticipante, Long idConcurso) {

		this.ultimoUsofueCorrecto = true;

	}

	public Boolean getUltimoUsofueCorrecto() {
		return ultimoUsofueCorrecto;
	}

	public void resetUltimoUso() {
		this.ultimoUsofueCorrecto = false;
	}

}
