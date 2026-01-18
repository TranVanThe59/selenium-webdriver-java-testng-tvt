package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_03_Xpath_Css {
    //1 - Setup: OS/ Browser/Web/Page/Data/Variable/Object/...
    WebDriver driver;
    @BeforeClass

    public void initialBrowser(){
        // Mở Browser
        driver = new FirefoxDriver();
        // Mở App
        driver.get("https://live.techpanda.org/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @Test
    //2 - Action/ Execute: Tương tác lên element nào/ nhập liệu/ verify/...
    public void Register_01_Empty_Data(){
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");
        driver.findElement(By.xpath("//button[@type='Submit']")).click();

        //Verify với một dữ liệu mong đợi
        Assert.assertEquals(driver.findElement(By.id("txtFirstname-error")).getText(),"Vui lòng nhập họ tên");
        Assert.assertEquals(driver.findElement(By.id("txtEmail-error")).getText(),"Vui lòng nhập email");
        Assert.assertEquals(driver.findElement(By.id("txtCEmail-error")).getText(),"Vui lòng nhập lại địa chỉ email");
        Assert.assertEquals(driver.findElement(By.id("txtPassword-error")).getText(),"Vui lòng nhập mật khẩu");
        Assert.assertEquals(driver.findElement(By.id("txtCPassword-error")).getText(),"Vui lòng nhập lại mật khẩu");
        Assert.assertEquals(driver.findElement(By.id("txtPhone-error")).getText(),"Vui lòng nhập số điện thoại.");


        // Một số function: text(), contains(), string(), last(), start-with()
    }
    @Test
    public void Register_02_Invalid_Email(){

        driver.get("https://alada.vn/tai-khoan/dang-ky.html");

        //Action
        driver.findElement((By.id("txtFirstname"))).sendKeys("Joe Biden");
        driver.findElement((By.id("txtEmail"))).sendKeys("123@345@321");
        driver.findElement((By.id("txtCEmail"))).sendKeys("123@345@321");
        //..
        driver.findElement((By.xpath("//button[@type='Submit']"))).click();
        //Assert
        Assert.assertEquals( driver.findElement((By.id("txtEmail-error"))).getText(),"Vui lòng nhập email hợp lệ");
        Assert.assertEquals( driver.findElement((By.id("txtCEmail-error"))).getText(),"Vui lòng nhập email hợp lệ");
    }
    @Test
    public void Register_03_Incorrect_Confirm_Email(){

        driver.get("https://alada.vn/tai-khoan/dang-ky.html");
        //Action
        driver.findElement((By.id("txtFirstname"))).sendKeys("Joe Biden");
        driver.findElement((By.id("txtEmail"))).sendKeys("john@biden.us");
        driver.findElement((By.id("txtCEmail"))).sendKeys("john@biden.vn");
        driver.findElement((By.xpath("//button[@type='Submit']"))).click();

        Assert.assertEquals( driver.findElement((By.id("txtCEmail-error"))).getText(),"Email nhập lại không đúng");
    }
    @Test
    public void Register_04_Invalid_Password(){

        driver.get("https://alada.vn/tai-khoan/dang-ky.html");

        driver.findElement((By.id("txtFirstname"))).sendKeys("Joe Biden");
        driver.findElement((By.id("txtEmail"))).sendKeys("john@biden.us");
        driver.findElement((By.id("txtCEmail"))).sendKeys("john@biden.vn");
        driver.findElement((By.id("txtPassword"))).sendKeys("1234");
        driver.findElement((By.id("txtCPassword"))).sendKeys("1234");
        driver.findElement((By.xpath("//button[@type='Submit']"))).click();

        Assert.assertEquals( driver.findElement((By.id("txtCPassword-error"))).getText(),"Mật khẩu phải có ít nhất 6 ký tự");
        Assert.assertEquals( driver.findElement((By.id("txtCPassword-error"))).getText(),"Mật khẩu phải có ít nhất 6 ký tự");
    }
    @Test
    public void Register_05_Incorrect_Confirm_Password(){

        driver.get("https://alada.vn/tai-khoan/dang-ky.html");

        driver.findElement((By.id("txtFirstname"))).sendKeys("Joe Biden");
        driver.findElement((By.id("txtEmail"))).sendKeys("john@biden.us");
        driver.findElement((By.id("txtCEmail"))).sendKeys("john@biden.vn");
        driver.findElement((By.id("txtPassword"))).sendKeys("123456");
        driver.findElement((By.id("txtCPassword"))).sendKeys("654321");
        driver.findElement((By.xpath("//button[@type='Submit']"))).click();

        Assert.assertEquals( driver.findElement((By.id("txtCPassword-error"))).getText(),"Mật khẩu bạn nhập không khớp");

    }
    @Test
    public void Register_06_Invalid_phone_Number(){

        driver.get("https://alada.vn/tai-khoan/dang-ky.html");

        driver.findElement((By.id("txtFirstname"))).sendKeys("Joe Biden");
        driver.findElement((By.id("txtEmail"))).sendKeys("john@biden.us");
        driver.findElement((By.id("txtCEmail"))).sendKeys("john@biden.vn");
        driver.findElement((By.id("txtPassword"))).sendKeys("123456");
        driver.findElement((By.id("txtCPassword"))).sendKeys("654321");
        driver.findElement((By.id("txtPhone"))).sendKeys("0987654321");

        driver.findElement((By.xpath("//button[@type='Submit']"))).click();

        Assert.assertEquals( driver.findElement((By.id("txtPhone-error"))).getText(),"Số điện thoại phải từ 10-11 số.");

        driver.findElement(By.id("txtPhone")).clear();
        driver.findElement(By.id("txtPhone")).sendKeys("0987654321");

        driver.findElement((By.xpath("//button[@type='Submit']"))).click();
    }
    @AfterClass
    //3 - Clean : Delete data test/ account/ close browser
    public void cleanBrowser(){
        driver.quit();
    }

}