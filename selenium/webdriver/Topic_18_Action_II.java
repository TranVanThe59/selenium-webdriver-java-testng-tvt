package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Topic_18_Action_II {
    //1 - Setup: OS/ Browser/Web/Page/Data/Variable/Object/...
    WebDriver driver;
    Actions action;
    @BeforeClass

    public void initialBrowser(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        action = new Actions(driver);
    }
    @Test
    public void TC_01_Click_And_Hold_Block() throws InterruptedException {
        driver.get("https://automationfc.github.io/jquery-selectable/");

        List<WebElement> allNumber = driver.findElements(By.cssSelector("ol#selectable>li"));
        Assert.assertEquals(allNumber.size(),30);

        action.clickAndHold(allNumber.get(0)) // Click vào số 1 và giữ chuột
                .moveToElement(allNumber.get(3)) // Di chuột tới số 4
                .release() // Nhả chuột trái
                .perform(); // Thực thi các câu lệnh trên (nếu không có thì không thực thi)

        Thread.sleep(4000);

        List<WebElement> allNumberSelected = driver.findElements(By.cssSelector("ol#selectable>li.ui-selected"));
        Assert.assertEquals(allNumberSelected.size(),4);
    }
    @Test
    public void TC_02_Click_And_Hold_Random() throws InterruptedException {
        driver.get("https://automationfc.github.io/jquery-selectable/");

        List<WebElement> allNumber = driver.findElements(By.cssSelector("ol#selectable>li"));
        Assert.assertEquals(allNumber.size(),30);

        // Nhấn phím Ctrl nhưng chưa nhả
        action.keyDown(Keys.CONTROL).perform();

        action.click(allNumber.get(0))
                .click(allNumber.get(3))
                .click(allNumber.get(7))
                .click(allNumber.get(10))
                .click(allNumber.get(13))
                .click(allNumber.get(17))
                .perform();

        // Nhả phím Ctrl
        action.keyUp(Keys.CONTROL).perform();

        Thread.sleep(4000);

        List<WebElement> allNumberSelected = driver.findElements(By.cssSelector("ol#selectable>li.ui-selected"));
        Assert.assertEquals(allNumberSelected.size(),6);

    }
    @Test
    public void TC_03_Double_Click() throws InterruptedException {
        driver.get("https://automationfc.github.io/basic-form/index.html");

        action.doubleClick(driver.findElement(By.xpath("//button[text()='Double click me']"))).perform();

        Assert.assertEquals(driver.findElement(By.cssSelector("p#demo")).getText(),"Hello Automation Guys!");

    }

    @AfterClass
    //3 - Clean : Delete data test/ account/ close browser
    public void cleanBrowser(){
        driver.quit();
    }

}