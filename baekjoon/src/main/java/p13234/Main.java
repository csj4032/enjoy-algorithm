package p13234;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean a = sc.nextBoolean();
        String op = sc.next();
        boolean b = sc.nextBoolean();

        if (op.equals("AND")) {
            System.out.println(a && b);
        }

        if (op.equals("OR")) {
            System.out.println(a || b);
        }
    }
}
