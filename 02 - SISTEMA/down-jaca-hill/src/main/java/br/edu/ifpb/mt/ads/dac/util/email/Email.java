package br.edu.ifpb.mt.ads.dac.util.email;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Email {

	private static final String EMAIL = "projeto.ads.p2@gmail.com";

	private static final String SENHA_DO_EMAIL = "projetoP2";

	private static Properties props = new Properties();

	private static Session session;

	static {
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");

		session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(EMAIL, SENHA_DO_EMAIL);
			}
		});
	}

	public static void enviar(String assunto, String mensagem, String... destinatarios) {
		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(SENHA_DO_EMAIL));

			Address[] toUser = InternetAddress.parse(String.join(", ", destinatarios));

			message.setRecipients(Message.RecipientType.TO, toUser);
			message.setSubject(assunto);
			message.setText(mensagem);

			Transport.send(message);

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
}
