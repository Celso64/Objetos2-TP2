package notificacion;

import java.util.Properties;
import java.util.ResourceBundle;

public abstract class EmailManager {

	public static Properties getProperties(String nombreProperties) {
		Properties prop = new Properties();

		try {
			ResourceBundle infoDataBase = ResourceBundle.getBundle(nombreProperties);
			prop.setProperty("host", infoDataBase.getString("email.host"));
			prop.setProperty("port", infoDataBase.getString("email.port"));
			prop.setProperty("username", infoDataBase.getString("email.user"));
			prop.setProperty("password", infoDataBase.getString("email.password"));

		} catch (Exception e1) {
			System.out.println(e1);
			throw new RuntimeException("Ocurrio un error al leer la configuraci�n desde el archivo");
		}
		return prop;

	}

}
