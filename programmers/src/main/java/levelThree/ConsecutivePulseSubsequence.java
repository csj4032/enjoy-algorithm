package levelThree;

/**
 * Link : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/161988">연속 펄스 부분 수열의 합</a>
 * Category : Kadane's Algorithm 카데인 알고리즘
 */
public class ConsecutivePulseSubsequence {

    public long solution(int[] sequence) {
        long plus = getSubSum(sequence, true);
        long minus = getSubSum(sequence, false);
        return Math.max(plus, minus);
    }

    public long getSubSum(int[] sequence, boolean bool) {
        int[] tempSequence = new int[sequence.length];
        long total = Long.MIN_VALUE;
        long current = 0;
        for (int i = 0; i < sequence.length; i++) {
            int k = ((bool ? -1 : 1) * ((i % 2 == 0) ? 1 : -1));
            tempSequence[i] = sequence[i] * k;
            current = Math.max(tempSequence[i], current + tempSequence[i]);
            total = Math.max(total, current);
        }
        return total;
    }
}
