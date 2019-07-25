package p17356;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double A = sc.nextDouble();
        double B = sc.nextDouble();
        double M = (B - A) / 400;
        double D = Math.pow(10, M);
        System.out.println(1/(1+D));
    }
}
