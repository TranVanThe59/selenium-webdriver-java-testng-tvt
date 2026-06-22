package testng;

import org.testng.annotations.Test;

public class Topic_06_Skip {
    @Test(priority = 1)
    public void shouldBeCreateNew(){
        System.out.println("shouldBeCreateNew");
    }

    @Test(priority = 4)
    public void shouldBeDelete(){
        System.out.println("shouldBeDelete");
    }

    @Test(priority = 3)
    public void shouldBeUpdate(){
        System.out.println("shouldBeUpdate");
    }
    @Test(enabled = true)
    public void shouldBeRead(){
        System.out.println("shouldBeRead");
    }
}
