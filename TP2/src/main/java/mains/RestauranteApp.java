package mains;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.time.format.DateTimeFormatter;

import restaurante.Comida;
import restaurante.Cuenta;
import restaurante.Tarjeta;
import restaurante.Viedma;
import restauranteAlmacenamiento.ArchivoTicket;

public class RestauranteApp {

	public static void main(String[] args) {

		try {
			Cuenta cuenta = new Cuenta(
					new ArchivoTicket(new FileOutputStream(new File("/home/carlos/Desktop/cuenta.txt"), true),
							DateTimeFormatter.ofPattern("dd/MM/yyyy")));

			Tarjeta tarjeta = new Viedma();
			Comida comida = new Comida(25.5);

			cuenta.addProducto(comida);
			tarjeta.pagarCuenta(cuenta, Cuenta.PROPINA_ALTA);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

}
