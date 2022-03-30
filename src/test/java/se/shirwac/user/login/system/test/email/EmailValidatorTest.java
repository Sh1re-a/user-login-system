package se.shirwac.user.login.system.test.email;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import se.shirwac.user.login.system.email.EmailValidator;

import static org.assertj.core.api.Assertions.assertThat;

public class EmailValidatorTest {

   private EmailValidator underTest;

   @BeforeEach
    void setUp(){
       underTest = new EmailValidator();
   }
    @ParameterizedTest
    @CsvSource({
            "shirwac.abib@gmail.se,true",
            "shirwac.abib@@gmail.se,false",
            "shirwac.abib@gmail..sse,false",
            "shirwac.abib@gmail.ssed,false"
    })
    void itShouldValidateEmail(String email, boolean expected) {

        boolean isValid = underTest.emailValidator(email);
        assertThat(isValid).isEqualTo(expected);
    }
}



