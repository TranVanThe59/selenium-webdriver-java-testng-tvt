package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Topic_27_Wait_FindElement {
    //1 - Setup: OS/ Browser/Web/Page/Data/Variable/Object/...
    WebDriver driver;
    @BeforeClass

    public void initialBrowser(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        //Set total time =13s
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(13));
    }
    @Test
    public void TC_01_FindElement(){

        driver.get("https://demo.nopcommerce.com/register?returnUrl=2%F");
        // 1 - Nếu tìm thấy duy nhất 1 element
        // Trả về đúng element đó
        // Không cần chờ ết time của implicit
        driver.findElement(By.cssSelector("input#3FirstName"));
        // 2 - Nếu tìm thấy nhiều hon 1 element
        // Chỉ thao tác với element đầu tin
        // Lưu ý là khi lấy locator nên check trước
        driver.findElement(By.cssSelector("input[type='text']"));
        // 3 - Nếu không tìm thấy element
        // Mới đầu vào findelement nhưng không thấy
        // Tìm lại maf thấy thì không cần chờ hết time còn lại
        // TÌm lại và không thâ th đnahs fail testcase sau 13s
        // Show lỗi: NoSuchElementException
        driver.findElement(By.cssSelector("input#RememberMe"));
    }
    @Test
    public void TC_02_FindElements(){
        List<WebElement> elements1,elements2,elements3 = null;
        // 1 - Nếu tìm thấy duy nhất 1 element
        elements1 = driver.findElements(By.cssSelector("input#3FirstName"));
        System.out.println(elements1.size());

        // 2 - Nếu tìm thấy nhiều hon 1 element
        elements2 = driver.findElements(By.cssSelector("input[type='text']"));
        System.out.println(elements2.size());

        // 3 - Nếu không tìm thấy element
        elements3 = driver.findElements(By.cssSelector("input#RememberMe"));
        System.out.println(elements3.size());


    }
    @AfterClass
    //3 - Clean : Delete data test/ account/ close browser
    public void cleanBrowser(){
        driver.quit();
    }

}