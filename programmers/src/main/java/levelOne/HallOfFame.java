package levelOne;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class HallOfFame {

    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        PriorityQueue<Integer> pq = new PriorityQueue<>(); // 최소 힙
        for (int i = 0; i < score.length; i++) {
            pq.offer(score[i]); // 점수 추가
            if (pq.size() > k) {
                pq.poll(); // k개 초과 시 최솟값 제거
            }
            answer[i] = pq.peek(); // 명예의 전당 최하위 점수
        }
        return answer;
    }
}
