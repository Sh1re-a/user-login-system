package se.shirwac.user.login.system.test.email;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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
            "shirwac@Yes.com, true",
            "123456@no.se, true"
    })
    @DisplayName("It should validate email")
    void itShouldValidateEmail(String email, boolean expected) {

        boolean isValid = underTest.test(email);
        Assert.assertEquals(expected,isValid);
    }
    @ParameterizedTest
    @CsvSource({
            "shirwac.abib@@gmail.se,false",
            "shirwac.abib@gmail..sse,false",
            "shirwac.abib@gmail.ssed,false",
            "shirwacabib.gmail.se, false",
            "123445, false"
    })
    @DisplayName("It should validate email")
    void itShouldNotValidateEmail(String email, boolean expected){
        boolean isNotValid = underTest.test(email);
        Assert.assertEquals(expected,isNotValid);
    }
}



