package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class Topic_23_Windows_Tab {
    WebDriver driver;
    @BeforeClass

    public void initialBrowser(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @Test
    public void TC_01_Github() throws InterruptedException {
        driver.get("https://automationfc.github.io/basic-form/index.html");

        // Lấy ra id của tab / windows mà driver đang active tại page đó
        String githubWindowID = driver.getWindowHandle();


        //Click vào gg link => bật google tab mới và tự nhảy qua
        // về code selenium là driver không tự nhảy qua => nó vẫn ở tab cũ
        driver.findElement(By.xpath("//a[text()='GOOGLE']")).click();
        Thread.sleep(3000);

        switchToWindowByID(githubWindowID);

        String googleWindowID = driver.getWindowHandle();

        driver.findElement(By.cssSelector("textarea[name='q']")).sendKeys("Selenium WebDriver");
        Thread.sleep(3000);

        //Switch về tab github
        switchToWindowByID(googleWindowID);

        //Click vào facebook link => nó sẽ bật lên 1 tab mới và tự nhảy qua
        driver.findElement(By.xpath("//a[text()='FACEBOOK']")).click();
        Thread.sleep(3000);

        //Lấy hết toàn bộ các ID của window/tab
        Set<String> allWindowID = driver.getWindowHandles();

        //Dùng vòng lặp duyệt qua từng ID
        for (String id : allWindowID) {
            // Mỗi lần duyệt sẽ cho nó switch vào trước
            driver.switchTo().window(id);
            // Get ra title của window/tab hiện tại
            String pageTitle = driver.getTitle();
            //Kiểm tra title
            if (pageTitle.equals("Facebook")) {
                break;
            }
        }

    }
    @Test
    public void TC_02_TechPanda() throws InterruptedException {
        driver.get("https://live.techpanda.org/index.php/");

        driver.findElement(By.xpath("//a[text()='Mobile']")).click();

        //Click to Add to Compare button at Sony Xperia
        driver.findElement(By.xpath("//a[text()='Sony Xperia']/parent::h2/following-sibling::div[@class='actions']//a[@class='link-compare']")).click();

        Assert.assertEquals(driver.findElement(By.cssSelector("li.success-msg span")).getText(), "The product Sony Xperia has been added to comparison list.");

        //Click to Add to Compare button at Samsung Galaxy
        driver.findElement(By.xpath("//a[text()='Samsung Galaxy']/parent::h2/following-sibling::div[@class='actions']//a[@class='link-compare']")).click();

        Assert.assertEquals(driver.findElement(By.cssSelector("li.success-msg span")).getText(), "The product Samsung Galaxy has been added to comparison list.");


        //Click to Compare
        driver.findElement(By.cssSelector("button[title='Compare']")).click();
        Thread.sleep(3000);

        switchToWindowByTitle("Products Comparison List - Magento Commerce");

        Assert.assertEquals(driver.getCurrentUrl(),"https://live.techpanda.org/index.php/catalog/product_compare/index/");

        driver.findElement(By.cssSelector("button[title='Close Window']")).click();

    }

    private void switchToWindowByID(String windowID) {
        // Lấy ra hết tất cả các ID của window/tab hiện tại
        Set<String> allWindowsID=driver.getWindowHandles();
        for(String id : allWindowsID){
            if(!id.equals(windowID)){
                driver.switchTo().window(id);
            }
        }
    }

    private void switchToWindowByTitle(String expectedWindowTitle) throws InterruptedException {
        // Lấy hết toàn bộ các ID của window/tab\
        Set<String> allWindowsIDs=driver.getWindowHandles();

        // Dùng vòng lặp duyệt qua từng ID
        for (String id : allWindowsIDs){
            driver.switchTo().window(id);
            Thread.sleep(3000);

            // Lấy ra title của window hiện tại
            String pageTitle = driver.getTitle();
            if (pageTitle.equals(expectedWindowTitle)) {
                break;
            }
        }
    }

    @AfterClass
    //3 - Clean : Delete data test/ account/ close browser
    public void cleanBrowser(){
        driver.quit();
    }

}