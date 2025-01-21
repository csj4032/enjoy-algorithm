package levelTwo;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/131701
 */
public class NumberDistinctSums {
    public int solution(int[] elements) {
        Set<Integer> set = new HashSet<>();
        int[] dp = new int[elements.length];
        for (int i = 1; i <= elements.length; i++) {
            for (int j = 0; j < elements.length; j++) {
                dp[j] += elements[(i + j - 1) % elements.length];
                set.add(dp[j]);
            }
            System.out.println(Arrays.toString(dp));
        }
        return set.size();
    }
}