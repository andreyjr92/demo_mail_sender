package sirius.tinkoff.demo.myspringboot.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import sirius.tinkoff.demo.myspringboot.mailing.EmailMessage;

@Service
@RequiredArgsConstructor
public class MailService {

    private final JavaMailSender mailSender;

    @Value("${app.mail.email.primary}")
    private String emailFrom;

    @Async
    public void sendMessage(EmailMessage emailMessage) {
        emailMessage.setMailSender(mailSender);
        emailMessage.setEmailFrom(emailFrom);
        emailMessage.send();
    }
}
