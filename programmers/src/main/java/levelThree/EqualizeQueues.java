package levelThree;

import java.util.LinkedList;
import java.util.Queue;

public class EqualizeQueues {

    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        long s1 = 0l;
        long s2 = 0l;
        Queue<Long> q1 = new LinkedList<>();
        Queue<Long> q2 = new LinkedList<>();
        for (int i = 0; i < queue1.length; i++) {
            s1 += queue1[i];
            s2 += queue2[i];
            q1.add(Long.valueOf(queue1[i]));
            q2.add(Long.valueOf(queue2[i]));
        }

        while (!q1.isEmpty() && !q2.isEmpty()) {
            long k;
            if (s1 == s2) break;
            if (s1 > s2) {
                k = q1.poll();
                s1 -= k;
                s2 += k;
                q2.offer(k);
            } else {
                k = q2.poll();
                s2 -= k;
                s1 += k;
                q1.offer(k);
            }
            System.out.println(q1 + " " + q2 + " " + answer);
            if (answer == queue1.length * 10) {
                answer = -1;
                break;
            }
            answer++;
        }
        return (q1.isEmpty() || q2.isEmpty()) ? -1 : answer;
    }
}
