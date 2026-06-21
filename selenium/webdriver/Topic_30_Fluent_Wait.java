package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.function.Function;

public class Topic_30_Fluent_Wait {
    //1 - Setup: OS/ Browser/Web/Page/Data/Variable/Object/...
    WebDriver driver;
    WebDriverWait explicitWait;

    FluentWait<WebDriver> driverFluentWait;
    FluentWait<WebElement> elementFluentWait;
    FluentWait<String> stringFluentWait;

    @BeforeClass
    public void initialBrowser(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driverFluentWait = new FluentWait<>(driver);

    }
    @Test
    public void TC_01_Element_Found(){
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10));

        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10),Duration.ofMillis(300));
    }
    public void findElement(long timeout, long polling, By by){
        driverFluentWait = new FluentWait<>(driver);

        driverFluentWait.withTimeout(Duration.ofSeconds(timeout));

        driverFluentWait.pollingEvery(Duration.ofMillis(polling));

        driverFluentWait.ignoring(NoSuchElementException.class);

        driverFluentWait.until(new Function<WebDriver, WebElement>() {
            @Override
            public WebElement apply(WebDriver driver) {
                return driver.findElement(by);
            }
        });
    }
    @AfterClass
    //3 - Clean : Delete data test/ account/ close browser
    public void cleanBrowser(){
        driver.quit();
    }

}