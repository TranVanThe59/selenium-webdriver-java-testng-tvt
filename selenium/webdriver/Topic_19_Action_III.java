package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.*;
import java.nio.charset.Charset;
import java.time.Duration;

public class Topic_19_Action_III {
    //1 - Setup: OS/ Browser/Web/Page/Data/Variable/Object/...
    WebDriver driver;
    Actions action;
    JavascriptExecutor jsExecutor;
    String projectPath = System.getProperty("user.dir");

    @BeforeClass
    public void initialBrowser(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        action = new Actions(driver);
        jsExecutor = (JavascriptExecutor) driver;
    }
    @Test
    public void TC_01_Drag_Drop_HTML4() throws InterruptedException {
        driver.get("https://automationfc.github.io/kendo-drag-drop/");

        WebElement sourceCircle = driver.findElement(By.cssSelector("div#draggable"));
        WebElement targetCircle = driver.findElement(By.cssSelector("div#droptarget"));

        action.dragAndDrop(sourceCircle, targetCircle).perform();

        Thread.sleep(3000);

        Assert.assertEquals(targetCircle.getText(), "You did great!");
        Assert.assertEquals(Color.fromString(targetCircle.getCssValue("background-color")).asHex().toUpperCase(),"#03A9F4");
    }
    @Test
    public void TC_02_Drag_And_Drop_HTML5() throws InterruptedException, IOException {
        driver.get("https://automationfc.github.io/drag-drop-html5/");

        String jqueryDragDropContent = getContentFile(projectPath + "\\Drag_And_Drop\\drag&&drop.js");

        // Drag A to B
        jsExecutor.executeScript(jqueryDragDropContent);
        Thread.sleep(3000);

        Assert.assertEquals(driver.findElement(By.cssSelector("div#column-a>header")).getText(),"A");
        Assert.assertEquals(driver.findElement(By.cssSelector("div#column-b>header")).getText(),"B");

        // Drag B to A
        jsExecutor.executeScript(jqueryDragDropContent);
        Thread.sleep(3000);

        Assert.assertEquals(driver.findElement(By.cssSelector("div#column-a>header")).getText(),"A");
        Assert.assertEquals(driver.findElement(By.cssSelector("div#column-b>header")).getText(),"B");

    }

    public String getContentFile(String filePath) throws IOException {
        Charset cs = Charset.forName("UTF-8");
        FileInputStream stream = new FileInputStream(filePath);
        try {
            Reader reader = new BufferedReader(new InputStreamReader(stream, cs));
            StringBuilder builder = new StringBuilder();
            char[] buffer = new char[8192];
            int read;
            while ((read = reader.read(buffer, 0, buffer.length)) > 0) {
                builder.append(buffer, 0, read);
            }
            return builder.toString();
        } finally {
            stream.close();
        }
    }

    @Test
    public void TC_04_Scroll_To_Element() throws InterruptedException {
        driver.get("http://live.techpanda.org/index.php/about-magento-demo-store/");

        action.scrollToElement(driver.findElement(By.cssSelector("input#newsletter"))).perform();
        Thread.sleep(3000);
    }
    @AfterClass
    //3 - Clean : Delete data test/ account/ close browser
    public void cleanBrowser(){
        driver.quit();
    }

}