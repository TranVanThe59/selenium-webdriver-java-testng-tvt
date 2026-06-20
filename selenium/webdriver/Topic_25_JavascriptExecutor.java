package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Random;

public class Topic_25_JavascriptExecutor {
    //1 - Setup: OS/ Browser/Web/Page/Data/Variable/Object/...
    WebDriver driver;
    JavascriptExecutor jsExecutor;
    WebDriverWait wait;
    String email;
    @BeforeClass

    public void initialBrowser(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        jsExecutor = (JavascriptExecutor) driver;
        email = "automation" + new Random().nextInt(99999) + "@gmail.com";
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @Test
    public void TC_01_() throws InterruptedException {
        // Lấy ra domain
        jsExecutor.executeScript("window.location='https://live.techpanda.org/'");
        Thread.sleep(2000);


        String techPandaDomain = (String) jsExecutor.executeScript("return document.domain");
        Assert.assertEquals(techPandaDomain,"live.techpanda.org");

        String homePageURL = (String) jsExecutor.executeScript("return document.URL;");
        Assert.assertEquals(homePageURL,"https://live.techpanda.org/");

        jsExecutor.executeScript("arguments[0].click();", driver.findElement(By.xpath("//a[text()='Mobile']")));
        Thread.sleep(2000);

        jsExecutor.executeScript("arguments[0].click();", driver.findElement(By.xpath( "//a[@title='Samsung Galaxy']/parent::h2/following-sibling::div[@class='actions']/button")));
        Thread.sleep(3000);

        String samsungText = (String) jsExecutor.executeScript ("return document.documentElement.innerText;");
        Assert.assertTrue (samsungText.contains("Samsung Galaxy was added to your shopping cart."));

        jsExecutor.executeScript("arguments[0].click();", driver.findElement(By.xpath("//a[text()='Customer Service']")));
        Thread.sleep(3000);

        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.cssSelector("input#newsletter")));
        Thread.sleep(2000);
        jsExecutor.executeScript("arguments[0].setAttribute('value', '"+ email + "')", driver.findElement(By.cssSelector("input#newsletter")));

        jsExecutor.executeScript("arguments[0].click();", driver.findElement(By.xpath( "button[title='Subscribe']")));
        Thread.sleep(3000);
        String subscriptionText = (String) jsExecutor.executeScript("return document.documentElement.innerText;");
        Assert.assertTrue(subscriptionText.contains("Thank you for your subscription."));

        jsExecutor.executeScript("window.location = 'https://www.facebook.com/");
        Thread.sleep(3000);
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