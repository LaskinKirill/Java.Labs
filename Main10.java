package com.company;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        Path path = Path.of("c:\\readme.txt");
        readFile(path);
        String str = "Test";
        writeString(str);
        Path path1 = Path.of("c:\\readme1.txt");
        fileJoin(path, path1);
        byte[] fcopy = arrBite(path1);
        new File("c:\\Directory").mkdir();
        ArrayList<String> np = returnNames(path, "day");
        System.out.println(Arrays.toString(np.toArray()));
        ArrayList<String> txt = returnNamtxt(path1, "Das");
        System.out.println(Arrays.toString(txt.toArray()));

    }
    public static void readFile(Path path) throws IOException {

        List<String> list = Files.readAllLines(path);
        for (String str : list)
            System.out.println(str);
    }
    public static void writeString(String str){

    }
    public static void fileJoin(Path path1, Path path2) throws IOException {
        List<String> list1 =  Files.readAllLines(path1);
        List<String> list2 = Files.readAllLines(path2);
        for (String str : list1){
            writeString(str);
        }
        for (String str : list2){
            writeString(str);
        }
    }
    public static byte[] arrBite(Path path) throws IOException {

        byte [] bt = Files.readAllBytes(path);
        return bt;
    }
    public static ArrayList<String> returnNames(Path path, String str){
        File folder = new File(String.valueOf(path));
        File[] sp = folder.listFiles();
        ArrayList<String> nm = new ArrayList<>();
        for (File fn:sp) {
            String name = fn.getName();
                if(name.contains(str)){
                    nm.add(name);
                }
        }

        return nm;
    }
    public static ArrayList<String> returnNamtxt(Path path, String str){
        File folder = new File(String.valueOf(path));
        File[] sp = folder.listFiles();
        ArrayList<String> nm = new ArrayList<>();
        ArrayList<String> txt = new ArrayList<>();
        for (File fn:sp) {
            String name = fn.getName();
            if(name.contains(str)){
                nm.add(name);
            }
        }
        for (String n : nm){
            if (nm.contains(".txt")){
                txt.add(n);
            }
        }

        return txt;
    }
}
