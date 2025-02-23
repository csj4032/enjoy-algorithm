package levelTwo;

import java.util.HashMap;
import java.util.Map;

public class SeesawBuddy {

    public long solution(int[] weights) {
        long answer = 0;
        Map<Integer, Integer> weightMap = new HashMap<>();

        for (int weight : weights) {
            weightMap.put(weight, weightMap.getOrDefault(weight, 0) + 1);
        }

        int[] ratiosA = {1, 2, 2, 3};
        int[] ratiosB = {1, 3, 4, 4};

        for (int weight : weightMap.keySet()) {
            int count = weightMap.get(weight);
            if (count > 1) {
                answer += (long) count * (count - 1) / 2;
            }
        }

        for (int weight : weightMap.keySet()) {
            for (int k = 1; k < 4; k++) {
                if ((long) weight * ratiosB[k] % ratiosA[k] != 0) continue;
                int target = weight * ratiosB[k] / ratiosA[k];
                if (target > weight && weightMap.containsKey(target)) {
                    answer += (long) weightMap.get(weight) * weightMap.get(target);
                }
            }
        }
        return answer;
    }

    public long solution2(int[] weights) {
        long answer = 0;
        for (int i = 0; i < weights.length; i++) {
            for (int j = i + 1; j < weights.length; j++) {
                if (compareTo(weights[i], weights[j])) {
                    answer++;
                }
            }
        }
        return answer;
    }

    private boolean compareTo(int w1, int w2) {
        if (w1 == w2) {
            return true;
        }
        for (int i = 2; i <= 4; i++) {
            int c1 = w1 * i;
            for (int j = 2; j <= 4; j++) {
                if(i == j) continue;
                int c2 = w2 * j;
                if (c1 == c2) {
                    return true;
                }
            }
        }
        return false;
    }
}
