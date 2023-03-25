package concursoAlmacenamiento;

import java.time.LocalDate;

import concurso.Concurso;
import concurso.Participante;
import concurso.PlanillaIncriptos;
import email.Email;

public class EmailPlanillaInscriptos implements PlanillaIncriptos {

	private Email servicioEmail;

	public EmailPlanillaInscriptos(Email servicioEmail) {
		super();
		this.servicioEmail = servicioEmail;
	}

	@Override
	public void incribirParticipante(LocalDate fecha, Participante participante, Concurso concurso) {

		StringBuffer mensaje = new StringBuffer(participante.toString());

		mensaje.append(" ha sido inscrito en el Concuerso nº").append(concurso.getID().toString())
				.append(", sus puntos actuales son ").append(participante.getPuntos().toString());

		this.servicioEmail.enviarEmail("Inscripcion a Concurso", mensaje.toString());

	}

}
