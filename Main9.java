package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Main
{

    public static void main(String[] args)
    {

        int[][] arr = {{101,290,130}, {52,37,68,199,104}, {}, {901}};
        System.out.println("Максимальный элемент массива равен " + getMax(arr));
        int[][] a = {
                {1,1,1,2},
                {1,1,1},
                {1,1,1}
        };

        int[][] b = {
                {1,1,1},
                {1,1,1},
                {1,1,1}
        };
        checkKvad(a);
        checkKvad(b);
        N = 5;
        int[][] mat = {
                { 1, 2, 3, 4, 5 },
                { 5, 3, 1, 4, 2 },
                { 5, 6, 7, 8, 9 },
                { 0, 6, 3, 4, 12 },
                { 9, 7, 12, 4, 3 },
        };
        ArrayList<Integer> ans = colMaxSum(mat);
        System.out.println("Row "+ (ans.get(0)+1)+ " has max sum " + ans.get(1));
        char[][] al= genArray();
        printMatrix(al);
    }
    public static void printMatrix(char[][] grid) {
            for (int r = 0; r < grid.length; r++) {
                for (int c = 0; c < grid[r].length; c++)
                    System.out.print(grid[r][c] + " ");
                System.out.println();
        }
    }
            public static int getMax ( int[][] arr){
                if (arr.length == 0)
                    throw new IllegalArgumentException(); // пустой массив
                int result = Integer.MIN_VALUE;
                for (int[] i : arr) {
                    for (int j : i)
                        result = Math.max(result, j);
                }
                return result;
            }
            public static void checkKvad ( int[][] arr)
            {
                if (arr.length == 0)
                    throw new IllegalArgumentException();
                int flag = 0;
                for (int j = 0; j < arr.length; j++) {

                    if (arr.length != arr[j].length) {
                        System.out.println("It is not a Square!");
                        flag = 1;
                        break;
                    }

                }
                if (flag == 0) {
                    System.out.println("It is a Square");
                }
            }
            public static int N;
            public static ArrayList<Integer> colMaxSum ( int mat[][])
            {
                if (mat.length == 0)
                    throw new IllegalArgumentException();
                int idx = -1;
                int maxSum = Integer.MIN_VALUE;
                for (int i = 0; i < N; i++) {
                    int sum = 0;
                    for (int j = 0; j < N; j++) {
                        sum += mat[i][j];
                    }
                    if (maxSum < sum) {
                        maxSum = sum;
                        idx = i;
                    }
                }
                ArrayList<Integer> res = new ArrayList<>();
                res.add(idx);
                res.add(maxSum);
                return res;
            }
            public static char[][] genArray ()
            {
                Random random = new Random();
                char[][] arr = new char[26][26];
                for (int i = 0; i < 26; i++)
                {
                    for (int j = 0; j < 26; j++) {
                        // Creates an int that will later be cast to a char
                        int let = random.nextInt(51 - 0);
                        // Keeps the int from getting too big
                        if (let >= 26)
                            let = let - 26;
                        // Add 65 to the int so that the char will return letters and not ASCII symbols
                        let = let + 65;
                        // Cast the int to a char
                        char letter = (char) let;
                        // Put the char into its respective place in the array
                        arr[i][j] = letter;

                    }
                }
                return arr;
            }

    }