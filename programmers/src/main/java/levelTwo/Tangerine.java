package levelTwo;

import java.util.*;

/**
 * Link : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/138476">귤 고르기</a>
 * Category : 최대 힙
 */
public class Tangerine {

    public int solution(int k, int[] tangerine) {
        Map<Integer, Integer> frequency = new HashMap<>();
        for (int tan : tangerine) frequency.merge(tan, 1, Integer::sum);
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        maxHeap.addAll(frequency.values());
        int count = 0, answer = 0;
        while (count < k && !maxHeap.isEmpty()) {
            count += maxHeap.poll();
            System.out.println(count);
            answer++;
        }
        return answer;
    }
}
