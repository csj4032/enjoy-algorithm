package p1722;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int t = sc.nextInt();
        int[] m = new int[n];

        if (t == 1) {
            for (int i = 1; i <= n; i++) m[i - 1] = i;
        } else {
            for (int i = 0; i < n; i++) m[i] = sc.nextInt();
        }

        System.out.println(Arrays.toString(m));
    }
}


// 1 2 3 4 5
// 1 2 3 5 4
// 1 2 4 3 5
// 1 2 4 5 3