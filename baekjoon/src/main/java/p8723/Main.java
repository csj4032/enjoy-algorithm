package p8723;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        double a2 = Math.pow(a, 2);
        double b2 = Math.pow(b, 2);
        double c2 = Math.pow(c, 2);

        if (a == b && b == c) {
            System.out.println(2);
        } else if (a2 + b2 == c2 || a2 + c2 == b2 || b2 + c2 == a2) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}
