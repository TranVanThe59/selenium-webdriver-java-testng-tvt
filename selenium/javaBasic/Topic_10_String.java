package javaBasic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Topic_10_String {
    WebDriver driver;
    public static void main(String[] args) {
        String name = "Hello";
        System.out.println(name.length());
        String city = "Da Nang";
        System.out.println(city.equals("Da Nang"));
        System.out.println(city.equalsIgnoreCase("da nang"));
        String email = "the@gmail.com";
        System.out.println(email.contains("@"));
        String phone = "0901234567";
        System.out.println(phone.startsWith("090"));
        String file = "test.xlsx";
        System.out.println(file.endsWith(".xlsx"));
        String firstName = "Tran";
        String lastName = "The";

        String fullName = firstName + " " + lastName;

        System.out.println(fullName);
        String city1 = new String("Ha Noi");
        String city2 = new String("Ha Noi");

        System.out.println(city1 == city2);

    }
}
