package se.shirwac.user.login.system.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import se.shirwac.user.login.system.registration.token.ConfirmationToken;
import se.shirwac.user.login.system.registration.token.ConfirmationTokenRepo;
import se.shirwac.user.login.system.registration.token.ConfirmationTokenService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;


@Service
public class UserService implements UserDetailsService {

    private final static String userNotFound = "user with email %s not found";
    private final UserRepo userRepo;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final ConfirmationTokenService confirmationTokenService;


    public UserService(UserRepo userRepo, BCryptPasswordEncoder bCryptPasswordEncoder, ConfirmationTokenService confirmationTokenService) {
        this.userRepo = userRepo;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.confirmationTokenService = confirmationTokenService;
    }

    public String signUpUser(User user){
        boolean userExists = userRepo.findByEmail(user.getEmail()).isPresent();
        if(userExists){
            throw new IllegalStateException("email already exits");
        }
        String encodedPassword = bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        userRepo.save(user);

        String token = UUID.randomUUID().toString();

        ConfirmationToken confirmationToken = new ConfirmationToken(
                token,
                LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(15),
                user);

        confirmationTokenService.saveConfirmationToken(confirmationToken);
        return token;
        }

        public int enableUser(String email){
        return userRepo.enableAppUser(email);
        }


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return (UserDetails) userRepo.findByEmail(email).orElseThrow(()->
        new UsernameNotFoundException(String.format(userNotFound, email)));
    }
}
