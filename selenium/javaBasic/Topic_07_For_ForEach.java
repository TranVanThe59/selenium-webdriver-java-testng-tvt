package javaBasic;

public class Topic_07_For_ForEach {
    public static void main(String[] args) {
        String[] cityName = {"Ha Noi","Da Nang","Hue"};
        for(int i = 0; i < cityName.length; i++) {
            if (cityName[i].equals("Da Nang")) {
                // Action
                System.out.println("Do action!");
                break;
            }
        }
        for(String city :  cityName) {
            System.out.println(city);
        }
    }
}
