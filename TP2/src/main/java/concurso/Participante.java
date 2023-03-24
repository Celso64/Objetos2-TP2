package concurso;

import java.util.Objects;

public class Participante {

	private String nombre;
	private Integer puntos;

	public Participante(String nombre) {
		this.nombre = nombre;
		this.puntos = 0;
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

}
