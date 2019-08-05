package p16503;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        String b = sc.next();
        int c = sc.nextInt();
        String d = sc.next();
        int e = sc.nextInt();
        int c1 = calculate(calculate(a, b, c), d, e);
        int c2 = calculate(a, b, calculate(c, d, e));
        System.out.println(c1 >= c2 ? c2 : c1);
        System.out.println(c1 >= c2 ? c1 : c2);
    }

    private static int calculate(int a, String b, int c) {
        if (b.equals("+")) return a + c;
        if (b.equals("-")) return a - c;
        if (b.equals("*")) return a * c;
        return a / c;
    }
}