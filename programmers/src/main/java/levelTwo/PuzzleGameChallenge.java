package levelTwo;

/**
 * Link : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/340212">...</a>
 * Category : 이분탐색, Binary Search
 */
public class PuzzleGameChallenge {

    public int solution(int[] diffs, int[] times, long limit) {
        int answer = 0;
        int highest = 0;
        int lowest = Integer.MAX_VALUE;
        long[] prefixSum = new long[times.length];

        for (int i = 0; i < diffs.length; i++) {
            if (diffs[i] > highest) highest = diffs[i];
            if (diffs[i] < lowest) lowest = diffs[i];
        }
        for (int i = 0; i < times.length; i++) {
            prefixSum[i] = (i == 0 ? 0 : times[i - 1]) + times[i];
        }

        while (highest >= lowest) {
            int mid = (highest + lowest) / 2;
            long sum = 0;
            boolean isOver = false;
            for (int j = 0; j < times.length; j++) {
                if (diffs[j] > mid) {
                    sum += prefixSum[j] * (diffs[j] - mid) + times[j];
                } else {
                    sum += times[j];
                }
                if (sum > limit) {
                    isOver = true;
                    break;
                }
            }
            if (isOver) {
                lowest = mid + 1;
            } else {
                answer = mid;
                highest = mid - 1;
            }
        }
        return answer;
    }
}
