package javaSDET;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.*;

public class Topic_01_DataType {
    // 2 nhóm kiểu dữ liệu

    //Cách khai báo:
    //Access Modifier: phạm vi truy cập (private/ public/ protected/ default)
    // 1- Access Modifier - Tên biến - Giá trị của biến
    public char cName = 'b';
    // 2.1. Access Modifier -Tên biến
    private char cAddress;
    //2.2. Tên biến - Giá trị gắn sau (hàm)
    public void clickToElement(){
         cAddress = 'c';
    }


    //Nhóm 1 -Kiểu dữ liệu nguyên thuỷ
    //char: ký tự
    //byte/short/int/long: số nguyên
    //float/double: số thực
    //boolean: logic
    //Nhóm 2 - Kiểu dữ liệu tham chiếu

    //Class
    FirefoxDriver fDriver = new FirefoxDriver();
    Actions actions = new Actions(fDriver);
    Topic_01_DataType topic01 =  new Topic_01_DataType();

    //Interface
    WebDriver driver;
    JavascriptExecutor jsExecutor;

    //Array
    String[] studentName = {"Hiền", "Nam", "Hồng"};

    //List/Set/Queue
    List<String> studentAddress = new ArrayList<>();
    List<String> studentCity = new LinkedList<>();

    //Object
    Object name ="Nam";

    //Map
    Map<String,Integer> zip = new HashMap<>();
}
