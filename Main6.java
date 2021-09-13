package com.company;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) throws IOException {

	    String tx = "Изучение Java - это просто!";
        Study text = new Study(tx);
        System.out.println(text.printCourse());
        Machine one = new Machine();
        Machine two = new Machine();
        one.color = "black";
        one.name = "sany";
        one.weigth = 25;
        two.color = "white";
        two.name = "tractor";
        two.weigth = 3546;
        Machine.printDates(one.color, one.name, one.weigth);
        Machine.printDates(two.color, two.name, two.weigth);
        Dom house1 = new Dom();
        Dom house2 = new Dom();
        Dom.setDates(house1);
        Dom.printDates(house1.name, house1.floors, house1.year);
        Dom.setDates(house2);
        Dom.printDates(house2.name, house2.floors, house2.year);
        Tree old = new Tree(1000, "Patria");
        System.out.println("First tree is " + old.name + ", " + "age is " + old.age + " years!");
        Tree modern = new Tree(55,true, "Baobab");
        System.out.println("Second tree is " + modern.name + ", " + "age is " + modern.age + ", " + "life is " + modern.life + " !" );
        Tree mistic = new Tree();
        System.out.println("Mistic tree");
    }
}
class Study {

    private String course;
    public Study(String text)
    {
        course = text;
    }


    public String printCourse() {
        return this.course;
    }
}

class Machine {
    String color;
    String name;
    int weigth;
    Machine(String color1){
        color = color1;
    }
    Machine(String color1, int weigth1 ){
        color = color1;
        weigth = weigth1;
    }
    Machine(){

    }
    public static void printDates(String color, String name, int weigth){
        System.out.println("Machine name is " + name + ", " + "color is " + color + ", " + "weigth is " + weigth + " kg.");
    }
}
class Dom{
    int floors;
    int year;
    String name;

    public static void setDates(Dom ob) throws IOException {
        Scanner console = new Scanner(System.in);
        System.out.println("Input name of dom! ");
        ob.name = console.next();
        System.out.println("Input quantity of floors! ");
        ob.floors = console.nextInt();
        System.out.println("Input year of building! ");
        ob.year = console.nextInt();

    }
    public static void printDates(String name1, int floors1, int year1){
        System.out.println("Dom name is " + name1 + ", " + "Quantities of floors are " + floors1 + ", " + " Year of building is " + year1 + ".");
    }
    public static void ageDom(int nowyear, int year1){
        System.out.println("Age of dom is " + (nowyear - year1) + " years.");
    }
}
class Tree{
    int age;
    boolean life;
    String name;
    Tree(int age1, String name1){
        age = age1;
        name = name1;
    }
    Tree(int age1, boolean life1, String name1){
        age = age1;
        life = life1;
        name = name1;
    }
    Tree(){
        System.out.println("Empty constructor of parameters worked!");
    }
}