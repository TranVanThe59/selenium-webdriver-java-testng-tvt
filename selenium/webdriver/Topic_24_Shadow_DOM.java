package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_24_Shadow_DOM {
    //1 - Setup: OS/ Browser/Web/Page/Data/Variable/Object/...
    WebDriver driver;
    @BeforeClass

    public void initialBrowser(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @Test
    public void TC_01_(){
        driver.get("https://automationfc.github.io/shadow-dom/");

        // Thuoc DOM cha ben ngoai
        driver.findElement(By.xpath("//a[text()='scroll.html']"));

        //Element cha chua shadow host
        WebElement shadowHostParent = driver.findElement(By.cssSelector("div#shadow_host"));

        //Lay ra element shadow root
        SearchContext firstShadow = shadowHostParent.getShadowRoot();

        Assert.assertTrue(firstShadow.findElement(By.cssSelector("input[type='file']")).isDisplayed());

        Assert.assertEquals(firstShadow.findElement(By.cssSelector("span.info")).getText(),"some text");

        WebElement firstShadowHostParent = driver.findElement(By.cssSelector("div#nested_shadow_host"));

        SearchContext secondShadow = firstShadowHostParent.getShadowRoot();

        Assert.assertEquals(secondShadow.findElement(By.cssSelector("div#nested_shadow_content>div")).getText(),"nested text");

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