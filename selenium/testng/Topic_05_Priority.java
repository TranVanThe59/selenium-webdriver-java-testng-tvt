package testng;

import org.testng.annotations.Test;

public class Topic_05_Priority {
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
    @Test(priority = 2)
    public void shouldBeRead(){
        System.out.println("shouldBeRead");
    }
}
