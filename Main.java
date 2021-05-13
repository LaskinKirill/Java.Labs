package com.company;
import java.util.Scanner;
import java.util.Arrays;
public class Main {

    public static void main(String[] args) {

        int counter, num, item, array[];
        Scanner input = new Scanner(System.in);
        System.out.println("Введите размер массива:");
        num = input.nextInt();
        array = new int[num];
        System.out.println("Введите " + num + " чисел");
        System.out.println("Задание 3.1. Проверка сортировки массива по возрастанию.");
        System.out.println("Задание 3.2. Вывод массива из " + num + " элементов");
        for (counter = 0; counter < num; counter++)
        {
            array[counter] = input.nextInt();
        }
        System.out.println("Result1: " + Arrays.toString(array));
        System.out.println("Задание 3.3. Поменять местами первый и последний элемент массива." );
        changeFLElement(array);
        System.out.println("Result2: " + Arrays.toString(array));
        for (counter = 0; counter < num-1 ; counter++)
        {
            if (array[counter] <= array[counter + 1]) {
                System.out.println("OK");
            }
            if(array[counter] > array[counter + 1])
            System.out.println("Please, try again.");
        }
        System.out.println("Задание 3.4. Найти первый уникальный элемент массива." );
        if (uniqFirst(array) == -1)
        {
            System.out.println("В массиве нет уникальных элементов. ");
        }
         else  { System.out.println("Первый уникальный элемент: " + uniqFirst(array));}

        System.out.println("Задание 3.5. Вычислить N-ое число Фибоначчи." );
        System.out.println("Введите число N: ");
        int N = input.nextInt();
        int f1 = 0;
        int f2 = 1;
        int fsum = 0;
        for (int i = 1; i <= N; i++)
        {
            fsum = f1 + f2;
            f1 = f2;
            f2 = fsum;
        }
        System.out.println("Число Фибоначчи для " + N + " равно " + fsum);

        System.out.println("Задание 3.6. Заполните массив случайным числами и отсортируйте его. Используйте сортировку слиянием.");
        System.out.println("Введите размер массива:");
        num = input.nextInt();

        int[] array6 = new int[num];
        for (int i = 0; i < array6.length; i++){
            array6[i] = (int)(Math.random()*13);
        }
        System.out.println("Массив array6: " + Arrays.toString(array6));

        int[] result = mergesort(array6);
        System.out.println("Результат сортировки массива: " + Arrays.toString(result));

        System.out.println("Задание на лекции.");

        System.out.println("Введите число, которое надо найти: ");
        item = input.nextInt();
        for (counter = 0; counter < num; counter++) {
            if (array[counter] == item) {
                System.out.println(item + "является " + (counter + 1) + " по счету в массиве");
                int[] arr = removeTheElement(array, counter);
                System.out.println("Новый массив: " + Arrays.toString(arr));
                for (counter = 0; counter < num -1; counter++) {
                    if (arr[counter] == item) {
                        System.out.println(item + "является " + (counter + 1) + " по счету в массиве");
                        int[] arr1 = removeTheElement(arr, counter);
                        System.out.println("Новый массив: " + Arrays.toString(arr1));
                    }

                }
                break;
            }
            if (counter == num) {
                System.out.println("Число " + item + " не найдено в массиве");
            }

        }
    }
    public static int[] removeTheElement(int[] arr,  int index)
    {
       if(arr == null ||  index < 0 || index >= arr.length) {
           return arr;
       }
       int[] anotherArray = new int[arr.length - 1];
       for (int i = 0, k = 0; i < arr.length; i++) {
           if(i == index) {
               continue;
           }
           anotherArray[k++] = arr[i];
       }
       return anotherArray;
    }
    public static void changeFLElement(int[] arr)
    {
            int first = arr[0];
            int last = arr[arr.length-1];
            arr[0] = last;
            arr[arr.length-1] = first;

    }
    public static int uniqFirst(int[] array)
    {
        int i = 0;
        int uniq = array[i];
        int count = 0;
        for(i = 0; i < array.length; )
        {
            for (int j : array) {
                if (uniq == j) {
                    count++;
                }
            }
            if (count == 1) {
                return uniq;
            } else {
                i++;
                if(i == array.length){
                    break;
                }
                uniq = array[i];
                count = 0;
            }

        }
        uniq = -1;
        return uniq;
    }


    public static int[] mergesort(int[] array1) {
        int[] buffer1 = Arrays.copyOf(array1, array1.length);
        int[] buffer2 = new int[array1.length];
        int[] result = mergesortInner(buffer1, buffer2, 0, array1.length);
        return result;
    }
    public static int[] mergesortInner(int[] buffer1, int[] buffer2,
                                       int startIndex, int endIndex) {
        if (startIndex >= endIndex - 1) {
            return buffer1;
        }

        int middle = startIndex + (endIndex - startIndex) / 2;
        int[] sorted1 = mergesortInner(buffer1, buffer2, startIndex, middle);
        int[] sorted2 = mergesortInner(buffer1, buffer2, middle, endIndex);

        int index1 = startIndex;
        int index2 = middle;
        int destIndex = startIndex;
        int[] result = sorted1 == buffer1 ? buffer2 : buffer1;
        while (index1 < middle && index2 < endIndex) {
            result[destIndex++] = sorted1[index1] < sorted2[index2]
                    ? sorted1[index1++] : sorted2[index2++];
        }
        while (index1 < middle) {
            result[destIndex++] = sorted1[index1++];
        }
        while (index2 < endIndex) {
            result[destIndex++] = sorted2[index2++];
        }
        return result;
    }

}
