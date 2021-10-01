package com.company;

import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MainFinal {
    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        System.out.println("Input n-Threads: ");
        String nt =  scn.next();
        System.out.println("Threads are: " + nt);
        ExecutorService executor = Executors.newFixedThreadPool(Integer.parseInt(nt));
        Parser parser = new Parser();
        List<String> list = parser.parse("C:\\Users\\DnsUser\\IdeaProjects\\Final\\src\\com\\company\\list.txt");
        System.out.println(list);
        parser.mapping(list);
        Map<String, List<String>> mapURL = parser.map;
        System.out.println("The HashMap has " + mapURL.size() + " element(s).");
        System.out.println("processor available: " + Runtime.getRuntime().availableProcessors());
        long start = System.currentTimeMillis();
        mapURL.forEach((key, value) -> {
            executor.submit(new Download(key, value, "C:\\Users\\DnsUser\\IdeaProjects\\Final\\out\\production\\Final\\com\\company"));
        });
        executor.shutdown();
        try {
            executor.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long time = System.currentTimeMillis() - start;
        SimpleDateFormat sdf = new SimpleDateFormat("mm' minutes 'ss");
        System.out.println();
        FileSize fs = new FileSize();
        System.out.println("Finish: 100%");
        System.out.printf("Loading: " + mapURL.size() + " files, %.1f MB\n", (fs.getSizeAll() / 1024));
        System.out.println("Time: " + sdf.format(time) + " seconds");
        System.out.printf("Average dynamic: %.1f kB/s\n", ((fs.getSizeAll() * 1024) / time));
    }
}
class Download extends Thread {

    String url;
    List<String> outFiles;
    private String pack;
    public Download(String url, List<String> outFiles, String args){
        this.url = url;
        this.outFiles = outFiles;
        this.pack = args + "/";
    }
    public void run(){
        System.out.println("Starting: " + Thread.currentThread().getId());
        System.out.println("Download: " + outFiles.get(0));
        System.out.println();
        File folder = new File(pack);
        if (!folder.exists()){
            folder.mkdirs();
        }
        long startFile = System.currentTimeMillis();
        try {
            URL urlConnect = new URL(url);
            byte[] buffer = new byte[1024];
            int count = 0;
            BufferedInputStream bis = new BufferedInputStream(urlConnect.openStream());
            FileOutputStream fos = new FileOutputStream(pack + outFiles.get(0));
            while ((count = bis.read(buffer, 0, 1024)) != -1) {
                fos.write(buffer, 0, count);
            }
            fos.close();
            bis.close();
            if (outFiles.size() != 0 || outFiles.size() != 1) {
                for (int i = 1; i < outFiles.size(); i++){
                    File source = new File(pack + outFiles.get(0));
                    File dest = new File(pack + outFiles.get(i));
                    Files.copy(source.toPath(), dest.toPath());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Completed: " + Thread.currentThread().getId());
        long timeFile = System.currentTimeMillis() - startFile;
        SimpleDateFormat sdfFile = new SimpleDateFormat("mm");
        double size = 0;
        File file = new File(pack + outFiles.get(0));
        if (file.exists()){
            size = (double) ((file.length() / 1024) * outFiles.size());
            if (size < 1024) {
                System.out.println("File size kB: " + size);
                System.out.println("File " + outFiles.get(0) + "download: " + size + " kB" + " for " + sdfFile.format(timeFile) + " minutes");
                System.out.println();
            } else {
                System.out.printf("File size MB: %.1f\n", (size / 1024));
                System.out.printf("File " + outFiles.get(0) + " download: %.1f  MB" + " for " + sdfFile.format(timeFile) + " minute\n", (size / 1024));
                System.out.println();
            }
            FileSize.setSizeAll(size);
        }
        System.out.println();
    }
}
class FileSize {
    private static double sizeAll = 0;
    public double getSizeAll() {
        return sizeAll;
    }
    public static void setSizeAll(double size) {
        sizeAll += size;
    }
}
class Parser {
    Map<String, List<String>> map = new HashMap<>();
    public List<String> parse(String textFile){
        List<String> list = new ArrayList<>();
        try {
            File file = new File(textFile);
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            while (line != null){
                list.add(line);
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
    public void mapping(List<String> list){
        for (int i = 0; i < list.size(); i++) {
            String[] str = list.get(i).split(" ");
            if (!map.containsKey(str[0])){
                map.put(str[0], new ArrayList<>());
            }
            map.get(str[0]).add(str[1]);
        }
        map.forEach((key, value) -> {
            System.out.println(key + " == " + value);
        });
    }
}