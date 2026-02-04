package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_17_Action_I {
    //1 - Setup: OS/ Browser/Web/Page/Data/Variable/Object/...
    WebDriver driver;
    Actions action;
    @BeforeClass

    public void initialBrowser(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();

        action = new Actions(driver);
    }
    @Test
    public void TC_01_Hover() throws InterruptedException {
        // Khi chạy testcase có liên quan đến Action thì không được dùng chuột/bàn phím cùng lúc
        driver.get("https://automationfc.github.io/jquery-tooltip");

        WebElement ageTextBox = driver.findElement(By.cssSelector("input#age"));

        action.moveToElement(ageTextBox).perform();
        Thread.sleep(2000);

        Assert.assertEquals(driver.findElement(By.cssSelector("div.ui-tooltip-content")).getText(),"We ask for your age only for statistical purposes.");
    }
    @Test
    public void TC_02_(){
    }
    @AfterClass
    //3 - Clean : Delete data test/ account/ close browser
    public void cleanBrowser(){
        driver.quit();
    }

}