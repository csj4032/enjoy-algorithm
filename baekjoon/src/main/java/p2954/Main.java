package p2954;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 제목 : 창영이의 일기장
 * 링크 : https://www.acmicpc.net/problem/2954
 */
public class Main {

    private static Map<Character, Character> m = new HashMap<>();
    private static char[] c = new char[10000001];

    static {
        m.put('a', 'a');
        m.put('e', 'e');
        m.put('i', 'i');
        m.put('o', 'o');
        m.put('u', 'u');
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String s = br.readLine();
        Arrays.fill(c, '*');

        for (int i = 0; i < s.length(); i++) c[i] = s.charAt(i);

        for (int i = 1; i < s.length(); i++) {
            if (c[i] == 'p') {
                if (m.containsKey(c[i - 1]) && m.containsKey(c[i + 1]) && c[i - 1] == c[i + 1]) {
                    c[i] = '*' ;
                    c[i + 1] = '*' ;
                }
            }
        }

        for (int i = 0; i < c.length; i++) {
            if (c[i] != '*') sb.append(c[i]);
        }

        System.out.println(sb.toString());
    }
}