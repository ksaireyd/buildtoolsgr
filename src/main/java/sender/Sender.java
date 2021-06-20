package sender;


import com.sun.mail.smtp.SMTPTransport;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.Date;
        import java.util.Properties;

public class Sender {

    // for example, smtp.mailgun.org
    private static final String SMTP_SERVER = "smtp.gmail.com";
    private static final String USERNAME = "test2.1.2.2.w@gmail.com";
    private static final String PASSWORD = "qwertyip1";

    private static final String EMAIL_FROM = "From@gmail.com";
    private static final String EMAIL_TO = "tesqi12s1d@gmail.com";


    private static final String EMAIL_SUBJECT = "Report file";
    private static final String EMAIL_TEXT = "this is test report";

    public static void sendletter()
    {


        Properties prop = System.getProperties();
        prop.put("mail.smtp.host", SMTP_SERVER);
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.port", "25");
        prop.put("mail.smtp.starttls.enable","true");
        Session session = Session.getInstance(prop, null);
        Message msg = new MimeMessage(session);

        try {

            // from
            msg.setFrom(new InternetAddress(EMAIL_FROM));

            // to
            msg.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(EMAIL_TO, false));


            // subject
            msg.setSubject(EMAIL_SUBJECT);

            // content
            msg.setText(EMAIL_TEXT);

            msg.setSentDate(new Date());

            BodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setText("report for tests");
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart);
            messageBodyPart = new MimeBodyPart();
            String filename = "build/reports/tests/test/index.html";
            DataSource source = new FileDataSource(filename);
            messageBodyPart.setDataHandler(new DataHandler(source));
            messageBodyPart.setFileName(filename);
            multipart.addBodyPart(messageBodyPart);

            msg.setContent(multipart);
            // Get SMTPTransport
            SMTPTransport t = (SMTPTransport) session.getTransport("smtp");

            // connect
            t.connect(SMTP_SERVER, USERNAME, PASSWORD);

            // send
            t.sendMessage(msg, msg.getAllRecipients());

            System.out.println("Response: " + t.getLastServerResponse());

            t.close();

        } catch (MessagingException e) {
            e.printStackTrace();
        }

    }
}