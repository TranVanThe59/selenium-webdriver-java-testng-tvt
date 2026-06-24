package javaBasic;

public class Topic_02_Compare {
    int number = 8;
    public static void main(String[] args) {
        int x = 5;
        int y = x;
        System.out.println(x);
        System.out.println(y);

        Topic_02_Compare firstCompare = new Topic_02_Compare();
        Topic_02_Compare secondCompare = firstCompare;
        secondCompare.number = 15;
        System.out.println(firstCompare.number);
        System.out.println(secondCompare.number);
    }
}
