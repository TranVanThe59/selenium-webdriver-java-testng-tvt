package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.security.Key;

public class Topic_09_WebElement_Exercise {
    WebDriver driver;
    @BeforeClass

    public void initialBrowser(){
        // Mở Browser
        driver = new FirefoxDriver();
        // Mở App
        driver.get("https://demo.nopcommerce.com/login");
    }
    @Test

    public void TC_01_Display(){
        // isDisplayed : kiem tra bat ky 1 element nao hien thi
        // Co the nhin thay va co kich thuoc cu the
        driver.get("https://automationfc.github.io/basic-form/index.html");

        WebElement emailTextbox = driver.findElement(By.cssSelector("input#mail"));

        if(emailTextbox.isDisplayed()){
            System.out.println("Element is displayed");
            emailTextbox.sendKeys("Automation Testing");
        } else {
            System.out.println("Element is not displayed");
        }

        WebElement ageUnder18Radio = driver.findElement(By.cssSelector("input#under_18"));
        if(ageUnder18Radio.isDisplayed()){
            System.out.println("Age Under 18 is displayed");
            ageUnder18Radio.click();
        } else {
            System.out.println("Age Under 18 is not displayed");
        }

        WebElement educationTextArea = driver.findElement(By.cssSelector("input#edu"));
        if(educationTextArea.isDisplayed()){
            System.out.println("Education TextArea is displayed");
            educationTextArea.sendKeys("Automation Testing");
        } else {
            System.out.println("Education TextArea is not displayed");
        }

        WebElement user5Text = driver.findElement(By.xpath("//h5[text()='Name: User 5']"));
        if(educationTextArea.isDisplayed()){
            System.out.println("Text is displayed");
        } else {
            System.out.println("Text is not displayed");
        }



    }
    @Test
    public void TC_02_Enabled(){
        // Kiem tra mot element nao do co the tuong tac len duoc va nguoc lai voi read-only (disable)
        driver.get("https://automationfc.github.io/basic-form/index.html");

        WebElement emailTextbox = driver.findElement(By.cssSelector("input#mail"));

        if(emailTextbox.isEnabled()){
            System.out.println("Element is enabled");
        } else {
            System.out.println("Element is disabled");
        }

        WebElement ageUnder18Radio = driver.findElement(By.cssSelector("input#under_18"));
        if(ageUnder18Radio.isEnabled()){
            System.out.println("Age Under 18 is enabled");
        } else {
            System.out.println("Age Under 18 is disabled");
        }

        WebElement passwordTextbox = driver.findElement(By.cssSelector("input#disable_password"));
        if(passwordTextbox.isEnabled()){
            System.out.println("Password is enabled");
        } else  {
            System.out.println("Password is disabled");
        }

        WebElement biographyTextArea = driver.findElement(By.cssSelector("textarea#bio"));
        if(biographyTextArea.isEnabled()){
            System.out.println("biographyTextArea is enabled");
        } else  {
            System.out.println("biographyTextArea is disabled");
        }
    }
    @Test
    public void TC_03_Selected() throws InterruptedException {
        // Kiem tra 1 element duoc chon thanh cong (Radio/Checkbox/Dropdown)
        driver.get("https://automationfc.github.io/basic-form/index.html");

        WebElement ageUnder18Radio = driver.findElement(By.cssSelector("input#under_18"));
        if(ageUnder18Radio.isSelected()){
            System.out.println("Age Under 18 is selected");
        } else {
            System.out.println("Age Under 18 is de-selected");
        }

        WebElement interestCheckbox = driver.findElement(By.cssSelector("input#development"));
        if(interestCheckbox.isSelected()){
            System.out.println("interestCheckbox is selected");
        } else {
            System.out.println("interestCheckbox is de-selected");
        }

        ageUnder18Radio.click();
        interestCheckbox.click();
        Thread.sleep(3000);

        if(ageUnder18Radio.isSelected()){
            System.out.println("Age Under 18 is selected");
        } else {
            System.out.println("Age Under 18 is de-selected");
        }

        if(interestCheckbox.isSelected()){
            System.out.println("interestCheckbox is selected");
        } else {
            System.out.println("interestCheckbox is de-selected");
        }
    }
    @Test
    public void TC_04_MailChim_Validate() throws InterruptedException {
        driver.get("https://login.mailchimp.com/signup/");

        driver.findElement(By.cssSelector("input#email")).sendKeys("automationfc.vn@gmail.com");
        driver.findElement(By.cssSelector("input#email")).sendKeys(Keys.TAB);

        Thread.sleep(3000);

        driver.findElement(By.id("new_password")).sendKeys("12345");
        driver.findElement(By.id("new_password")).sendKeys(Keys.TAB);

        Assert.assertTrue(driver.findElement(By.cssSelector("li.lowercase-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.uppercase-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.number-char.completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.special-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='8-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.username-check.completed")).isDisplayed());

        driver.findElement(By.id("new_password")).clear();
        driver.findElement(By.id("new_password")).sendKeys("auto");
        driver.findElement(By.id("new_password")).sendKeys(Keys.TAB);

    }
    @AfterClass
    //3 - Clean : Delete data test/ account/ close browser
    public void cleanBrowser(){
        driver.quit();
    }

}