package javaBasic;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Topic_01_Data_Type {

    //Primitive type: du lieu nguyen thuy
    byte bNUmber = 6;
    short sNumber = 1500;
    int iNumber = 65000;
    long lNumber = 65000;
    float fNumber = 15.98f;
    double dNumber = 11.11;
    char cChar = 'a';
    boolean bBool = true;
    //Reference type: tham chiếu
    //Array
    String[] studentName = {"a","b","c"};
    Integer[] studentNumber ={1,2,3,4};
    //String
    String address = "Ha Noi";
    //Interface
    WebDriver driver;
    //Object
    Object aObject;
    //Collection
    //List/Set/Queue/Map
    List<WebElement> homePageLinks = driver.findElements(By.cssSelector("a"));
    Set<String> allWindows = driver.getWindowHandles();
    List<String> productNames = new ArrayList<String>();

    public void clickToElement() {
        address.trim();
        studentName.clone();
        studentNumber.clone();
        homePageLinks.get(0).click();
    }

    public static void main(String[] args) {

    }
}
