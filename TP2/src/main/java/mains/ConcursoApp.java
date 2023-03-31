package mains;

import java.util.List;

import baseDeDatos.BDConnectionManager;
import baseDeDatos.MySqlConcursoDAO;
import concurso.Concurso;
import concurso.Participante;
import concurso.PlanillaIncriptos;
import concursoAlmacenamiento.MySqlPlanillaIncriptos;
import notificacion.EmailManager;
import notificacion.EmailTrapEmail;

public class ConcursoApp {

	public static void main(String[] args) {

		try {
			PlanillaIncriptos planilla = new MySqlPlanillaIncriptos(
					new MySqlConcursoDAO(BDConnectionManager.getProperties("database")));

			Concurso concurso = new Concurso(1L, 31, planilla, new EmailTrapEmail(EmailManager.getProperties("email"),
					"mailtrap@celsotest.com", "mailtrap@celsotest.com"));
			Participante participante;

			List<String> nombres = List.of("Carlos");
			Long i = 0L;

			for (String string : nombres) {
				participante = new Participante(i, string);
				concurso.sumarParticipante(participante);
				i++;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
