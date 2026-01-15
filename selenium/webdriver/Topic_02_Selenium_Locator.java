package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class Topic_02_Selenium_Locator {
    //1 - Setup: OS/ Browser/Web/Page/Data/Variable/Object/...
    WebDriver driver;

    String fullName = "Selenium Locator";

    @BeforeClass

    public void initialBrowser() {
        // Mở Browser
        driver = new FirefoxDriver();
        // Mở App
        driver.get("https://demo.nopcommerce.com/register");
    }

    @Test
    //2 - Action/ Execute: Tương tác lên element nào/ nhập liệu/ verify/...
    public void TC_01_ID() throws InterruptedException {
        // Tương tác lên Email
        //<input class="email" autofocus="" type="email" data-val="true" data-val-regex="Wrong email"
        // data-val-required="Please enter your email"
        // id="Email" name="Email">

        // HTML Source Code
        // Thẻ - Thuóc tính -Giá trị thuộc tính
        // Tagname - Attribute -Value

        //Xpath: //tagname[@attribute='value'
        //Css: tagname[attribute='value']

        //Tương tác lên Email Address
        // 8 loại locator để tìm Email này
        driver.findElement(By.id("small-searchterms")).sendKeys("Macbook");
        Thread.sleep(3000);

        driver.findElement(By.id("FirstName")).sendKeys("Automation");
        Thread.sleep(3000);
        //Tìm 1 element
//        WebElement emailTextbox = driver.findElement(By.cssSelector(""));
//        emailTextbox.clear();
//        emailTextbox.sendKeys();
//        emailTextbox.isDisplayed();
//        // 1 - Thao tác lên luôn (dùng 1 lần )
//        driver.findElement(By.cssSelector("a")).click();
//
//        //Tìm nhiều elements
//        List<WebElement> textBoxes = driver.findElements(By.cssSelector(""));

    }

    @Test
    public void TC_02_Class() throws InterruptedException {
        //Nó không lấy hết toàn bộ giá trị nếu có khoảng trắng
        driver.findElement(By.className("register-next-step-button")).click();
        Thread.sleep(3000);
    }

    @Test
    public void TC_03_Name() throws InterruptedException {
        driver.findElement((By.name("Email"))).sendKeys("thetran1352003@gmail.com");
        Thread.sleep(3000);
    }

    @Test
    public void TC_04_Link_Text() {
        // Chỉ làm việc với link
        // Thẻ a có thuộc tính href
        //Phải lấy hết toàn bộ text
        driver.findElement((By.linkText("Register")));
        driver.findElement((By.linkText("Log in")));
        driver.findElement((By.linkText("Wishlist")));
    }

    @Test
    public void TC_05_Partial_Link_Text() {
        // Chỉ làm việc với element là link
        // Có thể lấy toàn bộ text hoặc 1 phần
        driver.findElement(By.partialLinkText("Register"));

        driver.findElement(By.partialLinkText("Digital"));

        driver.findElement(By.partialLinkText("downloads"));
    }

    @Test
    public void TC_06_CSS() {
        driver.findElement(By.cssSelector("input#Company"));
        driver.findElement(By.cssSelector("#Company"));
        driver.findElement(By.cssSelector("input[id='Company']"));

        driver.findElement(By.cssSelector("button.register-next-step-button]"));
        driver.findElement(By.cssSelector("button[class='button-1 register-next-step-button']"));

        driver.findElement(By.cssSelector("a[href*='register?']"));
        driver.findElement(By.cssSelector("a[href*='login?']"));

        driver.findElement(By.cssSelector("a"));
        driver.findElement(By.cssSelector("button"));
        driver.findElement(By.cssSelector("input"));
    }

    @Test
    public void TC_07_Tagname() {
        // Tên thẻ HTML
        // Tìm tất cả các element giống nhau
        driver.findElements(By.tagName("button"));

        driver.findElements(By.tagName("input"));

        driver.findElements(By.tagName("label"));
    }

    @Test
    public void TC_08_XPath() {
        driver.findElement(By.xpath("//input[@id='small-searchterms']"));
        driver.findElement(By.xpath("//input[@id='Password']"));
        driver.findElement(By.xpath("//input[@id='Company']"));

        driver.findElement(By.xpath("//a[text()='Register']"));
        driver.findElement(By.xpath("//a[contains(text()='Shipping')]"));

        // Cách viết Xpath: //tagname[@attribute = 'value']

        // Nên ưu tiên nếu có id/class/name thì dùng trước .
    }

    @Test
    public void TC_09_Relative_Locator() {
        driver.get("https://demo.nopcommerce.com/login");
        //Element / By A
        By passwordTextboxBy = By.cssSelector("input#Password");

        //Element B
        By rememberMeCheckboxBy = By.id("RememberMe");

        //Element C
        By forgotPasswordLinkBy = By.cssSelector("span.forgot-password");

        //Element D
        By loginButtonBy = By.cssSelector("button.login-button");

        //Element E
        WebElement rememberMeLabelText = driver.findElement(RelativeLocator.with(By.tagName("label"))
                .above(loginButtonBy) //Label đang nằm trên Login Button
                .below(passwordTextboxBy) // Label đang nằm dưới Password textbox
                .toRightOf(rememberMeCheckboxBy) //Label nằm bên phải so với RememberMe Checkbox
                .toLeftOf(forgotPasswordLinkBy)); //Label ằm bên trái so với Forgot Password Link

        // 1 - Khi không thể định danh được element của chính nó (dựa vào những cái vị trí bên cạnh/ gần nó)
        // 2 - Sử dụng để test GUI (giao diện - position khớp với Design)
    }


    @AfterClass
    //3 - Clean : Delete data test/ account/ close browser
    public void cleanBrowser() {
        driver.quit();
    }

    public void clickToElement(String locator, int index) {
        driver.findElement(By.cssSelector("a")).click();
    }

}