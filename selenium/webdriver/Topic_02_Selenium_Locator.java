package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_02_Selenium_Locator {
    //1 - Setup: OS/ Browser/Web/Page/Data/Variable/Object/...
    WebDriver driver;
    @BeforeClass

    public void initialBrowser(){
        // Mở Browser
        driver = new FirefoxDriver();
        // Mở App
        driver.get("https://demo.nopcommerce.com/login");
    }
    @Test
    //2 - Action/ Execute: Tương tác lên element nào/ nhập liệu/ verify/...
    public void TC_01_Register(){
        // Tương tác lên Email
        //<input class="email" autofocus="" type="email" data-val="true" data-val-regex="Wrong email"
        // data-val-required="Please enter your email"
        // id="Email" name="Email">

        // HTML Source Code
        // Thẻ - Thuóc tính -Giá trị thuộc tính
        // Tagname - Attribute -Value

        //Xpath: //tagname[@attribute='value'
        //Css: tagname[attribute='value']

        //Tương tác lên Email Address
        // 8 loại locator để tìm Email này
        driver.findElement(By.id("email")).sendKeys("email");
    }
    @Test
    public void TC_02_Login(){

    }
    @AfterClass
    //3 - Clean : Delete data test/ account/ close browser
    public void cleanBrowser(){
        driver.quit();
    }

}