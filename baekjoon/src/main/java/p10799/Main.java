package p10799;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

/**
 * 제목 : 쇠막대기 성공
 * 링크 : https://www.acmicpc.net/problem/10799
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] n = br.readLine().trim().split("");
        int m = 0;
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < n.length; i++) {
            String s = n[i];
            if (s.equals("(")) {
                stack.push(s);
            } else {
                if (stack.peek().equals("(")) {
                    stack.pop();
                    stack.push("*");
                } else {
                    stack.push(")");
                }
            }
        }

        int[] c = new int[100000];
        Arrays.fill(c, 1);
        int d = 0;
        for (int i = 0; i < stack.size(); i++) {
            if (stack.get(i).equals("(")) {
                d++;
            } else if (stack.get(i).equals(")")) {
                d--;
                m += c[d];
                c[d] = 1;
            } else if (stack.get(i).equals("*")) {
                for (int j = 0; j < d; j++) {
                    c[j] = c[j] + 1;
                }
            }
        }
        System.out.println(m);
    }
}