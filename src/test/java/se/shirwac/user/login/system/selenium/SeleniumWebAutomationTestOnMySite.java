package se.shirwac.user.login.system.selenium;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.safari.SafariDriver;

import static org.assertj.core.api.Fail.fail;

public class SeleniumWebAutomationTestOnMySite {


    private static final String safariWebDriver = "webdriver.safari.driver";
    private static final String safariWebDriverPath = "/usr/bin/safaridriver";
    private static SafariDriver safariDriver;
    private SeleniumWebAutomation seleniumWebAutomation;



    @BeforeEach
    public void setUp(){

        seleniumWebAutomation = new SeleniumWebAutomation();

        safariDriver = new SafariDriver();
        seleniumWebAutomation.initializeDriver
                ("http://127.0.0.1:5500/src/main/resources/static/index.html",safariWebDriver, safariWebDriverPath,
                        safariDriver);
        seleniumWebAutomation.makeItFullScreen(safariDriver);

    }


    @Disabled
    public void testWritingInFormOnMyWebsite(){
        seleniumWebAutomation.writeInForm("formFullName","Shirwac Abib",safariDriver);
        seleniumWebAutomation.writeInForm("formEmail","Shirwac@gmail.com",safariDriver);
        seleniumWebAutomation.writeInForm("formPassword","12345678",safariDriver);
        seleniumWebAutomation.closeDriver(safariDriver);


    }




}
