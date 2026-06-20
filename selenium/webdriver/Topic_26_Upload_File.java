package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.time.Duration;
import java.util.List;

public class Topic_26_Upload_File {
    //1 - Setup: OS/ Browser/Web/Page/Data/Variable/Object/...
    WebDriver driver;
    String uploadFolderPath = System.getProperty("user.dir") + File.separator + "uploadFiles" + File.separator;
    String meo1 = "images.jpg";
    String meo2 = "images(1).jpg";
    String meo3 = "images(2).jpg";

    String meo1Path = uploadFolderPath + meo1;
    String meo2Path = uploadFolderPath + meo2;
    String meo3Path = uploadFolderPath + meo3;

    @BeforeClass

    public void initialBrowser(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @Test
    public void TC_01_SingleFile() throws InterruptedException {
        driver.get("https://blueimp.github.io/jQuery-File-Upload/");

        By inputBy = By.xpath("//input[@type='file']");

        driver.findElement(inputBy).sendKeys(meo1Path);
        Thread.sleep(2000);

        driver.findElement(inputBy).sendKeys(meo2Path);
        Thread.sleep(2000);

        driver.findElement(inputBy).sendKeys(meo3Path);
        Thread.sleep(2000);

        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='" + meo1 + "']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='" + meo2 + "']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='" + meo3 + "']")).isDisplayed());

        List<WebElement> startButtons = driver.findElements(By.cssSelector("table button.start"));

        for(WebElement startButton : startButtons){
            startButton.click();
            Thread.sleep(2000);
        }
    }
    @Test
    public void TC_02_MultipleFiles() throws InterruptedException {
        driver.get("https://blueimp.github.io/jQuery-File-Upload/");

        By inputBy = By.xpath("//input[@type='file']");

        driver.findElement(inputBy).sendKeys(meo1Path + "\n" +meo2Path + "\n" +meo3Path);
        Thread.sleep(2000);

        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='" + meo1 + "']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='" + meo2 + "']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='" + meo3 + "']")).isDisplayed());

        List<WebElement> startButtons = driver.findElements(By.cssSelector("table button.start"));

        for(WebElement startButton : startButtons){
            startButton.click();
            Thread.sleep(2000);
        }
    }
    @AfterClass
    //3 - Clean : Delete data test/ account/ close browser
    public void cleanBrowser(){
        driver.quit();
    }

}