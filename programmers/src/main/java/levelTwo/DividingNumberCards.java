package levelTwo;

import java.util.Arrays;

public class DividingNumberCards {

    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        Arrays.sort(arrayA);
        Arrays.sort(arrayB);
        int minA = arrayA[0];
        int minB = arrayB[0];
        int dividingA = dividing(arrayA, minA);
        int dividingB = dividing(arrayB, minB);
        if (dividingA == 1 && dividingB == 1) return 0;
        boolean notAllA = false;
        boolean notAllB = false;
        if (dividingA > 1) notAllB = notAllDividing(arrayB, dividingA);
        if (dividingB > 1) notAllA = notAllDividing(arrayA, dividingB);
        if (notAllA && notAllB) return Math.max(dividingA, dividingB);
        if (notAllA) return dividingB;
        if (notAllB) return dividingA;
        return answer;
    }

    private boolean notAllDividing(int[] array, int dividing) {
        for (int number : array) if (number % dividing == 0) return false;
        return true;
    }

    private int dividing(int[] array, int min) {
        for (int i = min; i > 1; i--) {
            boolean isDividing = true;
            for (int number : array) {
                if (number % i != 0) {
                    isDividing = false;
                    break;
                }
            }
            if (isDividing) {
                return i;
            }
        }
        return 1;
    }
}
