package se.shirwac.user.login.system.registration.token;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class ConfirmationTokenService {

    public ConfirmationTokenService(ConfirmationTokenRepo confirmationTokenRepository) {
        this.confirmationTokenRepository = confirmationTokenRepository;
    }

    private final ConfirmationTokenRepo confirmationTokenRepository;

    public void saveConfirmationToken(ConfirmationToken token){
        confirmationTokenRepository.save(token);
    }
    public Optional<ConfirmationToken> getToken(String token) {
        return confirmationTokenRepository.findByToken(token);
    }

     public int setConfirmedAt(String token) {
        return confirmationTokenRepository.updateConfirmedAt(
                token, LocalDateTime.now());
    }


}
