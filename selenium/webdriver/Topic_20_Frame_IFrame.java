package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_20_Frame_IFrame {
    //1 - Setup: OS/ Browser/Web/Page/Data/Variable/Object/...
    WebDriver driver;
    @BeforeClass

    public void initialBrowser(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }
    @Test
    public void TC_01_IFrame_FormSite() throws InterruptedException {
        driver.get("https://www.formsite.com/templates/education/campus-safety-survey/");

        driver.findElement(By.cssSelector("img[alt='Campus Safety Survey']")).click();

        // Switch qua iframe
        // 1- Dùng index
        // Frame/ Iframe đầu tiên sẽ có index = 0
//        driver.switchTo().frame(0);
        // Page có id hoặc name
//        driver.switchTo().frame("frame-one85593366");

        //Web có thể cover được 2 cách trên
        driver.switchTo().frame(driver.findElement(By.cssSelector("div#formTemplateContainer>iframe")));

        new Select(driver.findElement(By.cssSelector("select#RESULT_RadioButton-2"))).selectByVisibleText("Sophomore");
        new Select(driver.findElement(By.cssSelector("select#RESULT_RadioButton-3"))).selectByVisibleText("South Dorm");
        driver.findElement(By.xpath("//label[text()='Male']")).click();
        Thread.sleep(3000);

        //Tu B Quay lai A
        driver.switchTo().defaultContent();

        //driver da quay ve A
        driver.findElement(By.cssSelector("a.menu-item-login.fs-btn--transparent-kashmir")).click();

        driver.findElement(By.cssSelector("button#login")).click();

        Assert.assertEquals(driver.findElement(By.cssSelector("div#message-error")).getText(), "Username and password are both required.");

//        // A qua B
//        driver.switchTo().frame(0);
//        // B qua C
//        driver.switchTo().frame(0);
//        // C quay lai B
//        driver.switchTo().parentFrame();
//        //B quay lai A
//        driver.switchTo().defaultContent();
    }
    @Test
    public void TC_02_Iframe_ToiDiCodeDao(){
        driver.get("https://toidicodedao.com");

        driver.switchTo().frame(driver.findElement(By.cssSelector("div.fb_iframe_widget iframe")));

        By followerText = By.xpath("//a[@title='Tôi đi code dạo']/parent::div/following-sibling::div[text()]");
        Assert.assertEquals(driver.findElement(followerText).getText(),"398.332 followers");
    }
    @Test
    public void TC_03_Frame() throws InterruptedException {
        driver.get("https://netbanking.hdfcbank.com/netbanking/");

        driver.switchTo().frame("login_page");

        driver.findElement(By.cssSelector("input[name='fldLoginUserId']")).sendKeys("automationfc");
        Thread.sleep(3000);

        driver.findElement(By.cssSelector("a.login-btn")).click();
        Thread.sleep(3000);

        driver.findElement(By.cssSelector("input#keyboard")).sendKeys("123456789");
        driver.findElement(By.cssSelector("a#loginBtn")).click();
        Thread.sleep(3000);

        Assert.assertEquals(driver.findElement(By.cssSelector("p.error-msg")).getText(), "Customer ID/IPIN (Password) is case sensitive");
    }
    @AfterClass
    //3 - Clean : Delete data test/ account/ close browser
    public void cleanBrowser(){
        driver.quit();
    }

}