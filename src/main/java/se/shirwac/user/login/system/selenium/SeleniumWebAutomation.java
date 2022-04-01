package se.shirwac.user.login.system.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;

import java.util.concurrent.TimeUnit;

public class SeleniumWebAutomation {


    public void initializeDriver(String websiteURL, String safariWebDriver, String safariWebDriverPath,
                                 SafariDriver safariDriver) {
        System.setProperty(safariWebDriver, safariWebDriverPath);
        safariDriver.navigate().to(websiteURL);
        safariDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }

    public void clickButton(String findElementById, SafariDriver safariDriver){
        WebElement m=safariDriver.
                findElement(By.id(findElementById));
        m.click();
    }

    public void writeInForm(String findElementById, String inputText,SafariDriver safariDriver){
        safariDriver.findElement(By.id(findElementById)).sendKeys(inputText);
    }

    public String gettingTextFromWebsite(String findElementById, SafariDriver safariDriver){
        String text = safariDriver.findElement(By.id(findElementById)).getText();
        return text;
    }

    public void usingThreadSleep(int millisSecond){
        try{
            Thread.sleep(millisSecond);
        } catch (InterruptedException e){
            System.out.println("something went wrong");
        }
    }

    public void closeDriver(SafariDriver safariDriver){
        if (safariDriver != null)
        {
            try{
                Thread.sleep(500);
            } catch (InterruptedException e){
                System.out.println("something went wrong");
            }
            safariDriver.quit();
        }
    }

    public void makeItFullScreen(SafariDriver safariDriver){
        safariDriver.manage().window().maximize();
    }



/*
        private static final String safariWebDriver = "webdriver.safari.driver";
        private static final String safariWebDriverPath = "/usr/bin/safaridriver";
        private static SafariDriver safariDriver;

        public void runWebTest(){

        System.setProperty(safariWebDriver, safariWebDriverPath);
        WebDriver driver = new SafariDriver();

        driver.navigate().to("http://127.0.0.1:5500/src/main/resources/static/index.html");
        driver.manage().window().maximize();
        try{
            Thread.sleep(2000);
        } catch (InterruptedException e){
            System.out.println("something went wrong");
        }
        driver.findElement(By.id("formFullName")).sendKeys("Shirwac Abib");
        driver.findElement(By.id("formEmail")).sendKeys("Shirwac.abib@gmail.com");
        driver.findElement(By.id("formPassword")).sendKeys("123456789");
        String heading = driver.findElement(By.id("welcomeText")).getText();
        
        try{
            Thread.sleep(4000);
        } catch (InterruptedException e){
            System.out.println("something went wrong");
        }
        driver.close();
        System.out.println(heading);

    }

 */



    }

