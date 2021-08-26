package sirius.tinkoff.demo.myspringboot.mailing;

import lombok.extern.slf4j.Slf4j;
import org.apache.cxf.helpers.IOUtils;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.text.MessageFormat;

@Slf4j
public class BodyTestGenerator {

    protected static final String templateHeader;
    protected static final String bodyTemplate;
    private static final String ENCODING = StandardCharsets.UTF_8.name();

    static {
        ClassPathResource headerConfFile = new ClassPathResource("mail_templates/header.template");
        ClassPathResource bodyConfFile = new ClassPathResource("mail_templates/body.template");
        try {
            bodyTemplate = IOUtils.toString(bodyConfFile.getInputStream(), ENCODING);
            templateHeader = IOUtils.toString(headerConfFile.getInputStream(), ENCODING);
        } catch (IOException e) {
            log.error("Error while reading html templates");
            throw new RuntimeException("Unable to get message");
        }
    }

    public String get() {
        String body = MessageFormat.format(bodyTemplate, "Первый аргумент", "Второй аргумент");
        return templateHeader + body;
    }
}