package com.company;

import java.io.IOException;
import java.text.BreakIterator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        User play = new User();

        play.setName("Corvin");
        String player1 = play.getName();
        play.setName("Anna");
        String player2 = play.getName();
        play.setName("Barb");
        String player3 = play.getName();

        Map<String, Integer> map = new HashMap<>();
        {
            map.put(player1, 133);
            map.put(player2, 433);
            map.put(player3, 77);
        }
        System.out.println("Input name of player.");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            
            if (name.equals(entry.getKey())) {
                System.out.println("Player is " + entry.getKey() + ", result is " + entry.getValue());
                break;
            }
        }
        String[] arr = {"K", "k", "K", "k"};
        String k = "K";
        Map<String, Integer> res = arrayToMap(arr, k);
        System.out.println("Result for " + k + "is " + res + ".");
    }
 public static Map<String, Integer> arrayToMap(String[] ks, String k){
        String[] arr = ks;
        Map<String, Integer> res = new HashMap<>();
        int count = 0;
        for(String a:arr){
           if(a.equals(k)) {
               count = count + 1;
           }
        }
        res.put(k, count);
        return res;
    }
}
class User{
    private String name;
    User(){

    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
