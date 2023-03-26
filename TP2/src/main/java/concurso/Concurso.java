package concurso;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Concurso {

	private Long id = -1L;
	private LocalDate fechaInicio;
	private Integer plazo;
	private List<Participante> participantes;
	private PlanillaIncriptos salida;

	public Concurso(Integer plazo, PlanillaIncriptos salida) {
		this.fechaInicio = LocalDate.now();
		this.plazo = plazo;
		this.participantes = new ArrayList<Participante>();
		this.salida = salida;
	}

	public Concurso(Long id, Integer plazo, PlanillaIncriptos salida) {
		this(plazo, salida);
		this.id = id;
	}

	public Concurso(LocalDate fecha, Integer plazo, PlanillaIncriptos salida) {
		this(plazo, salida);
		this.fechaInicio = fecha;
	}

	public Concurso(Long id, LocalDate fecha, Integer plazo, PlanillaIncriptos salida) {
		this(id, plazo, salida);
		this.fechaInicio = fecha;
	}

	public void sumarParticipante(Participante participante) {
		LocalDate hoy = LocalDate.now();
		if (hoy.isAfter(fechaInicio.plusDays(this.plazo))) {
			throw new RuntimeException("Plazo Vencido");
		}
		if (hoy.isEqual(fechaInicio)) {
			participante.sumarPuntos(10);
		}
		this.salida.incribirParticipante(LocalDate.now(), participante, this);
		this.participantes.add(participante);
	}

	public Integer getPuntosParticipante(String nombre) {
		for (Participante p : this.participantes) {
			if (p.equals(new Participante(null, nombre))) {
				return p.getPuntos();
			}
		}
		return 0;
	}

	public Long getID() {
		return this.id;
	}

}
