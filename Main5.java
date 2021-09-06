package com.company;

import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args) throws IOException {
	Vector3d exam = new Vector3d();
	exam.x = 5;
	exam.y = 7;
	exam.y =9;
	Vector3d ex2 = new Vector3d();
	ex2.x = 15;
	ex2.y = 17;
	ex2.y = 19;
	Vector3d.Dlina(exam.x, exam.y, exam.z);
	Vector3d.Scal(exam.x, ex2.x, exam.y, ex2.y, exam.z, ex2.z);
	Vector3d.Vecpro(exam.x, ex2.x, exam.y, ex2.y, exam.z, ex2.z);
	Vector3d.Cosvec(exam.x, ex2.x, exam.y, ex2.y, exam.z, ex2.z);
	Vector3d.SumVect(exam.x, ex2.x, exam.y, ex2.y, exam.z, ex2.z);
	Vector3d.DifVect(exam.x, ex2.x, exam.y, ex2.y, exam.z, ex2.z);

	System.out.println("Введите число N интовое!");
	int N = System.in.read();
	System.out.println(Arrays.toString(Vector3d.NarrayVect(N)));
    }
}
class Vector3d {
    int x, y, z;
    Vector3d(){
        x = this.x;
        y = this.y;
        z = this.z;
            }
    public static double Dlina(int x, int y, int z){
        double dl = Math.sqrt(x*x + y*y + z*z);
        System.out.println("Длина вектора равна " + dl);
        return dl;
    }
    public static double Scal(int x1, int x2, int y1, int y2, int z1, int z2){
        double scal = x1*x2 + y1*y2 + z1*z2;
        System.out.println("Скалярное произведение векторов равно " + scal);
        return scal;
    }
    public static void Vecpro(int x1, int x2, int y1, int y2, int z1, int z2){
        double vp1 = y1*z2 - z1*y2;
        double vp2 = z1*x2 - x1*z2;
        double vp3 = x1*y2 - y1*x2;
        System.out.println("Векторное произведение равно " + vp1 + ", " + vp2 + ", " + vp3);

    }
    public static void Cosvec(int x1, int x2, int y1, int y2, int z1, int z2){
        double cos = Vector3d.Scal(x1, x2, y1, y2, z1, z2) / (Vector3d.Dlina(x1, y1, z1) * Vector3d.Dlina(x2, y2, z2));
        System.out.println("Косинус между векторами равен " + cos);

    }
    public static void SumVect(int x1, int x2, int y1, int y2, int z1, int z2){
        double sumv1 = x1 + x2;
        double sumv2 = y1 + y2;
        double sumv3 = z2 + z2;
        System.out.println("Сумма векторов равна " + sumv1 + ", " + sumv2 + ", " + sumv3);
    }
    public static void DifVect(int x1, int x2, int y1, int y2, int z1, int z2){
        double sumv1 = x1 - x2;
        double sumv2 = y1 - y2;
        double sumv3 = z2 - z2;
        System.out.println("Разница векторов равна " + sumv1 + ", " + sumv2 + ", " + sumv3);
    }
    public static double [] NarrayVect (int N){
        double[] arr = new double[9];
        int j = 0;
        for(int i = 0; i <3; i++ ){

            double cos1 = Math.random();
            double cos2 = Math.random();
            double sin1 = Math.sqrt(1- cos1*cos1);
            double sin2 = Math.sqrt(1 - cos2*cos2);
            arr[j] = N * cos1*cos2);
            arr[j+1] = N * cos1* sin2;
            arr[j+2] = N * sin1;
            j = j +3;

        }


      return arr;
    }
}