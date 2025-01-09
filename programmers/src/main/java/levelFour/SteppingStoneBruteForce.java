package levelFour;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 징검다리
 */
public class SteppingStoneBruteForce {

    static int maxMinDistance = 0;

    public int solution(int distance, int[] rocks, int n) {
        Arrays.sort(rocks);  // 바위 정렬
        List<List<Integer>> combinations = new ArrayList<>();
        generateCombinations(combinations, new ArrayList<>(), rocks, 0, n);
        for (List<Integer> combination : combinations) {
            maxMinDistance = Math.max(maxMinDistance, calculateMinDistance(distance, rocks, combination));
        }
        return maxMinDistance;
    }

    private static void generateCombinations(List<List<Integer>> combinations, List<Integer> current, int[] rocks, int index, int n) {
        if (current.size() == n) {
            combinations.add(new ArrayList<>(current));
            return;
        }

        for (int i = index; i < rocks.length; i++) {
            current.add(rocks[i]);
            generateCombinations(combinations, current, rocks, i + 1, n);
            current.remove(current.size() - 1);
        }
    }

    private static int calculateMinDistance(int distance, int[] rocks, List<Integer> removedRocks) {
        int current = 0;  // 현재 위치
        int minDistance = Integer.MAX_VALUE;
        for (int rock : rocks) {
            if (removedRocks.contains(rock)) continue;  // 제거된 바위는 무시
            int diff = rock - current;
            minDistance = Math.min(minDistance, diff);
            current = rock;
        }
        minDistance = Math.min(minDistance, distance - current);
        return minDistance;
    }
}