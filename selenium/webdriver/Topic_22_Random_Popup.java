package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_22_Random_Popup {
    //1 - Setup: OS/ Browser/Web/Page/Data/Variable/Object/...
    WebDriver driver;
    @BeforeClass

    public void initialBrowser(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @Test
    public void TC_01_() throws InterruptedException {
        driver.get("https://www.javacodegeeks.com/");

        By newsletterPopupBy = By.xpath("//div[@data-title='Newsletter Free eBooks' and not(contains(@style,'display: none'))]");

        // Hiển thị thì close đi
        if(driver.findElements(newsletterPopupBy).size()>0 && driver.findElements(newsletterPopupBy).get(0).isDisplayed()){
            System.out.println("------------------GO TO IF------------------");
            driver.findElement(By.xpath("//div[@data-title='Newsletter Free eBooks' and not(contains(@style,'display: none'))]//a[contains(@onclick,'lepopup_close')]")).click();
            Thread.sleep(3000);
        }
        // Không hiển thị thì action tiếp
        System.out.println("------------------IGNORE IF------------------");
        driver.findElement(By.cssSelector("input#search-input")).sendKeys("Agile");
        driver.findElement(By.cssSelector("form#search span.tie-search-icon")).click();

        Assert.assertTrue(driver.findElement(By.cssSelector("header>h1.page-title")).isDisplayed());
    }

    @AfterClass
    //3 - Clean : Delete data test/ account/ close browser
    public void cleanBrowser(){
        driver.quit();
    }

}