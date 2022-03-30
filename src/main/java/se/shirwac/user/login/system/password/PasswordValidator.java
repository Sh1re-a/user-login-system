package se.shirwac.user.login.system.password;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordValidator {

    boolean validatePassword(String password){
        String reg = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$";
        Pattern pattern = Pattern.compile(reg,Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(password);
        return matcher.find();
    }

}
