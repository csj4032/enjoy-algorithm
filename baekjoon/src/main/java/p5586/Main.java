package p5586;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String l = sc.next();

        int joi = 0;
        int ioi = 0;

        for (int i = 1; i < l.length() - 1; i++) {
            if (l.charAt(i) == 'O') {
                char p = l.charAt(i - 1);
                char n = l.charAt(i + 1);

                if (p == 'J' && n == 'I') {
                    joi++;
                } else if (p == 'I' && n == 'I') {
                    ioi++;
                }
            }
        }

        System.out.println(joi);
        System.out.println(ioi);
    }
}
