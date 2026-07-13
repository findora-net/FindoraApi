package es.api.findora.domain.port.out;

public interface EmailSender {
    void sendVerificationEmail(String to, String link);
}
