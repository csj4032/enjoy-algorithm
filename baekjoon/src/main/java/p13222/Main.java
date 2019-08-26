package p13222;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int w = sc.nextInt();
        int h = sc.nextInt();

        for (int i = 0; i < n; i++) {
            double k = Math.sqrt(Math.pow(w, 2) + Math.pow(h, 2));
            int t = sc.nextInt();
            if (t <= h || t <= w || t <= k) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}