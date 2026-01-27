package webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_12_Custom_Dropdown {
    //1 - Setup: OS/ Browser/Web/Page/Data/Variable/Object/...
    WebDriver driver;
    @BeforeClass

    public void initialBrowser(){
        // Mở Browser
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15)); // Chỉ chờ hàm findElement
        // Explicit Wait: cho element với 1 điều kiện rõ ràng ( chỉ cần xuất hiện trong html, dropdown, checkbox được check hay chưa)

        // Riêng Selenium có 3 cách để wait, riêng Java có Sleep cứng
    }
    @Test
    public void TC_01_(){
        driver.get("https://jqueryui.com/resources/demos/selectmenu/default.html");
        // Hành vi để thao tác lên Dropdown
        // 1- Chờ cho dropdown có thể thao tác lên được (clickable)
        // 2- Click vào element nào để nó xổ ra cái dropdown
        // 3- Chờ cho tất cả các item được load ra (presence)
        // 4- Tìm item nào đúng vơi mong đợi
        // 5- Click lên item đó

        // Wait
        // If
        // For
        //List
        // Break
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