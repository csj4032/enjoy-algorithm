package p1764;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 제목 : 듣보잡
 * 링크 : https://www.acmicpc.net/problem/1764
 * 분류 : 문자열 처리, 구현
 */
public class Main {

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Object[] p = new Object[n];
        List<String> q = new ArrayList<>(m);

        for (int i = 0; i < n; i++) p[i] = br.readLine();

        Arrays.sort(p);

        for (int i = 0; i < m; i++) {
            String s = br.readLine();
            if (Arrays.binarySearch(p, s) >= 0) q.add(s);
        }

        q.sort(Comparator.naturalOrder());
        sb.append(q.size()).append("\n");
        for (int i = 0; i < q.size(); i++) {
            sb.append(q.get(i)).append("\n");
        }
        System.out.println(sb.toString());
    }
}
