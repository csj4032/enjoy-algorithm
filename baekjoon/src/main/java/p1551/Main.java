package p1551;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int q = 0;
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] m = new int[n];
        st = new StringTokenizer(br.readLine(), ",");

        while (st.hasMoreTokens()) m[q++] = Integer.parseInt(st.nextToken());

        while (k > 0) {
            int[] t = new int[--n];
            for (int i = 0; i < --n; i++) {
                t[i] = m[i+1] - m[i];
            }
            m = new int[t.length];
            for (int i = 0; i < m.length; i++) {
                m[i] = t[i];
            }
            k--;
        }
        String result = Arrays.stream(m).mapToObj(String::valueOf).collect(Collectors.joining(","));
        System.out.println(result);
    }
}