package levelTwo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArcheryCompetition {

    public int[] solution(int n, int[] info) {
        int[] answer = {-1};
        List<int[]> results = new ArrayList<>();
        dfs(n, 0, 0, new int[11], results);
        int maxPoint = -1;
        for (int[] lion : results) {
            int apeachPoint = 0;
            int lionPoint = 0;
            for (int i = 0; i < 11; i++) {
                int apeachCount = info[i];
                int lionCount = lion[i];
                if (apeachCount == 0 && lionCount == 0) continue;
                if (apeachCount >= lionCount) {
                    apeachPoint += (10 - i);
                } else {
                    lionPoint += (10 - i);
                }
            }
            int gap = lionPoint - apeachPoint;
            if (apeachPoint < lionPoint && gap >= maxPoint) {
                if (gap == maxPoint) {
                    for (int i = 10; i >= 0; i--) {
                        int best = answer[i];
                        int current = lion[i];
                        if (best < current) {
                            answer = lion;
                            break;
                        }
                        if (best > current) break;
                    }
                } else {
                    maxPoint = gap;
                    answer = lion;
                }
            }
        }
        System.out.println(Arrays.toString(answer));
        return answer;
    }

    private static void dfs(int n, int index, int currentSum, int[] array, List<int[]> result) {
        if (index == 11) {
            if (Arrays.stream(array).sum() == n) result.add(array.clone());
            return;
        }
        for (int value = 0; value <= n; value++) {
            if (currentSum + value <= n) {
                array[index] = value;
                dfs(n, index + 1, currentSum + value, array, result);
            }
        }
    }
}
