package se.shirwac.user.login.system.webtest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.concurrent.TimeUnit;

public class SeleniumWeb {
    private static final String safariWebDriver = "webdriver.safari.driver";
    private static final String safariWebDriverPath = "/usr/bin/safaridriver";

    public void runWebTest(){

        System.setProperty(safariWebDriver, safariWebDriverPath);

        WebDriver driver = new SafariDriver();

        driver.navigate().to("http://127.0.0.1:5500/src/main/resources/static/index.html");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        driver.findElement(By.id("formFullName")).sendKeys("Shirwac Abib");


        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);





        driver.close();

    }

    }

