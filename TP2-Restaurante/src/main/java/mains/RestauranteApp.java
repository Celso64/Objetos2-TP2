package mains;

import basededatos.ConnectionManager;
import basededatos.MySqlTicketDAO;
import restaurante.Comida;
import restaurante.Cuenta;
import restaurante.Tarjeta;
import restaurante.Viedma;
import restaurantealmacenamiento.BDTicket;

public class RestauranteApp {

	public static void main(String[] args) {

		try {
			Cuenta cuenta = new Cuenta(new BDTicket(new MySqlTicketDAO(ConnectionManager.getProperties("database"))));

			Tarjeta tarjeta = new Viedma();
			Comida comida = new Comida(25.5);

			cuenta.addProducto(comida);
			tarjeta.pagarCuenta(cuenta, Cuenta.PROPINA_ALTA);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
