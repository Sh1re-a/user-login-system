package se.shirwac.user.login.system.webtest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;

import static org.junit.jupiter.api.Assertions.*;

class SeleniumWebTest {

    private SeleniumWeb underTest;
    @BeforeEach
    void setUp() {
        underTest = new SeleniumWeb();
    }
    @Test
    void runWebTest() {
        underTest.runWebTest();
    }
}