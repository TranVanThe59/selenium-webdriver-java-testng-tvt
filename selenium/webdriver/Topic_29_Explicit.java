package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.bouncycastle.oer.its.ieee1609dot2.CertificateType.explicit;

public class Topic_29_Explicit {
    //1 - Setup: OS/ Browser/Web/Page/Data/Variable/Object/...
    WebDriver driver;
    WebDriverWait explicitWait;
    @BeforeClass

    public void initialBrowser(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Test
    public void TC_01(){
        explicitWait = new WebDriverWait(driver,Duration.ofSeconds(3));

        driver.get("https://automationfc.github.io/dynamic-loading/");

        driver.findElement(By.cssSelector("div#start>button")).click();

        WebElement until = explicitWait.until(ExpectedConditions.visibilityOfElementLocated((By.cssSelector("div#finish>h4")));

        explicitWait.until(ExpectedConditions.visibilityOfElementLocated((By.cssSelector("div#loading")));

        explicitWait.until(ExpectedConditions.textToBe(By.cssSelector("div#finish>h4"),"Hello World!"));

        Assert.assertEquals(driver.findElement(By.cssSelector("div#finish>h4")).getText(),"Hello World!");
    }


    @AfterClass
    //3 - Clean : Delete data test/ account/ close browser
    public void cleanBrowser(){
        driver.quit();
    }

}