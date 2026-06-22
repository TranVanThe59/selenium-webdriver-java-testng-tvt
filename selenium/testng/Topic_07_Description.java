package testng;

import org.testng.annotations.Test;

public class Topic_07_Description {
    @Test(description = "Function1")
    public void shouldBeCreateNew(){
        System.out.println("shouldBeCreateNew");
    }

    @Test(description = "Function4")
    public void shouldBeDelete(){
        System.out.println("shouldBeDelete");
    }

    @Test(description = "Function3")
    public void shouldBeUpdate(){
        System.out.println("shouldBeUpdate");
    }
    @Test(description = "Function2")
    public void shouldBeRead(){
        System.out.println("shouldBeRead");
    }
}
