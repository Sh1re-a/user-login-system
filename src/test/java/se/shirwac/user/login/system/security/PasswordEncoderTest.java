package se.shirwac.user.login.system.security;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.assertj.core.api.Assertions.assertThat;


class PasswordEncoderTest {

    BCryptPasswordEncoder encoder;

    @BeforeEach
    public void setUp(){
        encoder = new BCryptPasswordEncoder();
    }


    @Test
    public void emptyPasswordDoesNotMatchPassword() {
        String result = encoder.encode("password");
        assertThat(encoder.matches("", result)).isFalse();

    }



    @ParameterizedTest
    @CsvSource({
            "12345678910"
    })
    public void ItShouldReturnNewCryptPasswordEncoder(String password) {
        encoder.encode(password);
        String encodedPassword = encoder.toString();
        Assertions.assertNotEquals(password,encodedPassword);
    }
}