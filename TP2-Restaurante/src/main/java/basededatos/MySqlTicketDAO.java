package basededatos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Properties;

public class MySqlTicketDAO implements TicketDAO {

	private String createTicket = "INSERT INTO ticket(fecha, monto) VALUES (?,?)";

	private Properties prop;

	public MySqlTicketDAO(Properties propiedades) {
		this.prop = Objects.requireNonNull(propiedades);
	}

	@Override
	public void create(LocalDate fecha, Double monto) {

		try (Connection conn = DriverManager.getConnection(prop.getProperty("connection"), prop.getProperty("username"),
				prop.getProperty("password")); PreparedStatement createT = conn.prepareStatement(createTicket);) {

			createT.setDate(1, Date.valueOf(fecha));
			createT.setDouble(2, monto);

			int res = createT.executeUpdate();
			if (res == 0)
				throw new RuntimeException("No se pudo agregar a la BD");

		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		}

	}

}
