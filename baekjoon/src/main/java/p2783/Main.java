package p2783;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        float k = 1000f;
        float x = sc.nextInt();
        float y = sc.nextInt();
        float t = (k / y) * x;
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            float x1 = sc.nextFloat();
            float y1 = sc.nextFloat();
            float c = k / y1;
            if (t > c * x1) {
                t = c * x1;
            }
        }

        System.out.printf("%.2f", t);
    }
}
