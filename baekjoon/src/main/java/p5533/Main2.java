package p5533;

import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m[][] = new int[n][3];
        int r[] = new int[n];

        for (int i = 0; i < n * 3; i++) m[i / 3][i % 3] = sc.nextInt();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < n; j++) {
                boolean f = true;
                for (int k = 0; k < n; k++) {
                    if (j != k && m[k][i] == m[j][i]) {
                        f = false;
                        break;
                    }
                }
                if (f) r[j] += m[j][i];
            }
        }

        for (int i = 0; i < n; i++) System.out.println(r[i]);
    }
}
