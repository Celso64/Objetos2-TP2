package concurso;

import java.util.Objects;

public class Participante {

	private Long id = -1L;
	private String nombre;
	private Integer puntos;

	public Participante(String nombre) {
		this.puntos = 0;
		this.nombre = Objects.requireNonNull(nombre);
	}

	public Participante(Long id, String nombre) {
		this(nombre);
		this.id = Objects.requireNonNull(id);
	}

	void sumarPuntos(Integer puntos) {
		this.puntos += puntos;
	}

	Integer getPuntos() {
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
		return nombre.toString();
	}

	public Long getID() {
		return this.id;
	}

}
