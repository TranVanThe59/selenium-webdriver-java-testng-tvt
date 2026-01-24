package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_11_Default_Dropdown {
    //1 - Setup: OS/ Browser/Web/Page/Data/Variable/Object/...
    WebDriver driver;

    Select select;
    @BeforeClass

    public void initialBrowser(){
        // Mở Browser
        driver = new FirefoxDriver();

    }
    @Test
    public void TC_01_Facebook_SignUp(){
        driver.get("https://www.facebook.com/reg/");

        // Sử dụng khi dropdown xuất hiện
        //1 - Index
        // Index thay đổi vị trí => dễ chạy fail

        //2 - Value
        // Option ko bắt buộc phải có attribute value

        // 3- Text
        // Giống end user chọn. ít đổi text, không bị trùng
        select = new Select(driver.findElement(By.cssSelector("select#day")));

        // Chọn 1 item
        select.selectByVisibleText("25");

        // CHọn xong verify đã chọn thành công hay chưa?
        Assert.assertEquals(select.getFirstSelectedOption().getText(), "25");

        // Verify cái dropdown có phải là multiple select hay không?
        // Nếu là multiple => tra ve true
        // Nếu là single => tra ve false
        Assert.assertFalse(select.isMultiple());

        // Verify so luong item trong dropdown
        Assert.assertEquals(select.getOptions().size(), 31);

        select = new Select(driver.findElement(By.cssSelector("select#month")));
        select.selectByVisibleText("Tháng 7");
        Assert.assertEquals(select.getFirstSelectedOption().getText(), "Tháng 7");

        select = new Select(driver.findElement(By.cssSelector("select#year")));
        select.selectByVisibleText("2006");
        Assert.assertEquals(select.getFirstSelectedOption().getText(), "2006");


    }
    @Test
    public void TC_02_Login(){
    }
    @AfterClass
    //3 - Clean : Delete data test/ account/ close browser
    public void cleanBrowser(){
//       driver.quit();
   }

}