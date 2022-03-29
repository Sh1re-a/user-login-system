package se.shirwac.user.login.system.email;

public interface EmailSender {
    void send(String to, String email);
}