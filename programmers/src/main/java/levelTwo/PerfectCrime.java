package levelTwo;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class PerfectCrime {

    public static class Information {
        public int a;
        public int b;
        public int c;

        public Information(int a, int b) {
            this.a = a;
            this.b = b;
            this.c = a + b;
        }

        @Override
        public String toString() {
            return "Info{" + "a=" + a + ", b=" + b + '}';
        }
    }

    public int solution(int[][] info, int n, int m) {
        PriorityQueue<Information> pq1 = new PriorityQueue<>(Comparator.<Information>comparingInt(o -> o.b).thenComparingInt(o -> o.a));
        PriorityQueue<Information> pq2 = new PriorityQueue<>(Comparator.<Information>comparingInt(o -> o.b).thenComparingInt(o -> -o.a));
        PriorityQueue<Information> pq3 = new PriorityQueue<>(Comparator.<Information>comparingInt(o -> -o.b).thenComparingInt(o -> o.a));
        PriorityQueue<Information> pq4 = new PriorityQueue<>(Comparator.<Information>comparingInt(o -> -o.b).thenComparingInt(o -> -o.a));
        PriorityQueue<Information> pq5 = new PriorityQueue<>(Comparator.<Information>comparingInt(o -> o.a).thenComparingInt(o -> o.b));
        PriorityQueue<Information> pq6 = new PriorityQueue<>(Comparator.<Information>comparingInt(o -> o.a).thenComparingInt(o -> -o.b));
        PriorityQueue<Information> pq7 = new PriorityQueue<>(Comparator.<Information>comparingInt(o -> -o.a).thenComparingInt(o -> o.b));
        PriorityQueue<Information> pq8 = new PriorityQueue<>(Comparator.<Information>comparingInt(o -> -o.a).thenComparingInt(o -> -o.b));
        for (int[] i : info) {
            pq1.add(new Information(i[0], i[1]));
            pq2.add(new Information(i[0], i[1]));
            pq3.add(new Information(i[0], i[1]));
            pq4.add(new Information(i[0], i[1]));
            pq5.add(new Information(i[0], i[1]));
            pq6.add(new Information(i[0], i[1]));
            pq7.add(new Information(i[0], i[1]));
            pq8.add(new Information(i[0], i[1]));
        }
        int a1 = calculate(pq1, n, m);
        int a2 = calculate(pq2, n, m);
        int a3 = calculate(pq3, n, m);
        int a4 = calculate(pq4, n, m);
        int a5 = calculate(pq5, n, m);
        int a6 = calculate(pq6, n, m);
        int a7 = calculate(pq7, n, m);
        int a8 = calculate(pq8, n, m);
        if (a1 == -1 && a2 == -1 && a3 == -1 && a4 == -1 && a5 == -1 && a6 == -1 && a7 == -1 && a8 == -1) return -1;
        if (a1 == -1) a1 = Integer.MAX_VALUE;
        if (a2 == -1) a2 = Integer.MAX_VALUE;
        if (a3 == -1) a3 = Integer.MAX_VALUE;
        if (a4 == -1) a4 = Integer.MAX_VALUE;
        if (a5 == -1) a5 = Integer.MAX_VALUE;
        if (a6 == -1) a6 = Integer.MAX_VALUE;
        if (a7 == -1) a7 = Integer.MAX_VALUE;
        if (a8 == -1) a8 = Integer.MAX_VALUE;
        return Math.min(Math.min(Math.min(a1, a2), Math.min(a3, a4)), Math.min(Math.min(a5, a6), Math.min(a7, a8)));
    }

    private int calculate(Queue<Information> pq, int n, int m) {
        int a1 = 0;
        int b1 = 0;
        while (!pq.isEmpty()) {
            Information information = pq.poll();
            if ((b1 + information.b) < m) {
                b1 += information.b;
            } else {
                if ((a1 + information.a) < n) {
                    a1 += information.a;
                } else {
                    return -1;
                }
            }
        }
        return a1;
    }
}
