package levelFour;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Link : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/43236">징검다리</a>
 * Category : Binary Search
 */
public class SteppingStone {

    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        int low = 0;
        int high = distance;
        List<Integer> rockList = Arrays.stream(rocks).boxed().sorted().collect(Collectors.toList());
        rockList.add(distance);
        while (low <= high) {
            int current = 0;
            int removeCount = 0;
            int mid = (high + low) / 2;
            int minDistance = Integer.MAX_VALUE;
            for (int rock : rockList) {
                int diff = rock - current;
                if (diff < mid) {
                    removeCount++;
                } else {
                    current = rock;
                    minDistance = Math.min(minDistance, mid);
                }
            }
            if (removeCount > n) {
                high = mid - 1;
            } else {
                answer = minDistance;
                low = mid + 1;
            }
        }
        return answer;
    }
}