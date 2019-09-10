package p13216;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String score = sc.next();
        int a = 0;
        int b = 0;
        int p = 0;
        int q = 0;
        for (int i = 0; i < score.length(); i++) {
            if (score.charAt(i) == 'A') {
                p++;
            } else {
                q++;
            }
            if (p == 21 || q == 21) {
                System.out.println(p + "-" + q);
                if (p > q) {
                    a++;
                } else {
                    b++;
                }
                p = 0;
                q = 0;
            }
        }
        System.out.println(a > b ? "A" : "B");
    }
}
