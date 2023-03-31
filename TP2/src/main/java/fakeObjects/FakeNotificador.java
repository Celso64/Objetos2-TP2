package fakeObjects;

import notificacion.Notificador;

public class FakeNotificador implements Notificador {

	private Boolean ultimoUsofueCorrecto;

	@Override
	public void enviarEmail(String asunto, String mensaje) {

		this.ultimoUsofueCorrecto = true;

	}

	public Boolean getUltimoUsofueCorrecto() {
		return ultimoUsofueCorrecto;
	}

	public void resetUltimoUso() {
		this.ultimoUsofueCorrecto = false;
	}

}
