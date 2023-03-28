package email;

import java.util.Properties;

import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

public class EmailTrapEmail implements Email {

	private String correoOrigen;
	private String correoDestino;
	private Properties props;
	private Session session;

	public EmailTrapEmail(String correoOrigen, String correoDestino) {
		super();
		this.correoOrigen = correoOrigen;
		this.correoDestino = correoDestino;
		this.props = EmailManager.getProperties();
	}

	@Override
	public void enviarEmail(String asunto, String mensaje) {

		String to = this.correoDestino;
		// provide sender's email ID
		String from = this.correoOrigen;
		// provide Mailtrap's username
		final String username = props.getProperty("username");
		// provide Mailtrap's password
		final String password = props.getProperty("password");
		// provide Mailtrap's host address
		String host = props.getProperty("host");
		// configure Mailtrap's SMTP server details
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", props.getProperty("port"));

		session = Session.getInstance(props, new jakarta.mail.Authenticator() {
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
			System.out.println("Email enviado");
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}

}
