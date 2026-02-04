package webdriver;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_15_JS_Alert {
    //1 - Setup: OS/ Browser/Web/Page/Data/Variable/Object/...
    WebDriver driver;
    WebDriverWait explicitWait;
    @BeforeClass

    public void initialBrowser(){
        // Mở Browser
        driver = new FirefoxDriver();
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait((Duration.ofSeconds(15)));
    }
    @Test
    public void TC_01_Accept_Alert() {
        driver.get("https://automationfc.github.io/basic-form/");

        driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();

        // Wait alert and Switch alert
        explicitWait.until(ExpectedConditions.alertIsPresent());

        Alert alert = driver.switchTo().alert();
//        //Accept Alert
//        alert.accept();
//
//        // Cancel Alert
//        alert.dismiss();

        //Get text to verify
        Assert.assertEquals(alert.getText(), "I am a JS Alert");
        alert.accept();

        Assert.assertEquals(driver.findElement(By.cssSelector("p#result")).getText(), "You clicked an alert successfully");

//        // Enter text into alert
//        alert.sendKeys("");
    }
    @Test
    public void TC_02_Confirm_Alert(){
        driver.get("https://automationfc.github.io/basic-form/");

        driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();

        // Wait alert and Switch alert
        explicitWait.until(ExpectedConditions.alertIsPresent());

        Alert alert = driver.switchTo().alert();

        Assert.assertEquals(alert.getText(), "I am a JS Confirm");
        alert.accept();

        Assert.assertEquals(driver.findElement(By.cssSelector("p#result")).getText(), "You clicked: Ok");

    }
    @Test
    public void TC_03_Prompt_Alert(){
        driver.get("https://automationfc.github.io/basic-form/");

        driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();

        // Wait alert and Switch alert
        explicitWait.until(ExpectedConditions.alertIsPresent());

        Alert alert = driver.switchTo().alert();

        Assert.assertEquals(alert.getText(), "I am a JS prompt");

        String text = "tranvanthe";

        alert.sendKeys(text);
        alert.accept();

        Assert.assertEquals(driver.findElement(By.cssSelector("p#result")).getText(), "You entered: tranvanthe");
    }
    @AfterClass
    //3 - Clean : Delete data test/ account/ close browser
    public void cleanBrowser(){
        driver.quit();
    }

}