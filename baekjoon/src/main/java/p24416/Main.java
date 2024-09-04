package p24416;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] fn = new int[n + 1];
        fn[1] = fn[2] = 1;
        for (int i = 3; i <= n; i++) fn[i] = fn[i - 1] + fn[i - 2];
        System.out.println(fn[n]);
        System.out.println(n - 2);
    }
}