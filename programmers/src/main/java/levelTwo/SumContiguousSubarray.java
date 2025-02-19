package levelTwo;

/**
 * Link : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/178870">연속된 부분 수열의 합</a>
 * Category : 투 포인터(sliding window) 기법
 */
public class SumContiguousSubarray {

    public int[] solution(int[] sequence, int k) {
        int left = 0;
        int right = 0;
        int sum = sequence[0];
        int n = sequence.length;
        int bestLength = Integer.MAX_VALUE;
        int bestLeft = 0;
        int bestRight = 0;
        int length = sequence.length;
        while (left < length && right < length) {
            if (sum == k) {
                int currentLength = right - left + 1;
                if (currentLength < bestLength || (currentLength == bestLength && left < bestLeft)) {
                    bestLength = currentLength;
                    bestLeft = left;
                    bestRight = right;
                }
                sum -= sequence[left++];
            } else if (sum < k) {
                right++;
                if (right < n) sum += sequence[right];
            } else {
                sum -= sequence[left++];
            }
        }
        return new int[]{bestLeft, bestRight};
    }
}
