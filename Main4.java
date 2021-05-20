package com.company;
import java.io.IOException;
import java.util.Comparator;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        System.out.println("Задание 4.1.");
        String[] words = {"On", "that", "bombshell", "it", "time", "to", "end", "thank", "you", "for",
                "watching", "take", "care", "and", "good", "night"};

        System.out.println(Arrays.toString(longestString(words)));

        System.out.println("Задание 4.2.");
        System.out.println("Введите слово:");
        Scanner in = new Scanner(System.in);
        String word = in.next();
        if (isPalindrome(word) == true) {
            System.out.println(word + "- палиндром.");
        } else {
            System.out.println(word + "-  не палиндром.");
        }

        System.out.println("Задание 4.3.");

        Scanner scan = new Scanner(System.in);
        System.out.println("Введите текст для поиска бяки.");
        String s = scan.nextLine();
        System.out.println(s);
        String text = s;
        String s1 = s.replace("бяка", "[вырезано цензурой]");
        System.out.println(s1);

        System.out.println("Задание 4.4.");
        System.out.println("Введите подстроку.");
        String s2 = scan.nextLine();
        String[] ords = s.split(" ");
        int count = 0;
        for(String ord : ords) {
            if (ord.compareTo(s2) == 0) {
            count = count + 1;
            }
        }
        System.out.println("Количество вхождений " + s2 + " в " + s + " равно " + count);

        System.out.println("Задание 4.5.");

        for(String ord : ords) {
            System.out.println(reverseStr(ord));
        }

    }
    public static String[] longestString(String[] array) {
        LengthComparator comparator = new LengthComparator();

        Arrays.sort(array, comparator);
        String[] longest = new String[1];
        longest[0] = array[array.length-1];
        return longest;
    }
    public static String reverseString(String s) {
        String r = "";
        for (int i = s.length() - 1; i >= 0; --i) r += s.charAt(i);
        return r;
    }
    public static Boolean isPalindrome(String s) {
        return s.equals(reverseString(s));
    }
    public static Boolean isCompare(String o1, String o2) {
        if (o1.equals(o2)){
            return true;
        } return false;
    }
    public static String reverseStr(String str) {
        char[] array = str.toCharArray();
        String result = "";
        for (int i = array.length - 1; i >= 0; i--) {
            result = result + array[i];
        }
        return result;
    }
}

class LengthComparator implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        return o1.length()-o2.length();
    }
}