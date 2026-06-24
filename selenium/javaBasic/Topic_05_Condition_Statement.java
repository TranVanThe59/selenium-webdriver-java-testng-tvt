package javaBasic;

public class Topic_05_Condition_Statement {
    public static void main(String[] args) {
        int number= 5 ;

        if (number >2 && number <10) {
            System.out.println("Go to if");
        }
        else if (number >10 && number <100) {
            System.out.println("Go to ifelse");
        }
        else{
            System.out.println("Go to else");
        }
    }
}
