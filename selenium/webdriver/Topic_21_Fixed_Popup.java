package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_21_Fixed_Popup {
    //1 - Setup: OS/ Browser/Web/Page/Data/Variable/Object/...
    WebDriver driver;
    @BeforeClass
    public void initialBrowser(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @Test
    public void TC_01_NgoaiNgu24h() throws InterruptedException {
        driver.get("https://ngoaingu24h.vn/");

        driver.findElement(By.cssSelector("button.login_")).click();

        By loginPopup = By.cssSelector("div#modal-login-v1>div.modal-dialog");

        // Kiểm tra hiển thị có trong html
        // Hiển thị trên UI => true
        // Hiển thị trên Ui => false
        Assert.assertTrue(driver.findElement(loginPopup).isDisplayed());

        driver.findElement(By.cssSelector("input#account-input")).sendKeys("automationfc");
        driver.findElement(By.cssSelector("input#password-input")).sendKeys("automationfc");
        driver.findElement(By.cssSelector("button.btn-login-v1")).click();

        Assert.assertEquals(driver.findElement(By.cssSelector("div#modal-login-v1 div.error-login-panel")).getText(),"Tài khoản không tồn tại!");

        driver.findElement(By.cssSelector("div#modal-login-v1 button.close")).click();
        Thread.sleep(3000);

        Assert.assertFalse(driver.findElement(loginPopup).isDisplayed());


    }
    @Test
    public void TC_02_Kyna() throws InterruptedException {
        driver.get("https://skills.kynaenglish.vn/dang-nhap");

        By loginPopup = By.cssSelector("div#k-popup-account-login-mb>div.modal-dialog");

        Assert.assertTrue(driver.findElement(loginPopup).isDisplayed());

        driver.findElement(By.cssSelector("input#user-login")).sendKeys("automationfc");
        driver.findElement(By.cssSelector("input#user-password")).sendKeys("automationfc");
        driver.findElement(By.cssSelector("button#btn-submit-login")).click();

        Assert.assertEquals(driver.findElement(By.cssSelector("div#password-form-login-message")).getText(),"Sai tên đăng nhập hoặc mật khẩu");
        Thread.sleep(3000);


    }

    @Test
    public void TC_03_Tiki() throws InterruptedException {
        driver.get("https://tiki.vn/");

        //Popup 01- Marketing
        // Hiển thị cố đinh khi vừa mở site ra
        // Khi đóng lại thì không còn trong HTML nữa
        // Khi refresh page thì lại hiện ra
        driver.findElement(By.cssSelector("div[data-view-id='header_header_account_container']")).click();
        Thread.sleep(3000);

        // Popup hiển thị
        Assert.assertEquals(driver.findElements(By.cssSelector("div.ReactModal_Content")).size(),1);

        driver.findElement(By.cssSelector("p.login-with-email")).click();
        Thread.sleep(3000);

        driver.findElement(By.xpath("//button[text()='Đăng nhập'])")).click();
        Thread.sleep(3000);

        Assert.assertEquals(driver.findElement(By.xpath("//span[@class='error-mess'][1]")).getText(),"Email không được để trống");
        Assert.assertEquals(driver.findElement(By.xpath("//span[@class='error-mess'][2]")).getText(),"Mật khẩu không được để trống");

        driver.findElement(By.cssSelector("img.close-img")).click();
        Thread.sleep(3000);

        //Popup ko hiển thị
        Assert.assertEquals(driver.findElements(By.cssSelector("div.ReactModal_Content")).size(),0);
    }
    @AfterClass
    //3 - Clean : Delete data test/ account/ close browser
    public void cleanBrowser(){
        driver.quit();
    }

}