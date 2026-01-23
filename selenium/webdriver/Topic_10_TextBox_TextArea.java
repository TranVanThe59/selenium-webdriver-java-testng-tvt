package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Random;

public class Topic_10_TextBox_TextArea {
    WebDriver driver;
    Random rand;

    String firstName, lastName, emailAddress, password, fullName;
    @BeforeClass

    public void initialBrowser(){
        // Mở Browser
        driver = new FirefoxDriver();
        rand = new Random();

        firstName = "Joe";
        lastName = "Biden";
        fullName = firstName + " " + lastName;
        emailAddress = "joebiden" + rand.nextInt(999999) + "@gmail.com";
        password = "123456789";
    }
    @Test
    //2 - Action/ Execute: Tương tác lên element nào/ nhập liệu/ verify/...
    public void TC_01_TechPanda() throws InterruptedException {
        driver.get("http://live.techpanda.org/index.php");

        driver.findElement(By.xpath( "//div[@class='footer']//a[text()='My Account']")).click();
        driver.findElement(By.xpath( "//a[@title='Create an Account']")).click();
        driver.findElement(By.cssSelector("input#firstname")).sendKeys(firstName);
        driver.findElement(By.cssSelector("input#lastname")).sendKeys(lastName);
        driver.findElement(By.cssSelector("input#email_address")).sendKeys( emailAddress);
        driver.findElement(By.cssSelector("input#password")).sendKeys( password);
        driver.findElement(By.cssSelector("input#confirmation")).sendKeys(password);

        driver.findElement(By.cssSelector("button[title='Register']")).click();

        Assert.assertEquals(driver.findElement(By.cssSelector("li.success-msg span")).getText(),"Thank you for registering with Main Website Store.");

        String contactInformationText = driver.findElement(By.xpath("//h3[text()='Contact Information']/parent::div/following-sibling::div/p")).getText();

        // Tuong doi
        Assert.assertTrue(contactInformationText.contains(fullName) && contactInformationText.contains(emailAddress)); //FullName

        driver.findElement(By.xpath("//h3[text()='Contact Information']/following-sibling::a")).click();

        Assert.assertEquals(driver.findElement(By.id("firstname")).getAttribute("value"), firstName);
        Assert.assertEquals(driver.findElement(By.id("lastname")).getAttribute("value"), lastName);
        Assert.assertEquals(driver.findElement(By.id("email")).getAttribute("value"), emailAddress);

        //Product Review
        driver.findElement(By.xpath("//a[text()='Mobile']")).click();

        driver.findElement(By.xpath("//h2/a[@title='Samsung Galaxy']")).click();

        driver.findElement(By.xpath("//a[text()='Add Your Review']")).click();

        driver.findElement(By.cssSelector("input[id='Quality 1_5']")).click();

        driver.findElement(By.cssSelector("textarea#review_field")).sendKeys("Good application\nPretty easy to navigate");

        driver.findElement(By.cssSelector("input#summary_field")).sendKeys("Good Phone");

        driver.findElement(By.cssSelector("input#nickname_field")).clear();
        driver.findElement(By.cssSelector("input#nickname_field")).sendKeys("automationfc");

        driver.findElement(By.cssSelector("button[title='Submit Review']")).click();

        Assert.assertEquals(By.cssSelector("li.success-msg span").findElement(driver).getText(),"Your review has been accepted for moderation.");
        //Logout
        driver.findElement(By.cssSelector("div.account-cart-wrapper>a")).click();

        driver.findElement(By.xpath("//a[@title='Log Out']")).click();

        Thread.sleep(6000);


    }
    @Test
    public void TC_02_TextBox(){
    }
    @AfterClass
    //3 - Clean : Delete data test/ account/ close browser
    public void cleanBrowser(){
        driver.quit();
    }

}