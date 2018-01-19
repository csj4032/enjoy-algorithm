package p11006;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            int t1 = sc.nextInt();
            int t2 = sc.nextInt();

            int t3 = t2 * 2 - t1;
            int t4 = t2 - t3;

            System.out.println(t3 + " " + t4);
        }
    }
}
