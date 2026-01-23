package javaSDET;

import org.testng.annotations.Test;

import java.util.Random;

public class Topic_05_Random {
    String prefixEmail = "joebiden";

    String postfixEmail = "@gmail.com";


    @Test
    public void randomEmail() {
        Random rand = new Random();

        //local
        String fullEmail = prefixEmail + rand.nextInt(999999) +postfixEmail;
        System.out.println(fullEmail);
    }
}
