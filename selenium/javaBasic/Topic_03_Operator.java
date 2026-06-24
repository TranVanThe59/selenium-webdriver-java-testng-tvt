package javaBasic;

public class Topic_03_Operator {
    public static void main(String[] args) {
        int number = 15;
        number+=5;
        System.out.println(number);

        System.out.println(number/5);

        System.out.println(number%5);

        System.out.println(number++);

        System.out.println(number--);

        if(number<10){
            number+=5;
            System.out.println("Small number");
        }
    }
}
