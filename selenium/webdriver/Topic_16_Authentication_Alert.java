package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_16_Authentication_Alert {
    //1 - Setup: OS/ Browser/Web/Page/Data/Variable/Object/...
    WebDriver driver;
    String username = "admin";
    String password = "admin";
    @BeforeClass

    public void initialBrowser(){
        // Mở Browser
        driver = new FirefoxDriver();
    }
    @Test
    public void TC_01_Authentication_Url(){
        // http/ https:// + username + : + password + @ URL
        driver.get("http://" +username + ":" + password + "@the-internet.herokuapp.com/basic_auth");

        Assert.assertEquals(driver.findElement(By.cssSelector("div.example>p")).getText(), "Congratulations! You must have the proper credentials.");


    }
    @Test
    public void TC_02_Navigate(){
        driver.get("https://the-internet.herokuapp.com/");

        String basicAuthLink = driver.findElement(By.xpath("//a[text()='Basic Auth']")).getAttribute("href");
        driver.get(getAuthenticationUrl(basicAuthLink,username,password));
    }

    public String getAuthenticationUrl(String link, String username, String password){
        String[] linkArray = link.split("//");
        link = linkArray[0] + "//" + username + ":" + password + "@" + linkArray[1];
        return link;
    }

    @AfterClass
    //3 - Clean : Delete data test/ account/ close browser
    public void cleanBrowser(){
        driver.quit();
    }

}