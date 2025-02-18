package levelThree;

import java.util.Arrays;

public class NumberGame {

    public int solution(int[] A, int[] B) {
        int answer = 0;
        Arrays.sort(B);
        Arrays.sort(A);
        int aIndex = 0;
        int bIndex = 0;
        while (bIndex < B.length && aIndex < A.length) {
            if (B[bIndex] > A[aIndex]) {
                answer++;
                aIndex++;
            }
            bIndex++;
        }
        return answer;
    }

    public int upperBound(int[] array, int target) {
        int left = 0;
        int right = array.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (array[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
