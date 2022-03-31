package se.shirwac.user.login.system.webtest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SeleniumWebTest {

    private SeleniumWeb underTest;
    @BeforeEach
    void setUp() {
        underTest = new SeleniumWeb();
    }
    @Test
    void runWebTest() throws InterruptedException {
    underTest.runWebTest();
    }
}