package p2628;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int w = sc.nextInt();
        int h = sc.nextInt();
        int n = sc.nextInt();

        List<Integer> ws = new ArrayList<>();
        List<Integer> wss = new ArrayList<>();
        List<Integer> hs = new ArrayList<>();
        List<Integer> hss = new ArrayList<>();

        ws.add(0);
        ws.add(w);
        hs.add(0);
        hs.add(h);

        for (int i = 0; i < n; i++) {
            int d = sc.nextInt();
            if (d == 1) {
                ws.add(sc.nextInt());
            } else {
                hs.add(sc.nextInt());
            }
        }
        Collections.sort(ws);
        Collections.sort(hs);

        for (int i = 0; i < ws.size() - 1; i++) {
            wss.add(ws.get(i + 1) - ws.get(i));
        }

        for (int i = 0; i < hs.size() - 1; i++) {
            hss.add(hs.get(i + 1) - hs.get(i));
        }

        int max = 0;
        for (Integer a : wss) {
            for (Integer b : hss) {
                max = Math.max(max, a * b);
            }
        }

        System.out.println(max);
    }
}
