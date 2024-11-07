package helpers;

import java.io.File;
import java.util.List;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;
import javax.mail.internet.MimeMultipart;

public class MailHelpers {

	private static Session configServer() {
		Properties properties = new Properties();
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.ssl.protocols", "TLSv1.2");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "587");
		Session session = Session.getDefaultInstance(properties, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("huyminh1593572846@gmail.com", "ggpi zdtj iett ccbj");
			}
		});
		return session;
	}

	public static boolean send(String from, String to, String subject, String body) {
		try {
			Message message = new MimeMessage(configServer());
			message.setFrom(new InternetAddress(from));
			message.setRecipient(RecipientType.TO, new InternetAddress(to));
			message.setSubject(subject);
			message.setContent(body, "text/html");
			Transport.send(message);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} 

	}
	
	// mail with CC, no file
	public static boolean send(String from, String to, String cc, String subject, String body) {
        try {
            Message message = new MimeMessage(configServer());
            message.setFrom(new InternetAddress(from));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
            
            // Add CC recipient(s)
            if (cc != null && !cc.trim().isEmpty()) {
                message.setRecipients(Message.RecipientType.CC, InternetAddress.parse(cc));
            }
            
            message.setSubject(subject);
            message.setContent(body, "text/html"); // Set the HTML content
            Transport.send(message);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

	public static boolean send(String from, String to, String subject, String body, File file) {
		try {
			Message message = new MimeMessage(configServer());
			message.setFrom(new InternetAddress(from));
			message.setRecipient(RecipientType.TO, new InternetAddress(to));
			message.setSubject(subject);

			/* Send body with a file */
			Multipart multipart = new MimeMultipart(); // include 2 part: content and a file
			BodyPart bodyPart = new MimeBodyPart(); // contain mail content

			/* Declare mail content */
			bodyPart.setContent(body, "text/html");
			multipart.addBodyPart(bodyPart);
//			bodyPart.setText(body);
//			multipart.addBodyPart(bodyPart);

			// Declare file is sent in a mail
			MimeBodyPart mimeBodyPart = new MimeBodyPart();
			DataSource dataSource = new FileDataSource(file);
			mimeBodyPart.setDataHandler(new DataHandler(dataSource));
			mimeBodyPart.setFileName(file.getName());
			multipart.addBodyPart(mimeBodyPart);

			message.setContent(multipart); // send multipart object

			Transport.send(message);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} 
	}
		//Send multiple file(Used a for loop)
		public static boolean send(String from, String to, String subject, String body, List<File> files) {
			try {
				Message message = new MimeMessage(configServer());
				message.setFrom(new InternetAddress(from));
				message.setRecipient(RecipientType.TO, new InternetAddress(to));
				message.setSubject(subject);

				/* Send body with a file */
				Multipart multipart = new MimeMultipart(); // include 2 part: content and a file
				BodyPart bodyPart = new MimeBodyPart(); // contain mail content

				/* Declare mail content */
				bodyPart.setText(body);
				multipart.addBodyPart(bodyPart);

				// Declare file is sent in a mail
				for(File file : files) {
					MimeBodyPart mimeBodyPart = new MimeBodyPart();
					DataSource dataSource = new FileDataSource(file);
					mimeBodyPart.setDataHandler(new DataHandler(dataSource));
					mimeBodyPart.setFileName(file.getName());
					multipart.addBodyPart(mimeBodyPart);
				}
				message.setContent(multipart); // send multipart object

				Transport.send(message);
				return true;
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			} 

	}
}
