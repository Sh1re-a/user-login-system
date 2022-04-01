package se.shirwac.user.login.system.selenium;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class SeleniumWebAutomationTestOnMySite {

    private SeleniumWebAutomation seleniumWebAutomation;

    @BeforeEach
    public void setUp(){
        seleniumWebAutomation = new SeleniumWebAutomation();
    }
    //Open the website on a liveServer first
    @Disabled
    public void testRunSeleniumWebAutomationOnMyWebsite(){
        seleniumWebAutomation.runWebTest();
    }
}
