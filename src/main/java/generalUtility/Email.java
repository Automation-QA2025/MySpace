package generalUtility;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;

public class Email {

    public void sendMailWithAttachment(String path) throws IOException, AddressException {
        Instant now = Instant.now();
        Instant yesterday = now.minus(1, ChronoUnit.DAYS);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate yesterdayDate = yesterday.atZone(ZoneId.systemDefault()).toLocalDate();
        String yesterdayDateWithoutTime = yesterdayDate.format(formatter);
        System.out.println("Date: " + yesterdayDateWithoutTime);

       
        File dailyReportFile = new File(path);
        String dailyReport = dailyReportFile.getAbsolutePath();

        String email = "murali@neokred.tech";
        String passwordMail = "NKtech@123";

        String to = "murali@neokred.tech";
        String from = email;
        String host = "smtp.office365.com";
        String port = "587";
        final String username = email;
        final String password = "NKtech@123";

//        Address ccAddress1 = new InternetAddress("richard@neokred.tech");
//        Address ccAddress2 = new InternetAddress("murali@neokred.tech");

        Properties props = new Properties();
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", port);
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.ssl.protocols", "TLSv1.2");
        props.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
//            message.addRecipient(Message.RecipientType.CC, ccAddress1);
//            message.addRecipient(Message.RecipientType.CC, ccAddress2);
            message.setSubject("Automation Execution Report");

            // Create message part with HTML content
            MimeBodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setContent("<html><body>Hi Team,<br><br>"
                    + "Today Automation Script Execution Report. Please check it.<br><br>"
                    + "Thank You</body></html>", "text/html; charset=utf-8");

            // Create attachment part
            MimeBodyPart attachmentPart = new MimeBodyPart();
            DataSource source = new FileDataSource(dailyReport);
            attachmentPart.setDataHandler(new DataHandler(source));
            attachmentPart.setFileName("Test_Execution_Report.html");

            // Combine parts
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart);
            multipart.addBodyPart(attachmentPart);

            // Set content and send email
            message.setContent(multipart);
            Transport.send(message);
            System.out.println("Email sent successfully!");
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}