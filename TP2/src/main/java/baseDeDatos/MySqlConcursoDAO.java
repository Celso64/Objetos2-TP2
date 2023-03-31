package baseDeDatos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Properties;

public class MySqlConcursoDAO implements ConcursoDAO {

	private String createConcurso = "INSERT INTO concurso(id_concurso, id_participante, fecha_inscripcion) VALUES (?,?,?)";

	private Properties propiedades;

	public MySqlConcursoDAO(Properties propiedades) {
		this.propiedades = Objects.requireNonNull(propiedades);
	}

	@Override
	public void create(LocalDate fecha, Long idConcurso, Long idParticipante) {

		try (Connection conn = DriverManager.getConnection(propiedades.getProperty("connection"),
				propiedades.getProperty("username"), propiedades.getProperty("password"));
				PreparedStatement createC = conn.prepareStatement(createConcurso);) {

			createC.setLong(1, idConcurso);
			createC.setLong(2, idParticipante);
			createC.setDate(3, Date.valueOf(fecha));

			int res = createC.executeUpdate();
			if (res == 0)
				throw new RuntimeException("No se pudo agregar a la BD");

		} catch (SQLException e) {
			throw new RuntimeException("Error en la BD - " + e.getMessage());
		}

	}

}
