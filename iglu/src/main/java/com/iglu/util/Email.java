package com.iglu.util;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;



public class Email {
	String origen;
	String passwd;
	String filePath = "";
	String fileName = "";
	String destino;
	String asunto;
	String mensaje;
	int intentos = 0;

	/**
	 * @param origen
	 * @param passwd
	 * @param filePath
	 * @param fileName
	 * @param destino
	 * @param asunto
	 * @param mensaje
	 */
	public Email(String origen, String passwd, String filePath,
			String fileName, String destino, String asunto, String mensaje) {
		this.origen = origen;
		this.passwd = passwd;
		this.filePath = filePath;
		this.fileName = fileName;
		this.destino = destino;
		this.asunto = asunto;
		this.mensaje = mensaje;
	}

	/**
	 * @param origen
	 * @param passwd
	 * @param destino
	 * @param asunto
	 * @param mensaje
	 */
	public Email(String origen, String passwd, String destino, String asunto,
			String mensaje) {
		this.origen = origen;
		this.passwd = passwd;
		this.destino = destino;
		this.asunto = asunto;
		this.mensaje = mensaje;
	}

	public Session sessionSSL() {
		Properties props = new Properties();
//		props.setProperty("mail.smtp.host", "smtp.live.com");
//		props.setProperty("mail.smtp.socketFactory.port", "587");
//		props.setProperty("mail.smtp.socketFactory.class",
//				"javax.net.ssl.SSLSocketFactory");
//		props.setProperty("mail.smtp.auth", "true");
//		props.setProperty("mail.smtp.port", "587");
		
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.live.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getDefaultInstance(props,
				new javax.mail.Authenticator() {
					@Override
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(origen, passwd);
					}
				});
		return session;

	}

	public void sessionTLS() {

	}

	public void sendMail()   {
		
		BodyPart cuerpo = new MimeBodyPart();
		BodyPart adjunto = new MimeBodyPart();
		Multipart multiParte = new MimeMultipart();
		MimeMessage message = new MimeMessage(sessionSSL());
		mensaje += "<br/><br/>NOTA:<br/>ESTE MENSAJE SE GENERA DE MANERA AUTOMÁTICA\nFAVOR NO RESPONDER - GRACIAS";
		
			
			try {
				cuerpo.setContent(mensaje,"text/html");
			
			if (!filePath.equals("")) {
				adjunto.setDataHandler(new DataHandler(new FileDataSource(
						filePath)));
				adjunto.setFileName(fileName);
				multiParte.addBodyPart(adjunto);
			}
			multiParte.addBodyPart(cuerpo);
			

			message.setFrom(new InternetAddress(origen));
			message.addRecipients(Message.RecipientType.TO,
					InternetAddress.parse(destino));
			message.setSubject(asunto);
			message.setContent(multiParte);
			Transport.send(message);
			System.out.println("OK..OK..OK");
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	
	}
}
