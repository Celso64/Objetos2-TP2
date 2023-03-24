package mains;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

import concurso.Concurso;
import concurso.Participante;
import concurso.PlanillaIncriptos;
import concursoAlmacenamiento.ArchivoPlanillaInscriptos;

public class ConcursoApp {

	public static void main(String[] args) {

		try {
			PlanillaIncriptos planilla = new ArchivoPlanillaInscriptos(
					new FileOutputStream(new File("/home/carlos/Desktop/salida.txt"), true));

			Concurso c = new Concurso(Optional.of(1L), 31, planilla);
			Participante p;

			List<String> nombres = List.of("Carlos", "Sandra", "Martin", "Manuel");
			Long i = 0L;

			for (String string : nombres) {
				p = new Participante(Optional.of(i), string);
				c.sumarParticipante(p);
				i++;
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Paths.get("/Escritorio/salida.txt");
	}

}
