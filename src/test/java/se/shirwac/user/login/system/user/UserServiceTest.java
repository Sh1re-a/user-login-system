package se.shirwac.user.login.system.user;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class UserServiceTest {

    private UserService underTest;

    @BeforeEach
    void setUp(){
        underTest = new UserService();
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
        boolean isValid = underTest.validateFullName(fullName);
        Assert.assertEquals(expected,isValid);
   }

    @ParameterizedTest
    @CsvSource({
            "sh123rwac ab21b,false",
            "s@hirwac a**b..sse,false"
    })
    @DisplayName("It should not validate full name")
    void itShouldNotValidateFullName(String fullName, boolean expected){
        boolean isNotValid = underTest.validateFullName(fullName);
        Assert.assertEquals(expected,isNotValid);
    }


}
