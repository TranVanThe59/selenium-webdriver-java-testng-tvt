package javaBasic;

public class Topic_04_Casting {
    public static void main(String[] args) {
        byte bNumber = 25;
        System.out.println(bNumber);
        short sNumber = bNumber;
        System.out.println(sNumber);
        int iNumber = sNumber;
        System.out.println(iNumber);
        long lNumber = iNumber;
        System.out.println(lNumber);
        float fNumber = lNumber;
        System.out.println(fNumber);
        double dNumber = fNumber;
        System.out.println(dNumber);

        //Cast
        float fNumber2 = 654321789;
        System.out.println(fNumber2);
        double dNumber2 = (float)fNumber2;
        System.out.println(dNumber2);
        long lNumber2 = (long)dNumber2;
        System.out.println(lNumber2);
        int iNumber2 = (int)lNumber2;
        System.out.println(iNumber2);
    }
}
