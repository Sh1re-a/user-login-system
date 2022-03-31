package se.shirwac.user.login.system.webtest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;

public class SeleniumWeb {
    private static final String safariWebDriver = "webdriver.safari.driver";
    private static final String safariWebDriverPath = "/usr/bin/safaridriver";

    public void runWebTest(){

        System.setProperty(safariWebDriver, safariWebDriverPath);

        WebDriver driver = new SafariDriver();

        driver.navigate().to("http://www.google.com/");


        driver.findElement(By.id("lst-ib")).sendKeys("BrowserStack");


        driver.findElement(By.name("btnK")).click();


        driver.close();

    }
    }

