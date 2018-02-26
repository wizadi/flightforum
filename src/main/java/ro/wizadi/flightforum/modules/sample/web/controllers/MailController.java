package ro.wizadi.flightforum.modules.sample.web.controllers;

import org.springframework.mail.MailSendException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ro.wizadi.flightforum.modules.sample.web.forms.EmailForm;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Controller
@RequestMapping("mail")
public class MailController {

    private JavaMailSender mailSender;

    public MailController(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @PostMapping("sendTest")
    @ResponseBody
    public String sendTestMessage(@RequestBody EmailForm form) {

        try {
            MimeMessage message = mailSender.createMimeMessage();

            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            helper.setTo(form.getEmail());
            helper.setSubject(form.getSubject());
            helper.setText(form.getText());

            /*
            FileSystemResource file
                    = new FileSystemResource(new File(pathToAttachment));
            helper.addAttachment("Invoice", file);
            */

            mailSender.send(message);
        } catch (MailSendException ex) {
            return "Error when sending: " + ex.getMessage();
        } catch (MessagingException e) {
            e.printStackTrace();
        }

        return "Message Sent";
    }

}
