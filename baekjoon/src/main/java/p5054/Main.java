package p5054;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int m[] = new int[n];
            for (int j = 0; j < n; j++) {
                m[j] = sc.nextInt();
            }
            Arrays.sort(m);
            int sum = 0;
            for (int j = 1; j < n; j++) sum += (m[j] - m[j - 1]);
            System.out.println(sum + (m[n - 1] - m[0]));
        }
    }
}
