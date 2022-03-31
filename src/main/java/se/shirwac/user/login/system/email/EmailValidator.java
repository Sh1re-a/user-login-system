package se.shirwac.user.login.system.email;

import org.springframework.stereotype.Service;

import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class EmailValidator implements Predicate<String> {


    @Override
    public boolean test(String email) {
        if(email.isBlank()){
            return false;
        }

        Pattern pattern = Pattern.compile("([@])"); //case insensitive, use [g] for only lower
        Matcher matcher = pattern.matcher(email);
        int containsAt = 0;
        while (matcher.find()){
            containsAt++;}

        if (containsAt != 1) {
            return false;
        }

        String[] splitEmailByAt = email.split("@");
        String domainName = splitEmailByAt[1];
        String[] splitDomainName = domainName.split("\\.");

        pattern = Pattern.compile("([.])");
        matcher = pattern.matcher(domainName);
        int containsDot = 0;
        while (matcher.find()){
            containsDot++;
        }
        if (containsDot != 1) {
            return false;
        }

        if(splitDomainName[1].length() > 3){
            return false;
        }
        else return true;
    }}
