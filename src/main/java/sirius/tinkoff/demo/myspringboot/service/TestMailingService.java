package sirius.tinkoff.demo.myspringboot.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sirius.tinkoff.demo.myspringboot.mailing.EmailMessage;
import sirius.tinkoff.demo.myspringboot.mailing.BodyTestGenerator;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TestMailingService {

    private final MailService mailService;

    public void testMailing() {
        List<String> to = List.of("spring_smile@mail.ru");
        List<String> copy = Collections.emptyList();
        String subject = "Testing mail";
        String body = new BodyTestGenerator().get();
        EmailMessage emailMessage = new EmailMessage(to, copy, subject, body);
        mailService.sendMessage(emailMessage);
    }
}
