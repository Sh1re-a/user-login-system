package se.shirwac.user.login.system.validator;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import se.shirwac.user.login.system.validator.NameValidator;

import static org.assertj.core.api.Assertions.assertThat;

public class NameValidatorTest {

    private NameValidator nameValidator;

    @BeforeEach
    void setUp(){
        nameValidator = new NameValidator();
    }

    @ParameterizedTest
    @CsvSource({
            "shirwac abib,true",
            "sh123rwac ab21b,false",
            "s@hirwac a**b..sse,false",
            "shirwac omar, true"
    })
    @DisplayName("It should validate full name")
    void itShouldValidateFullName(String fullName, boolean expected){
        boolean isValid = nameValidator.validateFullName(fullName);
        Assert.assertEquals(expected,isValid);
   }

    @ParameterizedTest
    @CsvSource({
            "sh123rwac ab21b,false",
            "s@hirwac a**b..sse,false"
    })
    @DisplayName("It should not validate full name")
    void itShouldNotValidateFullName(String fullName, boolean expected){
        boolean isNotValid = nameValidator.validateFullName(fullName);
        Assert.assertEquals(expected,isNotValid);
    }


}
