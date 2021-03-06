package pl.coderslab.util;


import com.itextpdf.text.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import pl.coderslab.model.User;
import pl.coderslab.service.UserService;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.IOException;
import java.util.Properties;

public class Mailer {

    public static void send(String recipientAddress, String userName, String subject, String message,
                            boolean withAttachment) {

        //Get properties object
        Properties props = new Properties();
        props.put("mail.smtp.auth", true);
        props.put("mail.smtp.starttls.enable", true);
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        //read email account details stored in external file on server

        String from = FileRead.getData()[0];
        String pass = FileRead.getData()[1];


        //get Session
        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(from, pass);
                    }
                });

        //compose message
        try {
            Message msg = new MimeMessage(session);

            msg.setFrom(new InternetAddress(from));
            msg.setRecipient(Message.RecipientType.TO, new InternetAddress(recipientAddress));
            msg.setSubject(subject);

            Multipart multipart = new MimeMultipart();

            MimeBodyPart textBodyPart = new MimeBodyPart();
            textBodyPart.setText(message);
            multipart.addBodyPart(textBodyPart);  // add the text part

            if(withAttachment) {
                MimeBodyPart attachmentBodyPart = new MimeBodyPart();
                DataSource source = new FileDataSource("/usr/local/bin/grupaplus/output.pdf");
                attachmentBodyPart.setDataHandler(new DataHandler(source));
                attachmentBodyPart.setFileName(userName + ".pdf");
                multipart.addBodyPart(attachmentBodyPart); // add the attachement part*/
            }

            msg.setContent(multipart);
            Transport.send(msg);

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }

    }

}
