package p2864;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();

        String a1 = a.replaceAll("6", "5");
        String b1 = b.replaceAll("6", "5");

        int min = Integer.valueOf(a1) + Integer.valueOf(b1);

        String a2 = a.replaceAll("5", "6");
        String b2 = b.replaceAll("5", "6");

        int max = Integer.valueOf(a2) + Integer.valueOf(b2);

        System.out.print(min + " " + max);
    }
}