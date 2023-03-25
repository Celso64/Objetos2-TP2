package baseDeDatos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

public class MySqlTicketDAO implements TicketDAO {

	private String createTicket = "INSERT INTO ticket(fecha, monto) VALUES (?,?)";

	// private static Properties prop = ConnectionManager.getProperties();

	// prop.getProperty("connection"), prop.getProperty("username"),
	// prop.getProperty("password")

	@Override
	public void create(LocalDate fecha, Double monto) {

		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/facturacion?useSSL=false",
				"root", "12345678"); PreparedStatement createT = conn.prepareStatement(createTicket);) {

			createT.setDate(1, Date.valueOf(fecha));
			createT.setDouble(2, monto);

			int res = createT.executeUpdate();
			if (res == 0)
				throw new RuntimeException("No se pudo agregar a la BD");

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
