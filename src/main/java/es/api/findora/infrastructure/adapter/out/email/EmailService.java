package es.api.findora.infrastructure.adapter.out.email;

import es.api.findora.domain.port.out.EmailSender;
import lombok.AllArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmailService implements EmailSender {
    private final JavaMailSender mailSender;

    @Override
    public void sendVerificationEmail(String to, String link) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setFrom("no-reply@findora.com");
        message.setSubject("Verifica tu cuenta - Findora");
        message.setText(
                "Hola!\n\n" +
                        "Gracias por registrarte en Findora.\n" +
                        "Para activar tu cuenta, haz clic en el siguiente enlace:\n\n" +
                        link + "\n\n" +
                        "Si no solicitaste esta cuenta, ignora este mensaje."
        );

        mailSender.send(message);
    }
}
