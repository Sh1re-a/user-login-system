package se.shirwac.user.login.system.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public boolean validateFullName(String fullName) {
        String reg = "^[a-zA-Z\\s]+$";
        Pattern pattern = Pattern.compile(reg,Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(fullName);
        return matcher.find();
    }

        public String signUpUser(User user){
        boolean userExists = userRepo.findByEmail(user.getEmail()).isPresent();
        if(userExists){
            throw new IllegalStateException("email already exits");
        }


    return null;

    }


}
