package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Topic_12_Custom_Dropdown {
    //1 - Setup: OS/ Browser/Web/Page/Data/Variable/Object/...
    WebDriver driver;
    WebDriverWait explicitwait;
    @BeforeClass
    public void initialBrowser(){
        // Mở Browser
        driver = new FirefoxDriver();
        explicitwait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15)); // Chỉ chờ hàm findElement
        // Explicit Wait: cho element với 1 điều kiện rõ ràng ( chỉ cần xuất hiện trong html, dropdown, checkbox được check hay chưa)

        // Riêng Selenium có 3 cách để wait, riêng Java có Sleep cứng
    }
    @Test
    public void TC_01_JQuery() throws InterruptedException {
        driver.get("https://jqueryui.com/resources/demos/selectmenu/default.html");

        selectItemInCustomDropdown("span#speed-button","ul#speed-menu>li>div","Slower");
        Assert.assertEquals(driver.findElement(By.cssSelector("span#speed-button>span.ui-selectmenu-text")).getText(), "Slower");

        selectItemInCustomDropdown("span#number-button","ul#number-menu>li>div","10");
        Assert.assertEquals(driver.findElement(By.cssSelector("span#number-button>span.ui-selectmenu-text")).getText(), "10");

        selectItemInCustomDropdown("span#salutation-button","ul#salutation-menu>li>div","Mrs.");
        Assert.assertEquals(driver.findElement(By.cssSelector("span#salutation-button>span.ui-selectmenu-text")).getText(), "Mrs.");

    }
    @Test
    public void TC_02_React() throws InterruptedException {
        driver.get("https://react.semantic-ui.com/maximize/dropdown-example-selection/");
        selectItemInCustomDropdown("div.dropdown","div.item>span","Matt");
        Assert.assertEquals(driver.findElement(By.cssSelector("div.divider.text")).getText(), "Matt");

        selectItemInCustomDropdown("div.dropdown","div.item>span","Stevie Feliciano");
        Assert.assertEquals(driver.findElement(By.cssSelector("div.divider.text")).getText(), "Stevie Feliciano");

    }
    @Test
    public void TC_03_VueJS() throws InterruptedException {
        driver.get("https://mikerodham.github.io/vue-dropdowns/");
        selectItemInCustomDropdown("li.dropdown-toggle","ul.dropdown-menu>li>a","Second Option");
        Assert.assertEquals(driver.findElement(By.cssSelector("li.dropdown-toggle")).getText(), "Second Option");

        selectItemInCustomDropdown("li.dropdown-toggle","ul.dropdown-menu>li>a","Third Option");
        Assert.assertEquals(driver.findElement(By.cssSelector("li.dropdown-toggle")).getText(), "Third Option");
    }
    @Test
    public void TC_04_Editable() throws InterruptedException {
        driver.get("https://react.semantic-ui.com/maximize/dropdown-example-search-selection/");
        enterItemInCustomDropdown("input.search","div.item>span","Albania");
        Assert.assertEquals(driver.findElement(By.cssSelector("div.divider.text")).getText(), "Albania");

        enterItemInCustomDropdown("input.search","div.item>span","Argentina");
        Assert.assertEquals(driver.findElement(By.cssSelector("div.divider.text")).getText(), "Argentina");

    }
    //Đự án thực tế : 1 hàm để thao tác lên dropdown chỉ dung 1 site/ app
    // Ko dùng cho nhiều application khác nhau
    // Cơ chế của dropdown giống nhau
    private void selectItemInCustomDropdown(String parentCss, String childCss, String textItem) throws InterruptedException {
        // Hành vi để thao tác lên Dropdown
        // 1- Chờ cho dropdown có thể thao tác lên được (clickable)
        explicitwait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(parentCss)));

        // 2- Click vào element nào để nó xổ ra cái dropdown
        driver.findElement(By.cssSelector(parentCss)).click();
        Thread.sleep(2000);
        // 3- Chờ cho tất cả các item được load ra (presence)
        explicitwait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(childCss)));
        // 4- Tìm item nào đúng vơi mong đợi
        List<WebElement> allItems = driver.findElements(By.cssSelector(childCss));
        // 5- Click lên item đó
        for (WebElement item : allItems) {
            if (item.getText().equals(textItem)) {
                item.click();
                break;
            }
        }
    }
    private void enterItemInCustomDropdown(String parentCss, String childCss, String textItem) throws InterruptedException {
        // Hành vi để thao tác lên Dropdown
        // 1- Chờ cho dropdown có thể thao tác lên được (clickable)
        WebElement dropdownTextbox = explicitwait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(parentCss)));
        dropdownTextbox.clear();
        dropdownTextbox.sendKeys(textItem);

        // 2- Click vào element nào để nó xổ ra cái dropdown
//        driver.findElement(By.cssSelector(parentCss)).click();
        Thread.sleep(2000);
        // 3- Chờ cho tất cả các item được load ra (presence)
        explicitwait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(childCss)));
        // 4- Tìm item nào đúng vơi mong đợi
        List<WebElement> allItems = driver.findElements(By.cssSelector(childCss));
        // 5- Click lên item đó
        for (WebElement item : allItems) {
            if (item.getText().equals(textItem)) {
                item.click();
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