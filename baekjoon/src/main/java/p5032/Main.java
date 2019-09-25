package p5032;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int e = sc.nextInt();
        int f = sc.nextInt();
        int c = sc.nextInt();

        int k = e + f;
        int t = 0;
        while (k >= c) {
            t += k / c;
            k = (k / c) + (k % c);
        }
        System.out.println(t);
    }
}
