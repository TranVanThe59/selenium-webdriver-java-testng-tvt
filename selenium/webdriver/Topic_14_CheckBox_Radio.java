package webdriver;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Topic_14_CheckBox_Radio {
    //1 - Setup: OS/ Browser/Web/Page/Data/Variable/Object/...
    WebDriver driver;
    @BeforeClass

    public void initialBrowser(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();

    }
    @Test
    public void TC_01_Telerik(){
        driver.get("https://demos.telerik.com/kendo-ui/checkbox/index");
        //Scroll xuong mot doan
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,300)");

        // Verify checkbox/ radio is enabled/disabled
        Assert.assertFalse(driver.findElement(By.xpath("//label[text()='Leather trim']/preceding-sibling::span/input")).isEnabled());
        Assert.assertFalse(driver.findElement(By.xpath("//label[text()='Towbar preparation']/preceding-sibling::span/input")).isEnabled());
        // Verify checkbox.radio is selected/deselected
        Assert.assertTrue(driver.findElement(By.xpath("//label[text()='Leather trim']/preceding-sibling::span/input")).isSelected());
        Assert.assertFalse(driver.findElement(By.xpath("//label[text()='Towbar preparation']/preceding-sibling::span/input")).isSelected());

        // Select to " Dual-zone air conditioning"
        By dualZoneAirCheckBox = By.xpath("//label[text()='Dual-zone air conditioning']/preceding-sibling::span/input");

        // Neu nhu chua chon moi click
        if(!driver.findElement(dualZoneAirCheckBox).isSelected()){
            driver.findElement(dualZoneAirCheckBox).click();
        }
        Assert.assertTrue(driver.findElement(dualZoneAirCheckBox).isSelected());

        // Deselect to " Dual-zone air conditioning"
        driver.findElement(dualZoneAirCheckBox).click();
        Assert.assertFalse(driver.findElement(dualZoneAirCheckBox).isSelected());

        driver.get("https://demos.telerik.com/kendo-ui/radiobutton/index");
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,300)");

        By twoPetrolBy = By.xpath("//label[text()='2.0 Petrol, 147kW']/preceding-sibling::span/input");

        if(!driver.findElement(twoPetrolBy).isSelected()){
            driver.findElement(twoPetrolBy).click();
        }
        Assert.assertTrue(driver.findElement(twoPetrolBy).isSelected());
    }
    @Test
    public void TC_02_Multiple(){
        driver.get("https://automationfc.github.io/multiple-fields/");

        //Select all checkboxes
        List<WebElement> checkboxes = driver.findElements(By.cssSelector("span.form-checkbox-item>input"));

        //Click all checkboxes
        for(WebElement checkbox : checkboxes){
            if(!checkbox.isSelected()){
                checkbox.click();
            }
        }

        //Verify all checkboxes selected
        for(WebElement checkbox : checkboxes){
            Assert.assertTrue(checkbox.isSelected());
        }

        //Deselect all checkboxes
        for(WebElement checkbox : checkboxes){
            if(checkbox.isSelected()){
                checkbox.click();
            }
        }

        //Verify all checkboxes deselected
        for(WebElement checkbox : checkboxes){
            Assert.assertFalse(checkbox.isSelected());
        }
        // Select 1 in all + verify
        driver.findElement(By.cssSelector("input[value = 'Venereal Disease']")).click();
        driver.findElement(By.cssSelector("input[value = 'High Blood Pressure']")).click();

        Assert.assertTrue(driver.findElement(By.cssSelector("input[value = 'Venereal Disease']")).isSelected());
        Assert.assertTrue(driver.findElement(By.cssSelector("input[value = 'High Blood Pressure']")).isSelected());

        // Select 1 in all + verify
        for(WebElement checkbox : checkboxes){
            if(!checkbox.isSelected() && checkbox.getAttribute("value").equals("Heart Attack")){
                checkbox.click();
            }
        }
        Assert.assertTrue(driver.findElement(By.cssSelector("input[value = 'Heart Attack']")).isSelected());
    }
    @Test
    public void TC_03_Ubuntu(){
        driver.get("https://login.ubuntu.com/");

//        By newUserRadio = By.cssSelector("input#id_new_user");
//        // 1- Click to Register => Fail
//        // Dùng thẻ input này để verify => Pass
//        driver.findElement(newUserRadio).click();
//        Assert.assertFalse(driver.findElement(newUserRadio).isSelected());

//        By newUserRadio = By.cssSelector("label.new-user");
//        //2 - Dùng 1 thẻ khc input để click => Pass
//        // Dùng thẻ đó để verify => Fail
//        // isSelected() => Dùng cho thẻ input/option
//        driver.findElement(newUserRadio).click();
//        Assert.assertTrue(driver.findElement(newUserRadio).isSelected());

        //3- Dùng 1 thẻ khác input để click => Pass
        // Dùng thẻ input này để verify => Pass
        By newUserRadioLabel = By.cssSelector("label.new-user");
        By newUserRadioInput = By.cssSelector("input#id_new_user");

        driver.findElement(newUserRadioLabel).click();
        Assert.assertTrue(driver.findElement(newUserRadioInput).isSelected());
        // => Thoả mãn được yêu cầu
    }
    @AfterClass
    //3 - Clean : Delete data test/ account/ close browser
    public void cleanBrowser(){
        driver.quit();
    }

}