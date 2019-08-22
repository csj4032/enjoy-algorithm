package p10799;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] n = br.readLine().toCharArray();
        int d = 0;
        int m = 0;
        for (int i = 0; i < n.length; i++) {
            if (n[i] == '(') {
                d++;
            } else {
                if (n[i - 1] == '(') {
                    d--;
                    m += d;
                } else {
                    m++;
                    d--;
                }
            }
        }
        System.out.println(m);
    }
}