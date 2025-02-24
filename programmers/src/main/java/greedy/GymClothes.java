package greedy;

import java.util.Arrays;
import java.util.stream.IntStream;

public class GymClothes {

    public static int solution(int n, int[] lost, int[] reserve) {
        int[] checkList = new int[n + 1];
        Arrays.fill(checkList, 1);
        System.out.println(Arrays.toString(checkList));
        for (int j : reserve) checkList[j] += 1;
        System.out.println(Arrays.toString(checkList));
        for (int j : lost) checkList[j] -= 1;
        System.out.println(Arrays.toString(checkList));
        for (int i = 1; i <= n; i++) {
            if (checkList[i] == 0) {
                if (checkList[i - 1] >= 2) {
                    checkList[i] = 1;
                    checkList[i - 1] -= 1;
                }
                if (i < n && checkList[i + 1] >= 2) {
                    checkList[i] = 1;
                    checkList[i + 1] -= 1;
                }
            }
        }
        System.out.println(Arrays.toString(checkList));

        int sum = 0;
        for (int i = 1; i <= n; i++) {
            if (checkList[i] > 0) sum++;
        }

        return sum;
    }

    public static int solution2(int n, int[] lost, int[] reserve) {
        boolean[] checkList = new boolean[n + 1];
        Arrays.stream(lost).forEach(i -> checkList[i] = true);
        Arrays.stream(reserve).sorted()
                .forEach(i -> {
                    if (checkList[i]) {
                        checkList[i] = false;
                    } else if (i > 1 && checkList[i - 1]) {
                        checkList[i - 1] = false;
                    } else if (i < n && checkList[i + 1]) {
                        checkList[i + 1] = false;
                    }
                });

        return IntStream.rangeClosed(1, n).map(i -> checkList[i] ? 0 : 1).sum();
    }
}
