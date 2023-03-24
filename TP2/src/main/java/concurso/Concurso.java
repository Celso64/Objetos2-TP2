package concurso;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import persistencia.Persistencia;

public class Concurso {

	private LocalDate fechaInicio;
	private Integer plazo;
	private List<Participante> participantes;
	private String ruta;
	private PlanillaIncriptos salida;

	public Concurso(Integer plazo, String ruta, PlanillaIncriptos salida) {
		this.fechaInicio = LocalDate.now();
		this.plazo = plazo;
		this.participantes = new ArrayList<Participante>();
		this.ruta = ruta;
		this.salida = salida;
	}

	public Concurso(LocalDate fecha, Integer plazo, String ruta, PlanillaIncriptos salida) {
		this.fechaInicio = fecha;
		this.plazo = plazo;
		this.participantes = new ArrayList<Participante>();
		this.ruta = ruta;
		this.salida = salida;
	}

	public void sumarParticipante(Participante p) {
		LocalDate hoy = LocalDate.now();
		if (hoy.isAfter(fechaInicio.plusDays(this.plazo))) {
			throw new RuntimeException("Plazo Vencido");
		}
		if (hoy.isEqual(fechaInicio)) {
			p.sumarPuntos(10);
		}
		this.participantes.add(p);
	}

	public Integer getPuntosParticipante(String nombre) {
		for (Participante p : this.participantes) {
			if (p.equals(new Participante(nombre))) {
				return p.getPuntos();
			}
		}
		return 0;
	}

}
