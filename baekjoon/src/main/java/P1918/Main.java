package P1918;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        char[] a = s.toCharArray();
        Deque<String> b = new LinkedList<>();
        for (int i = 0; i < a.length; i++) {
            if (a[i] == '(') {
                continue;
            } else if (65 <= a[i] && a[i] <= 90) {
                System.out.print(a[i]);
            } else if (a[i] == ')') {
                while (!b.isEmpty()) {
                    System.out.print(b.peek());
                    b.pop();
                }
            } else {
                while (!b.isEmpty()) {
                    System.out.print(b.peek());
                    b.pop();
                }
                b.push(String.valueOf(a[i]));
            }
        }
        while (!b.isEmpty()) {
            System.out.print(b.peek());
            b.pop();
        }
    }
}
//(A+(B*C))-(D/E)
//(A+B-C)*D*E