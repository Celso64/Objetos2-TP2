package fakeObjects;

import java.time.LocalDate;
import java.util.List;

import concurso.Concurso;
import concurso.Participante;
import concurso.PlanillaIncriptos;

public class FakePlanillaInscriptos implements PlanillaIncriptos {

	private Boolean ultimoUsofueCorrecto;

	@Override
	public void incribirParticipante(LocalDate fecha, Participante participante, Concurso concurso) {

		StringBuffer mensaje = new StringBuffer(64);

		List<String> partesDelMensaje = List.of("Participante ", participante.getID().toString(), " se inscribio el ",
				fecha.toString(), " al concurso nº", concurso.getID().toString());

		partesDelMensaje.forEach(mensaje::append);
		this.ultimoUsofueCorrecto = true;

	}

	public Boolean getUltimoUsofueCorrecto() {
		return ultimoUsofueCorrecto;
	}

	public void resetUltimoUso() {
		this.ultimoUsofueCorrecto = false;
	}

}
