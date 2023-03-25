package baseDeDatos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

public class MySqlConcursoDAO implements ConcursoDAO {

	private String createConcurso = "INSERT INTO concurso(id_concurso, id_participante, fecha_inscripcion) VALUES (?,?,?)";

	// private static Properties prop = ConnectionManager.getProperties();

	// prop.getProperty("connection"), prop.getProperty("username"),
	// prop.getProperty("password")

	@Override
	public void create(LocalDate fecha, Long idConcurso, Long idParticipante) {

		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Concurso?useSSL=false", "root",
				"12345678"); PreparedStatement createC = conn.prepareStatement(createConcurso);) {

			createC.setLong(1, idConcurso);
			createC.setLong(2, idParticipante);
			createC.setDate(3, Date.valueOf(fecha));

			int res = createC.executeUpdate();
			if (res == 0)
				throw new RuntimeException("No se pudo agregar a la BD");

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
