package notificacion;

import java.util.Objects;
import java.util.Properties;

import concurso.Notificador;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

public class EmailTrapEmail implements Notificador {

	private String correoOrigen;
	private String correoDestino;
	private Properties propiedades;
	private Session session;

	public EmailTrapEmail(Properties propiedades, String correoOrigen, String correoDestino) {
		this.propiedades = Objects.requireNonNull(propiedades);
		this.correoOrigen = Objects.requireNonNull(correoOrigen);
		this.correoDestino = Objects.requireNonNull(correoDestino);
	}

	@Override
	public void enviarEmail(String asunto, String mensaje) {

		String to = this.correoDestino;
		// provide sender's email ID
		String from = this.correoOrigen;
		// provide Mailtrap's username
		final String username = propiedades.getProperty("username");
		// provide Mailtrap's password
		final String password = propiedades.getProperty("password");
		// provide Mailtrap's host address
		String host = propiedades.getProperty("host");
		// configure Mailtrap's SMTP server details
		propiedades.put("mail.smtp.auth", "true");
		propiedades.put("mail.smtp.starttls.enable", "true");
		propiedades.put("mail.smtp.host", host);
		propiedades.put("mail.smtp.port", propiedades.getProperty("port"));

		session = Session.getInstance(propiedades, new jakarta.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {
			// create a MimeMessage object
			Message message = new MimeMessage(session);
			// set From email field
			message.setFrom(new InternetAddress(from));
			// set To email field
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
			// set email subject field
			message.setSubject(asunto);
			// set the content of the email message
			message.setText(mensaje);
			// send the email message
			Transport.send(message);
		} catch (MessagingException e) {
			throw new RuntimeException(e.getMessage());
		}
	}

}
