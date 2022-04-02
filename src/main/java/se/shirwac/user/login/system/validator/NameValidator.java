package se.shirwac.user.login.system.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NameValidator {

    public boolean validateFullName(String fullName) {
        String reg = "^[a-zA-Z\\s]+$";
        Pattern pattern = Pattern.compile(reg,Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(fullName);
        return matcher.find();
    }
}
