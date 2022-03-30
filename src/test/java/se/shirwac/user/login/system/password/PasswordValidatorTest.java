package se.shirwac.user.login.system.password;

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
            "shirwacwac, false",
            "1234567, false",
            "Shirwac@123, true",
            "Shirwac@, false",
            "shi123, false"
    })
    @DisplayName("It should validate password")
    void itShouldValidatePassword(String password, boolean expected) {

        boolean isValid = underTest.validatePassword(password);

        assertThat(isValid).isEqualTo(expected);
    }
}