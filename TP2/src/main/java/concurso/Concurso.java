package concurso;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class Concurso {

	private Long id = -1L;
	private LocalDate fechaInicio;
	private Integer plazo;
	private List<Participante> participantes;
	private PlanillaIncriptos salida;
	private Notificador notificador;

	public Concurso(Integer plazo, PlanillaIncriptos salida, Notificador servicioNotificacion) {
		this.participantes = new ArrayList<Participante>();
		this.fechaInicio = LocalDate.now();
		this.plazo = Objects.requireNonNull(plazo);
		this.salida = Objects.requireNonNull(salida);
		this.notificador = Objects.requireNonNull(servicioNotificacion);
	}

	public Concurso(Long id, Integer plazo, PlanillaIncriptos salida, Notificador servicioNotificacion) {
		this(plazo, salida, servicioNotificacion);
		this.id = Objects.requireNonNull(id);
	}

	public Concurso(LocalDate fecha, Integer plazo, PlanillaIncriptos salida, Notificador servicioNotificacion) {
		this(plazo, salida, servicioNotificacion);
		this.fechaInicio = Objects.requireNonNull(fecha);
	}

	public Concurso(Long id, LocalDate fecha, Integer plazo, PlanillaIncriptos salida,
			Notificador servicioNotificacion) {
		this(id, plazo, salida, servicioNotificacion);
		this.fechaInicio = Objects.requireNonNull(fecha);
	}

	public void sumarParticipante(Participante participante) {
		LocalDate hoy = LocalDate.now();
		if (hoy.isAfter(fechaInicio.plusDays(this.plazo))) {
			throw new RuntimeException("Plazo Vencido");
		}
		if (hoy.isEqual(fechaInicio)) {
			participante.sumarPuntos(10);
		}
		this.participantes.add(participante);

		this.salida.incribirParticipante(LocalDate.now(), participante.getID(), this.getID());
		this.notificador.enviarEmail("Concurso", this.generarMensaje(participante));

	}

	public Integer getPuntosParticipante(String nombre) {

		Optional<Participante> existeParticipante = this.participantes.stream()
				.filter(x -> x.equals(new Participante(nombre))).findFirst();

		return existeParticipante.orElse(new Participante("")).getPuntos();
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
