package javaBasic;

public class Topic_08_While_Dowhile {
    public static void main(String[] args) {

        for (int i = 0; i < 5; i++) {
            System.out.println("For: " + i);

            if (i == 3) {
                break;
            }
        }

        int i = 0;
        while (i < 5) {
            System.out.println("While: " + i);
            i++;

            if (i == 3) {
                break;
            }
        }
        int a = 0;

        do {
            System.out.println("Do-While: " + a);
            a++;
        } while (a < 5);
    }
}
