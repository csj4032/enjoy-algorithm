package p1996;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {

            int n = sc.nextInt();
            int m = sc.nextInt();

            int[] l = new int[n];
            int[] k = new int[n];
            PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());

            int max = 0;
            for (int j = 0; j < n; j++) {
                int p = sc.nextInt();
                l[j] = p;
                k[j] = p;
                queue.add(p);
                max = Math.max(max, p);
            }
            System.out.println(queue);
            System.out.println(Arrays.toString(l));
            System.out.println(Arrays.toString(k));

            for (int j = 0; j < n; j++) {
                int c = queue.poll();
                for (int o = 0; o < l.length; o++) {
                    if (l[o] == c) {
                        if(m == o) {
                            System.out.println(j);
                        }
                        o = o % l.length;
                        l[o] = 0;

                        break;
                    }
                }
            }
        }
    }
}

class Value {
    int idx;
    int dep;
    int val;

    public Value(int idx, int dep, int val) {
        this.idx = idx;
        this.dep = dep;
        this.val = val;
    }
}