package levelTwo;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

/**
 * Link : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/42626">더 맵께</a>
 * Category : Heap, Priority Queue, 최소 힙
 * Idea : 가장 맵지 않은 음식의 스코빌 지수 + (두 번째로 맵지 않은 음식의 스코빌 지수 * 2) = 새로운 음식의 스코빌 지수
 */
public class ScovilleScale {

    private final PriorityQueue<Integer> priorityQueue;

    public ScovilleScale(PriorityQueue<Integer> priorityQueue) {
        this.priorityQueue = priorityQueue;
    }

    public int mix(int k) {
        int count = 0;
        while (true) {
            if (priorityQueue.size() < 2) {
                count = -1;
                break;
            }
            Integer first = priorityQueue.poll();
            Integer second = priorityQueue.poll();
            Integer result = first + (second * 2);
            priorityQueue.add(result);
            System.out.println(priorityQueue);
            count++;
            if (priorityQueue.stream().allMatch(e -> e >= k)) break;
        }
        return count;
    }

    public static ScovilleScale of(int[] scoville) {
        return new ScovilleScale(Arrays.stream(scoville).boxed().collect(Collectors.toCollection(PriorityQueue::new)));
    }
}
