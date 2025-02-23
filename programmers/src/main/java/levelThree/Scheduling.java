package levelThree;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Link : https://school.programmers.co.kr/learn/courses/30/lessons/12920
 * Category : 이분 탐색(Parametric Search)
 */
public class Scheduling {

    public int solution(int n, int[] cores) {
        int answer = 0;
        int length = cores.length;
        int step = 0;
        while (n > 0) {
            for (int i = 0; i < length; i++) {
                int current = cores[i];
                if ((step % current) == 0) {
                    n--;
                    answer = i;
                    if (n == 0) break;
                }
            }
            step++;
        }
        return answer + 1;
    }


    class Core implements Comparable<Core> {
        int index;
        int seq;
        int time;
        int total;

        public Core(int index, int seq, int time, int total) {
            this.index = index;
            this.seq = seq;
            this.time = time;
            this.total = total;
        }

        @Override
        public int compareTo(Core other) {
            if (this.total == other.total) {
                return Integer.compare(this.index, other.index);
            }
            return Integer.compare(this.total, other.total);
        }

        @Override
        public String toString() {
            return "Core{" + "index=" + index + ", seq=" + seq + ", time=" + time + ", total=" + total + '}';
        }
    }

    public int queue(int n, int[] cores) {
        int length = cores.length;
        PriorityQueue<Core> queue = new PriorityQueue(cores.length);
        if (length > n) return n;
        for (int i = 0; i < length; i++) {
            queue.add(new Core(i + 1, i + 1, cores[i], cores[i]));
        }
        int seq = length;
        while (true) {
            Core core = queue.poll();
            core.seq = ++seq;
            if (seq == n) return core.index;
            core.total = core.total + core.time;
            queue.add(core);
        }
    }

    public int search(int n, int[] cores) {
        int length = cores.length;
        if (n <= length) return n;
        long left = 0;
        long right = 1L * n * Arrays.stream(cores).max().getAsInt();
        long time = 0;
        while (left <= right) {
            long mid = (left + right) / 2;
            long count = 0;
            for (int core : cores) count += mid / core + 1;
            if (count >= n) {
                time = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        long count = 0;
        for (int core : cores) count += (time - 1) / core + 1;

        int remaining = (int) (n - count);
        for (int i = 0; i < length; i++) {
            if (time % cores[i] == 0) {
                remaining--;
                if (remaining == 0) return i + 1;
            }
        }
        return -1;
    }
}
