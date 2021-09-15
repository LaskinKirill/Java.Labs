package com.company;

public class Main {

    public static void main(String[] args) {
        Junior ob = new Junior();
        ob.nat = 11;
        Junior.outPut(ob.nat);
        ob.age = 33;
        System.out.println("Age of human is " + Major.getInfo(ob.age) + " years.");
        ob.name = "Kir";
        System.out.println("Name of human is " + Junior.getInfo(ob.name) +".");
        Aircraft.Wing obj = new Aircraft.Wing();
        obj.ww = 1000;
        System.out.println("Weight of wing is " + obj.ww + " kg.");
        Aircraft.Wing obj2 = new Aircraft.Wing();
        obj2.ww = 2000;
        System.out.println("Weight of second wing is " + obj2.ww + " kg.");
    }
}
class Car {
    public int weight;
    public String model;
    public char color;
    public float speed;


    public void outPut () {
        System.out.println("Вес " + model + " составляет " + weight + "кг.");
        System.out.println("Цвет машины - " + color + " и её скорость - " + speed);
    }

    public Car (int w, String m, char c, float s) {
        weight = w;
        model = m;
        color = c;
        speed = s;
    }

    public Car () {}
}
class Truck extends Car {
    int quanwheels;
    int maxweight;

    Truck() {
        System.out.println("This is empty constructor.");
    }

    Truck(int nqw, int mw, int wt, String mod, char col, float sp) {
        this.quanwheels = nqw;
        this.maxweight = mw;
        this.color = col;
        this.model = mod;
        this.speed = sp;
        this.weight = wt;
    }

    public static void newWheels(int qw) {
        Truck nqw = new Truck();
        nqw.quanwheels = qw;
        System.out.println("New quantity of wheels are " + qw + " units.");
    }
}
class Major
{
    int nat;
    String name;
    int age;
    public  static int getInfo(int age1)
    {
       int age = age1;
      return age;
    }
}
class Junior extends Major
{
     public static void outPut(int nat) {
         System.out.println("Output from Major int is " + nat +".");
     }
     public static String getInfo(String name1){
         String name = name1;
         return name;
     }
}
class Aircraft{
    static class Wing{
        int ww;
        public static int showWwing(int ww1){
            int ww = ww1;
            return ww;
        }
    }
}



