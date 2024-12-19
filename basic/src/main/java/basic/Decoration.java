package basic;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Vector;

public class Decoration {
    public static void main(String[] args) {
        solution2(new int[]{12345}, 10);
        Vector<String> vector = new Vector<>();
    }

    private static int solution(int[] A) {
        int index = 0, count = 0;
        do {
            index = A[index];
            count++;
        } while (index != -1);
        return count;
    }

    private static void solution2(int[] A, int K) {
        int space = String.valueOf(Arrays.stream(A).max().getAsInt()).length();
        int len = A.length;
        decoration(space, (Math.min(K, len)));
        for (int i = 0; i < len; i++) {
            boolean next = (i + 1) % K == 0;
            boolean isLast = i == (len - 1);
            System.out.print(white(space, A[i]) + A[i] + ((next || isLast) ? "|" : ""));
            if (next) {
                System.out.println();
                decoration(space, K);
            }
        }
        if (len % K != 0) {
            System.out.println();
            decoration(space, (len) % K);
        }
    }

    private static String white(int space, int number) {
        StringBuilder sb = new StringBuilder();
        sb.append("|");
        sb.append(" ".repeat(Math.max(0, space - String.valueOf(number).length())));
        return sb.toString();
    }

    private static void decoration(int space, int k) {
        StringBuilder sb = new StringBuilder("+");
        sb.append("-".repeat(Math.max(0, space)));
        for (int i = 0; i < k; i++) {
            System.out.print(sb.toString());
        }
        System.out.println("+");
    }

    private static int solution3(String S) {
        return Arrays.stream(S.split("[0-9]+"))
                .filter(s -> s.matches(".*[A-Z].*"))
                .map(String::length)
                .max(Comparator.comparing(Integer::valueOf))
                .orElse(-1);
    }
}