package concurso;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import email.Email;

public class Concurso {

	private Long id = -1L;
	private LocalDate fechaInicio;
	private Integer plazo;
	private List<Participante> participantes;
	private PlanillaIncriptos salida;
	private Email notificador;

	public Concurso(Integer plazo, PlanillaIncriptos salida, Email servicioNotificacion) {
		this.fechaInicio = LocalDate.now();
		this.plazo = plazo;
		this.participantes = new ArrayList<Participante>();
		this.salida = salida;
		this.notificador = servicioNotificacion;
	}

	public Concurso(Long id, Integer plazo, PlanillaIncriptos salida, Email servicioNotificacion) {
		this(plazo, salida, servicioNotificacion);
		this.id = id;
	}

	public Concurso(LocalDate fecha, Integer plazo, PlanillaIncriptos salida, Email servicioNotificacion) {
		this(plazo, salida, servicioNotificacion);
		this.fechaInicio = fecha;
	}

	public Concurso(Long id, LocalDate fecha, Integer plazo, PlanillaIncriptos salida, Email servicioNotificacion) {
		this(id, plazo, salida, servicioNotificacion);
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

		this.notificador.enviarEmail("Concurso", this.generarMensaje(participante));
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

	private String generarMensaje(Participante participante) {

		StringBuffer mensaje = new StringBuffer("El participante ");

		mensaje.append(participante.getID().toString());
		mensaje.append(" se ha inscrito al concurso nº");
		mensaje.append(this.getID());

		return mensaje.toString();
	}

}
