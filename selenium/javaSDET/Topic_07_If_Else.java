package javaSDET;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Topic_07_If_Else {
    static void main() {
        WebDriver driver;
        String osName = System.getProperty("os.name");
        String browserName = "Chrome";
        // Biểu thức điều kiện
        // if
        if(browserName.equals("IE")){
            System.out.println("Click to SUBMIT button");
        }

        // if-else
        if(osName.contains("Windows")){
            System.out.println("Windows OS");
        } else {
            System.out.println("Mac or Linux");
        }

        // if-else-if-else
        if(browserName.equals("Chrome")){
            driver = new ChromeDriver();
        } else if(browserName.equals("Firefox")) {
            driver = new FirefoxDriver();
        } else {
            driver = new EdgeDriver();
        }

        // switch-case
        switch (browserName){
            case "Chrome":
                driver = new ChromeDriver();
                break;
            case "Firefox":
                driver = new FirefoxDriver();
                break;
            default:
                driver = new EdgeDriver();
                break;
        }
    }
}
