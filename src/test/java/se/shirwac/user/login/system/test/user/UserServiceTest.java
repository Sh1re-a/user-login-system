package se.shirwac.user.login.system.test.user;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import se.shirwac.user.login.system.user.User;
import se.shirwac.user.login.system.user.UserService;

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
    @DisplayName("It should validate fullname")
    void itShouldValidateFullName(String fullName, boolean expected){
        boolean isValid = underTest.validateFullName(fullName);
        assertThat(isValid).isEqualTo(expected);
   }


}
