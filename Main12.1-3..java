package com.company;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {

        try(FileWriter writer = new FileWriter("file.txt", false))
        {
            String text = "Hello Gold, Hello silver, hello World.";
            writer.write(text);
            writer.flush();
            }
            catch(IOException ex)
            {
                System.out.println(ex.getMessage());
            }
        String sp = Files.readString(Path.of("file.txt"));
        String sp1 = sp.replaceAll("\\p{Punct}", "");
        String[] vo = sp1.split(" ");
        System.out.println(Arrays.toString(vo));

        Map<String, Integer> m=new HashMap<String,Integer>();
        for(String s: vo) {
            if(m.containsKey(s)) {
                m.put(s, m.get(s) + 1);
            }
            else {
                m.put(s, 1);
            }
        }
        m.remove(" ");
        System.out.println(m);

        List col =  new ArrayList();
        col = Arrays.asList(vo);
        HashSet nd = nonDuplicate(col);
        System.out.println(nd);

        ArrayList a = new ArrayList();
        LinkedList b = new LinkedList();
        addList(1000000, a, b);
        Date startArray = new Date();
        choiceList(a);
        Date finishArray = new Date();
        long ArrayTime = finishArray.getTime() - startArray.getTime();
        System.out.println("Time of ArrayList is " + ArrayTime + ".");

        Date startLinked = new Date();
        choiceLinked(b);
        Date finishLinked = new Date();
        long LinkedTime = finishLinked.getTime() - startLinked.getTime();
        System.out.println("Time of LinkedList is " + LinkedTime + ".");
    }
    public static HashSet nonDuplicate(List col){
        HashSet<String> h = new HashSet<String>();
        h.addAll(col);
        return h;
    }
    public static void addList(long k, ArrayList a, LinkedList b) {
        for (int i = 0; i < k; i++) {
            a.add(i);
            b.add(i);
        }
    }
    public static void choiceList(ArrayList a) {

        for (int j = 0; j < 100000; j++) {
            int i = (int) Math.ceil(Math.random() * 999999);
            a.get(i);
        }
    }
    public static void choiceLinked(LinkedList b) {

        for (int j = 0; j < 100000; j++) {
            int i = (int) Math.ceil(Math.random() * 999999);
            b.get(i);
        }
    }
}


