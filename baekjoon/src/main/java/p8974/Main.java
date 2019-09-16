package p8974;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] k = new int[100001];
        int s = 0;
        for (int i = 0; i <= 200; i++) {
            for (int j = s; j <= i + s; j++) {
                k[j] = i;
            }
            s += i;
        }
        int a = sc.nextInt() - 1;
        int b = sc.nextInt();
        int t = 0;
        for (int i = a; i < b; i++) {
            t += k[i];
        }
        System.out.println(t);
    }
}
