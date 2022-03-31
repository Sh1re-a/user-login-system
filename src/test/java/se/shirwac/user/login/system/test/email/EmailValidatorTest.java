package se.shirwac.user.login.system.test.email;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
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
            "shirwac.abib@gmail.ssed,false",
            "shirwacabib.gmail.se, false",
            "....,false",
            "shirwac@gmailse, false",
            "123456, false",
            "shirwac@Yes.com, true",
            "123445, false"

    })
    @DisplayName("It should validate email")
    void itShouldValidateEmail(String email, boolean expected) {

        boolean isValid = underTest.test(email);
        assertThat(isValid).isEqualTo(expected);
    }
}



