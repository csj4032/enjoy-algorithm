package p2909;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int c = sc.nextInt();
        int k = sc.nextInt();
        double d = Math.pow(10, k);
        int f = (int) (Math.round(c / d) * d);
        System.out.println(f);
    }
}