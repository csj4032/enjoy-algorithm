package p4766;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int f = (int) (Double.valueOf(sc.nextDouble()) * 100);
        while (true) {
            String d = sc.next();
            int l = (int) (Double.valueOf(d) * 100);
            if (d.equals("999")) break;
            sb.append(String.format("%.2f", (double) (l - f) / 100));
            sb.append("\n");
            f = l;
        }
        System.out.println(sb.toString());
    }
}
