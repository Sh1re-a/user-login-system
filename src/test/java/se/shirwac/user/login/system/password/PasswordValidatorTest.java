package se.shirwac.user.login.system.password;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


class PasswordValidatorTest {

    private PasswordValidator underTest;

    @BeforeEach
    void setUp() {
        underTest = new PasswordValidator();
    }

    @ParameterizedTest
    @CsvSource({
            "123shirwac,true",
            "Shirwac@123, true",
            "1shirwac, true",
            "1234567S, true"
    })
    @DisplayName("It should validate password")
    void itShouldValidatePassword(String password, boolean expected) {

        boolean isValid = underTest.validatePassword(password);

        Assert.assertEquals(expected,isValid);
    }

    @ParameterizedTest
    @CsvSource({
            "shirwacwac, false",
            "1345, false",
            "Shirwac@, false",
            "shi123, false"
    })
    @DisplayName("It should not validate password")
    void itShouldNotValidatePassword(String password, boolean expected) {

        boolean isNotValid = underTest.validatePassword(password);

        Assert.assertEquals(expected,isNotValid);
    }
}