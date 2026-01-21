package webdriver;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_06_07_WebElement_Commands {
    //1 - Setup: OS/ Browser/Web/Page/Data/Variable/Object/...
    WebDriver driver;

    WebElement element;

    @Test
    public void TC_01_WebElement(){
        driver.findElement(By.xpath("")).click();

        element = driver.findElement(By.xpath(""));

        element.click(); // Click vào các element dạng: button/ checkbox/ radio/ link/ image

        element.sendKeys("dam@gmail.com"); // Nhập liệu vào các element dạng: textbox, textarea, dropdown
        element.sendKeys(Keys.ENTER); // Giả lập lại các phim trên keyboards

        element.findElement(By.id("")).findElement(By.cssSelector(""));

        element.submit(); // Tác dụng với form (Sign up / login / Search )
        // Áp dụng cho tất cả các loại element
        // Kiểm tra 1 element có hiển thị hay không
        // Size > 0: Width/ height > 0
        // Nhìn thấy/ thao tác được
        element.isDisplayed();

        // Áp dụng cho tất cả các loại
        // Kiểm tra 1 element có bị disable hay không
        element.isEnabled();

        // Áp dụng cho duy nhất 3 loại: checkbox/ radio/ dropdown
        // Kiêm tra 1 element đã được chọn rồi hay chưa chọn
        element.isSelected();

        element.getCssValue("color"); // Lấy giá trị Css, test GUi, font, size, color, position,...

        element.getText(); // Áp dụng cho element chứa text
        element.getAttribute("placeholder");

        element.getLocation(); // Lấy vị trí của element so với Viewport

        Rectangle rectangle = element.getRect();

        //Size
        rectangle.getWidth();
        rectangle.getHeight();
        rectangle.getDimension();

        // Location
        rectangle.getX();
        rectangle.getY();
        rectangle.getPoint();

        // Lấy ra thẻ HTMl của element đó
        element.getTagName();

        element.getAccessibleName();

        element.getAriaRole();

        element.getDomAttribute("");

        element.getDomProperty("");

        //Popup
        element.getShadowRoot();

        element.getScreenshotAs(OutputType.FILE);

    }


}