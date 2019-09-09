package p5026;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            String s = sc.next();
            if (s.equals("P=NP")) {
                sb.append("skipped").append("\n");
            } else {
                String[] ss = s.split("\\+");
                sb.append(Integer.parseInt(ss[0]) + Integer.parseInt(ss[1])).append("\n");
            }
        }
        System.out.println(sb.toString());
    }
}
