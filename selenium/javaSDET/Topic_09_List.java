package javaSDET;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.ArrayList;
import java.util.List;

public class Topic_09_List {
    public static void main(String[] args) {
        // Java Collection

        WebDriver driver;
        List<String> address = new ArrayList<String>();
        address.add("1st street");
        address.add("2nd street");
        address.add("3rd street");

        System.out.println(address.get(0));
    }
}
