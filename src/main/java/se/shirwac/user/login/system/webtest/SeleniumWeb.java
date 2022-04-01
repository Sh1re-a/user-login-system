package se.shirwac.user.login.system.webtest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
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
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        driver.findElement(By.id("formFullName")).sendKeys("Shirwac Abib");
        driver.findElement(By.id("formEmail")).sendKeys("Shirwac.abib@gmail.com");
        driver.findElement(By.id("formPassword")).sendKeys("123456789");
        String heading = driver.findElement(By.id("welcomeText")).getText();


        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        driver.close();
        System.out.println(heading);

    }

    }

