package p1252;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 제목 : 이진수 덧셈
 * 링크 : https://www.acmicpc.net/problem/1252
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        String a = st.nextToken();
        String b = st.nextToken();

        int max = Math.max(a.length(), b.length());

        char[] c1 = new char[max];
        char[] c2 = new char[max];

        Arrays.fill(c1, '0');
        Arrays.fill(c2, '0');

        for (int i = (max - a.length()); i < max; i++) c1[i] = a.charAt(i - (max - a.length()));
        for (int i = (max - b.length()); i < max; i++) c2[i] = b.charAt(i - (max - b.length()));

        char k1 = '0';
        StringBuilder sb = new StringBuilder();
        for (int i = max - 1; i >= 0; i--) {
            Integer q = Integer.valueOf(c1[i]) - 48;
            Integer p = Integer.valueOf(c2[i]) - 48;
            Integer k = Integer.valueOf(k1) - 48;

            if ((q + p + k) == 3) {
                k1 = '1';
                sb.insert(0, "1");
                if (i == 0) sb.insert(0, "1");
            } else if ((q + p + k) == 2) {
                k1 = '1';
                sb.insert(0, "0");
                if (i == 0) sb.insert(0, "1");
            } else if ((q + p + k) == 1) {
                k1 = '0';
                sb.insert(0, "1");
            } else if ((q + p + k) == 0) {
                k1 = '0';
                sb.insert(0, "0");
            }
        }
        if (sb.indexOf("1") == 0) {
            System.out.println(sb.toString());
        } else if (sb.indexOf("1") == -1) {
            System.out.println(0);
        } else {
            int idx = sb.indexOf("1");
            System.out.println(sb.toString().substring(idx));
        }
    }

    private static String toBinaryString(BigDecimal decimal) {
        StringBuilder sb = new StringBuilder();
        BigDecimal two = new BigDecimal(2);
        while (true) {
            sb.insert(0, decimal.remainder(two));
            if (decimal.compareTo(BigDecimal.ONE) == 0) break;
            decimal = decimal.divide(two);
        }
        return sb.toString();
    }

    private static BigDecimal parseDecimal(String binary) {
        BigDecimal bit = new BigDecimal(2);
        BigDecimal sum = BigDecimal.ZERO;
        int idx = binary.length() - 1;
        for (int i = 0; i < binary.length(); i++) {
            if (binary.charAt(idx - i) == '1') {
                sum = sum.add(bit.pow(i));
            }
        }
        return sum;
    }
}
