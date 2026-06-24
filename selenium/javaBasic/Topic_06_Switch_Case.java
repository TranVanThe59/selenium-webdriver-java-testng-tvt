package javaBasic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Topic_06_Switch_Case {

        WebDriver driver;
        String projectPath = System.getProperty("user.dir");
        @Parameters("browser")
        @Test
        public void TC_03_If_Else_If_Else(String browserName) {
            switch (browserName) {
                case "chrome":
                    System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
                    driver = new ChromeDriver();
                    break;

                case "firefox":
                    System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
                    driver = new ChromeDriver();
                    break;

                default:
                    new RuntimeException("Please input correct the browser name!");
                    break;
            }
            if (browserName.equalsIgnoreCase("chrome")) {
                System.setProperty("webdriver.chrome.driver",
                        projectPath + "\\browserDrivers\\chromedriver.exe");
                driver = new ChromeDriver();

            } else if (browserName.equalsIgnoreCase("firefox")) {
                System.setProperty("webdriver.gecko.driver",
                        projectPath + "\\browserDrivers\\geckodriver.exe");
                driver = new FirefoxDriver();

            } else if (browserName.equalsIgnoreCase("edge")) {
                System.setProperty("webdriver.edge.driver",
                        projectPath + "\\browserDrivers\\msedgedriver.exe");
                driver = new EdgeDriver();

            } else if (browserName.equalsIgnoreCase("ie")) {
                System.setProperty("webdriver.ie.driver",
                        projectPath + "\\browserDrivers\\IEDriverServer.exe");
                driver = new InternetExplorerDriver();

            } else { // Safari / Opera / CocCoc / ...
                throw new RuntimeException("Please input correct the browser name!");
            }
        }
    }

