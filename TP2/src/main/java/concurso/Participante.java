package concurso;

import java.util.Objects;
import java.util.Optional;

public class Participante {

	private Long id;
	private String nombre;
	private Integer puntos;

	private static Long idPorDefecto = -1L;

	public Participante(Optional<Long> id, String nombre) {
		this.puntos = 0;
		this.nombre = nombre;
		this.id = id.orElse(idPorDefecto);
	}

	void sumarPuntos(Integer puntos) {
		this.puntos += puntos;
	}

	public Integer getPuntos() {
		return this.puntos;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Participante other = (Participante) obj;
		return Objects.equals(nombre, other.nombre);
	}

	@Override
	public String toString() {
		return id.toString();
	}

	public Long getID() {
		return this.id;
	}

}
