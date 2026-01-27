package javaSDET;

import java.util.ArrayList;
import java.util.List;

public class Topic_08_For {
    public static void main(String[] args) {
        // Biểu thức vòng lặp
        int number =100;

        // for (classic - iterator)
        for(int i=0;i<number;i++){
            System.out.println(i);
        }

        //Collection: List/Set/Queue/Map
        List<String> name = new ArrayList<String>();
        name.add("a");
        name.add("b");
        name.add("c");
        name.add("d");
        name.add("e");

        // for - each
        for(String x : name){
            if(x=="a"){
                System.out.println(x);
            }
        }
        //while
        int i = 0;
        while(i<number){
            System.out.println(i);
            i++;
        }
        //do-while
        do {
            System.out.println(i);
            i++;
        } while(i<number);
    }
}
