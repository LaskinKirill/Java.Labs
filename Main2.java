package com.company;

import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("Задание 2.1:");
        for (int i = 1; i < 100; i++) {
            if (i % 2 != 0) {
                System.out.println(i);
            }
        }

        System.out.println("Задание 2.2:");
        for (int i = 1; i < 101; i++) {
            if (i % 3 == 0) {
                System.out.println("Число делится на 3: " + i);
            }
            if (i % 5 == 0) {
                System.out.println("Число делится на 5: " + i);
            }
            if (i % 15 == 0) {
                System.out.println("Число делится на 3 и на 5 одновременно:" + i);
            }
        }

        System.out.println("Задание 2.3:");
        Scanner scanner = new Scanner(System.in);
        int value1;
        int value2;
        int value3;
        int n = 0;
        do {
            System.out.println("Введите первое число: ");
            value1 = scanner.nextInt();
            System.out.println("Введите второе число: ");
            value2 = scanner.nextInt();
            System.out.println("Введите третье число: ");
            value3 = scanner.nextInt();
            if (value1 + value2 == value3) {
                String result = "TRUE";
                System.out.println(" Результат: " + result);
                n++;
            }
        }
        while (n != 1);
        System.out.println("Задание 2.4:");
        int value4;
        int value5;
        int value6;
        int m = 0;
        do {
            System.out.println("Введите первое число: ");
            value4 = scanner.nextInt();
            System.out.println("Введите второе число: ");
            value5 = scanner.nextInt();
            System.out.println("Введите третье число: ");
            value6 = scanner.nextInt();
            if (value4 < value5 && value5 < value6) {
                String result = "TRUE";
                System.out.println(" Результат: " + result);
                m++;
            }
        }
        while (m != 1);

        System.out.println("Задание 2.5:");
        int i = 10;
        int[] mas = new int[i];
        for (int j = 0; j < i; j++) {
            mas[j] = (0 + (int) (Math.random() * 10));
            System.out.print(mas[j]);
            }
            if (mas[0] == 3 || mas[i - 1] == 3) {

            System.out.println("true");
            }


        System.out.println("Задание 2.6:");
        for( int j = 0; j < i; j++) {
            if (mas[j] == 1) {
                System.out.println("Массив содержит 1");
            }
            if (mas[j] == 3) {
                System.out.println("Массив содержит 3");
            }
        }
        }
   }

