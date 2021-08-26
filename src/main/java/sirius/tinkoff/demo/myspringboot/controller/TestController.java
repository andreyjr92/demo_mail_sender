package sirius.tinkoff.demo.myspringboot.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sirius.tinkoff.demo.myspringboot.service.MailService;
import sirius.tinkoff.demo.myspringboot.service.TestMailingService;

@RequestMapping("/mail")
@RestController
@RequiredArgsConstructor
public class TestController {

    private final TestMailingService testMailingService;

    @GetMapping
    public void testMailing() {
        testMailingService.testMailing();
    }
}
