package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Topic_05_WebBrowser_Commands {
    //1 - Setup: OS/ Browser/Web/Page/Data/Variable/Object/...
    WebDriver driver;
    @BeforeClass

    public void initialBrowser() throws MalformedURLException {
        // Run with browser (local)
//        driver = new FirefoxDriver();
//        driver = new EdgeDriver();
//        driver = new ChromeDriver();
//        driver = new SafariDriver();
//        driver = new InternetExplorerDriver();

        // Remote (Grid/Docker/Cloud Testing)
        // Networking (LAN, WAN, IP, Port)
//        ChromeOptions chromeOptions = new ChromeOptions();
//        driver = new RemoteWebDriver(new URL("https://localhost:8080"), chromeOptions);
    }
    @Test
    //2 - Action/ Execute: Tương tác lên element nào/ nhập liệu/ verify/...
    public void TC_01_(){
        driver.get("https://demo.nopcommerce.com/"); // Mở ra một URL bất kỳ (phải bất đầu bằng http và https)

        // Đóng browser (active tab, window)
        driver.close();

        //Đóng browser ( bao gồm tất cả các tab, window)
        driver.quit();

        // Lấy ra title của page hiện tại
        // 1- Lưu dữ liệu lại rồi kiểm tra sau
        String homePageTitle = driver.getTitle();

        Assert.assertEquals(homePageTitle, "nopCommerce demo store");

        // 2- Kiểm tra trực tiếp
        Assert.assertEquals(driver.getTitle(), "nopCommerce demo store");

        // Lấy ra URL của page hiện tại
        Assert.assertEquals(driver.getCurrentUrl(), "https://demo.nopcommerce.com/cart");

        //Lấy ra Page Source Code
        String homePageSourceCode = driver.getPageSource();

        // Kiểm tra tương đối
        Assert.assertTrue(homePageSourceCode.contains("Conditions of Use"));

        // Lấy ra ID của tab/ window đang active
        driver.getWindowHandle();

        // Lấy ra tất cả ID của tất cả các tab/window đang có
        driver.getWindowHandles();

        // Đi tìm 1 element
        driver.findElement(By.xpath(""));

        // Đi tìm n elements
        driver.findElements(By.xpath(""));

        // Dùng để chờ cho việc tìm element (findElement /  findElements)
        driver.manage().timeouts().implicitlyWait(Duration.ofDays(15));
        driver.manage().timeouts().implicitlyWait(Duration.ofHours(15));
        driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(15));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(15));
        driver.manage().timeouts().implicitlyWait(Duration.ofNanos(15));

        // Dùng để chờ cho việc page được load xong
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));

        // Dùng để chờ một đoạn script được thực thi xong
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(15));

        // Thu nhỏ về TaskBar để chạy
        driver.manage().window().minimize();
        // Phóng to lên (vẫn còn TaskBar)
        driver.manage().window().maximize();
        // Tràn màn hình ( ko có taskbar)
        driver.manage().window().fullscreen();

        // Responsive
        driver.manage().window().setSize(new Dimension(1920,1080));
        driver.manage().window().getSize();

        //
        driver.manage().window().setPosition(new Point(0,0));
        driver.manage().window().getPosition();



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