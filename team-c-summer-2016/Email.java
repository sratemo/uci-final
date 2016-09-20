package teamc;

import javax.mail.Session;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class Email {

    public static void sendEmail(Defect defect) {

        //Establish properties for sending email, this will send email coming from johncrisantotest@gmail.com to assignee
        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.user", "johncrisantotest@gmail.com");
        properties.put("mail.smtp.password", "IAmTesting123");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.port", "25");

        //Create authentication object with username and password for email above
        Authenticator authenticator = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("johncrisantotest@gmail.com", "IAmTesting123");
            }
        };

        //Create a session using the properties established and the authenticator username and password
        Session session = Session.getDefaultInstance(properties, authenticator);

        //Create message and send message to assignee
        Message message = new MimeMessage(session);

        try {
            message.setSubject("Status Information for Defect " + defect.getDefectName() + ": " + defect.getSummary().toUpperCase());
            message.setText("Your ticket has been successfully created or updated.\n" + "\nDefect Ticket Information: \n"
                    + "\nApplication name: " + defect.getapplication() + "\n"
                    + "Assignee: " + defect.getAssignee() + "\n"
                    + "Defect Name: " + defect.getDefectName() + "\n"
                    + "Description: " + defect.getDescription() + "\n"
                    + "Priority: " + defect.getPriority() + "\n"
                    + "Status: " + defect.getStatus() + "\n"
                    + "Summary: " + defect.getSummary() + "\n");

            message.setFrom(new InternetAddress("johncrisantotest@gmail.com"));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(defect.getAssignee()));

            Transport.send(message);

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
