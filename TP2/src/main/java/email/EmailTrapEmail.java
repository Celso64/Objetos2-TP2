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
		this.props = new Properties();
	}

	@Override
	public void enviarEmail(String asunto, String mensaje) {

		String to = this.correoDestino;
		// provide sender's email ID
		String from = this.correoOrigen;
		// provide Mailtrap's username
		final String username = "api";
		// provide Mailtrap's password
		final String password = "811234118a808edb68b88f8a2e102e4b";
		// provide Mailtrap's host address
		String host = "live.smtp.mailtrap.io";
		// configure Mailtrap's SMTP server details
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", "587");

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
			System.out.println("Email Message Sent Successfully");
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}

}
