package se.shirwac.user.login.system.email;

import org.springframework.stereotype.Service;

import java.util.function.Predicate;

@Service
public class EmailValidator implements Predicate<String> {


    @Override
    public boolean test(String email) {
        email.toLowerCase();
        int containsAt = 0;
        int containsDot = 0;


        for (int i = 0; i < email.length(); i++) {
            if (email.charAt(i) == '@') {
                containsAt++;
            }
        }
        if (containsAt > 1) {
            return false;
        }
        String[] splitEmail = email.split("@");
        for (int i = 0; i < splitEmail[1].length(); i++) {
            if (splitEmail[1].charAt(i) == '.') {
                containsDot++;
            }
        }
        if (containsDot > 1) {
            return false;
        }
        else return true;
    }}
