package p5533;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m[][] = new int[n][3];
        int m2[][] = new int[3][n];
        int m3[][] = new int[n][3];

        for (int i = 0; i < n; i++) {
            m[i][0] = sc.nextInt();
            m[i][1] = sc.nextInt();
            m[i][2] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                m2[j][i] = m[i][j];
            }
        }

        System.out.println(Arrays.deepToString(m));
        System.out.println(Arrays.deepToString(m2));

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < n; j++) {
                int t = m2[i][j];
                boolean f = true;
                for (int k = 0; k < n; k++) {
                    if (j != k && m2[i][k] == t) {
                        f = false;
                        break;
                    }
                }
                if (f) {
                    m3[j][i] = t;
                } else {
                    m3[j][i] = 0;
                }
            }
        }
       // System.out.println(Arrays.deepToString(m3));

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int s = 0;
            for (int j = 0; j < 3; j++) {
                s += m3[i][j];
            }
            sb.append(s).append("\n");
        }

        System.out.println(sb.toString());
    }
}
