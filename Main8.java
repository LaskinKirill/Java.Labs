package com.company;

public class Main {

    public static void main(String[] args) {
	Client deb = new Client("Ivan", "Kolt", "UBS bank" );
	Banker cus = new Banker("Gans", "Bush", "UBS bank");
	deb.outputInfo("Ivan", "Kolt");
	cus.outputInfo("Gans", "Bush");
	deb.write();
	cus.write();
    }
}
abstract class Human implements Writeble{
    String name;
    String surname;
    public static String getName(String name1){
        String name = name1;
        return name;
    }
    public static String getSurname(String surname1){
        String surname = surname1;
        return surname;
    }
    public abstract void outputInfo(String name, String surname);
    Human(String name, String surname){
        this.name = name;
        this.surname = surname;
    }
}
 class  Client extends Human{
    String bankn;
    public Client (String name, String surname, String bankn){
        super(name, surname);
        this.bankn = bankn;

    }
    @Override
    public void write() {
        System.out.println("Write date of Client to database!");
    }
    @Override
    public void outputInfo(String name, String surname){
        System.out.println("Name of Client is " + name + ", " + "surname of Client is " + surname + "." + " Name of bank is " + bankn + ".");
    }
}

class Banker extends Human{
    String bankn;
    public Banker (String name, String surname, String bankn){
        super(name, surname);
        this.bankn = bankn;

    }
    @Override
    public  void outputInfo(String name, String surname){
        System.out.println("Name of Client is " + name + ", " + "surname of Client is " + surname + "." + " Name of bank is " + bankn + ".");
    }

    @Override
    public void write() {
        System.out.println("Write date of Banker to database!");
    }
}
interface Writeble{
    public void write();
}