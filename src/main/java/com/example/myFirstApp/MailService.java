package com.example.myFirstApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
// import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import java.io.File;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class MailService {
    @Autowired
    private JavaMailSender mailSender;
    public void sendEmailWithAttachment(String to, String subject, String body, String attachmentPath) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true); // 'true' enables multipart for attachments

        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(body);

        // Attach the file
        FileSystemResource file = new FileSystemResource(new File(attachmentPath));
        if (file.exists()) {
            helper.addAttachment(file.getFilename(), file);
        } else {
            throw new MessagingException("Attachment file not found: " + attachmentPath);
        }

        mailSender.send(message);
    }
}
