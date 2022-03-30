package se.shirwac.user.login.system.password;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordValidator {

    boolean validatePassword(String password){
        String reg = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d\\w\\W]{8,}$";
        Pattern pattern = Pattern.compile(reg,Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(password);
        return matcher.find();
    }

}
