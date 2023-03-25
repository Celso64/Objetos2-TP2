package mains;

import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

import concurso.Concurso;
import concurso.Participante;
import concurso.PlanillaIncriptos;
import concursoAlmacenamiento.EmailPlanillaInscriptos;
import email.EmailTrapEmail;

public class ConcursoApp {

	public static void main(String[] args) {

		try {
			PlanillaIncriptos planilla = new EmailPlanillaInscriptos(
					new EmailTrapEmail("mailtrap@celsotest.com", "mailtrap@celsotest.com"));

			Concurso concurso = new Concurso(Optional.of(1L), 31, planilla);
			Participante participante;

			List<String> nombres = List.of("Carlos", "Sandra", "Martin", "Manuel");
			Long i = 0L;

			for (String string : nombres) {
				participante = new Participante(Optional.of(i), string);
				concurso.sumarParticipante(participante);
				i++;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		Paths.get("/Escritorio/salida.txt");
	}

}
