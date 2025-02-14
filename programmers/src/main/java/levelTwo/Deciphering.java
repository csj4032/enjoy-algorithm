package levelTwo;

import java.util.*;

public class Deciphering {

    public int solution(int n, int[][] q, int[] ans) {
        int answer = 0;
        List<int[]> combinations = new ArrayList<>();
        generateCombinations(n, 5, 0, new int[5], 0, combinations);

        for (int[] target : combinations) {
            int[] result = new int[q.length];
            for (int i = 0; i < q.length; i++) {
                Set<Integer> targetSet = new HashSet<>();
                for (int num : target) targetSet.add(num);
                int count = 0;
                for (int value : q[i]) {
                    if (targetSet.contains(value)) count++;
                }
                result[i] = count;
            }
            if (Arrays.equals(ans, result)) {
                answer++;
            }
        }
        return answer;
    }

    private void generateCombinations(int n, int r, int start, int[] temp, int depth, List<int[]> combinations) {
        if (depth == r) {
            combinations.add(temp.clone());
            return;
        }
        for (int i = start; i < n; i++) {
            temp[depth] = i + 1;
            generateCombinations(n, r, i + 1, temp, depth + 1, combinations);
        }
    }
}
