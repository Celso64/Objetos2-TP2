package persistencia;

import java.io.OutputStream;

public class ArchivoPersistencia implements Persistencia {
	
	private OutputStream salida;
	
	public ArchivoPersistencia(OutputStream salida) {
		super();
		this.salida = salida;
	}



	public void guardar(String mensaje) {
		
			try {
				this.salida.write(mensaje.getBytes());
			} catch (Exception e) {
				
			}

	}

}
