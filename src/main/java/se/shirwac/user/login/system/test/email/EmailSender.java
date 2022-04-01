package se.shirwac.user.login.system.test.email;

public interface EmailSender {
    void send(String to, String email);
}