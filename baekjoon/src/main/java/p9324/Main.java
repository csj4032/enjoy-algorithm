package p9324;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int[] k = new int[26];
            boolean b = true;
            String m = br.readLine();
            for (int j = 0; j < m.length(); j++) {
                int t = m.charAt(j) - 65;
                k[t] = (k[t] + 1) % 4;
            }

            for (int h = 0; h < 26; h++) {
                if (k[h] == 3) {
                    b = false;
                    break;
                }
            }

            //System.out.println(Arrays.toString(k));

            if (b) {
                sb.append("OK");
            } else {
                sb.append("FAKE");
            }
            if (n - 1 != i) sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
// AAAA AAAA AAAA AAAA AAAA

//EEE EEE EEE EEE EEE
//   1   1   1