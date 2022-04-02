package se.shirwac.user.login.system.registration.email;

public interface EmailSender {
    void send(String to, String email);
}