package levelThree;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * link : https://school.programmers.co.kr/learn/courses/30/lessons/12927
 * category : 우선 순위
 */
public class OvertimeIndex {

    public long solution(int n, int[] works) {
        long totalWork = 0;
        for (int work : works) {
            totalWork += work;
        }
        if (totalWork <= n) return 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int work : works) {
            pq.offer(work);
        }

        while (n-- > 0) {
            int largets = pq.poll();
            pq.offer(largets - 1);
        }

        long answer = 0;
        while (!pq.isEmpty()) {
            int remain = pq.poll();
            answer += (long) remain * remain;
        }
        return answer;
    }
}

