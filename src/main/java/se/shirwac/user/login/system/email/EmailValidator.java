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
        String[] splitEmailByAt = email.split("@");
        String domainName = splitEmailByAt[1];
        String[] splitDomainName = domainName.split("\\.");
        for (int i = 0; i < splitEmailByAt[1].length(); i++) {
            if (splitEmailByAt[1].charAt(i) == '.') {
                containsDot++;
            }
        }

        if (containsDot > 1) {
            return false;
        }

        if(splitDomainName[1].length() > 3){
            return false;
        }
        else return true;
    }}
