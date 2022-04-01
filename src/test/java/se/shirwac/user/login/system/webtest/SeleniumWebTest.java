package se.shirwac.user.login.system.webtest;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;
import java.util.concurrent.TimeUnit;
import org.junit.Assert;

class SeleniumWebTest {

    private static final String safariWebDriver = "webdriver.safari.driver";
    private static final String safariWebDriverPath = "/usr/bin/safaridriver";
    private static SafariDriver safariDriver;


    @BeforeEach
    public void testInitializeDriver() {
        System.setProperty(safariWebDriver, safariWebDriverPath);
        safariDriver = new SafariDriver();
        safariDriver.navigate().to("https://www.saucedemo.com");
        safariDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        safariDriver.manage().window().maximize();
    }

    @Test
    public void testClickButton(){
        WebElement m=safariDriver.
                findElement(By.id("login-button"));
        m.click();

    }

    @Test
    public void testWriteInForm(){
        safariDriver.findElement(By.id("user-name")).sendKeys("Shirwac");
    }

    @Test
    public void testGettingTextFromWebsite(){
        String expectedText = "Accepted usernames are:standard_userlocked_out_userproblem_userperformance_glitch_user";
        String text = safariDriver.findElement(By.id("login_credentials")).getText();
        Assert.assertEquals(expectedText, text);

    }
    @AfterEach
    public void closeDriver()
    {
        if (safariDriver != null)
        {
            safariDriver.quit();
        }
    }


}