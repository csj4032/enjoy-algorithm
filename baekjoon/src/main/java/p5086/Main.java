package p5086;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        while (true) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            if (a == 0 && b == 0) break;
            if (a < b) {
                if (b % a == 0 || a == 1) {
                    sb.append("factor").append("\n");
                } else {
                    sb.append("neither").append("\n");
                }
            } else {
                if (a % b == 0 || b == 1) {
                    sb.append("multiple").append("\n");
                } else {
                    sb.append("neither").append("\n");
                }
            }
        }
        System.out.println(sb.toString());
    }
}
