package levelThree;

import java.util.*;

/**
 * Link : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/42895">N으로 표현</a>
 * Category : DP, Dynamic Programming
 */
public class ExpressedAsN {

    public int solution(int N, int number) {
        List<List<Integer>> group = new ArrayList<>();
        for (int i = 1; i < 9; i++) {
            List<Integer> sub = new ArrayList<>();
            int concatenated = Integer.parseInt(String.valueOf(N).repeat(i));
            sub.add(concatenated);
            for (int j = 0; j < i - 1; j++) {
                for (int k = 0; k < group.get(j).size(); k++) {
                    for (int l = 0; l < group.get(i - j - 2).size(); l++) {
                        sub.add(group.get(j).get(k) + group.get(i - j - 2).get(l));
                        sub.add(group.get(j).get(k) - group.get(i - j - 2).get(l));
                        sub.add(group.get(j).get(k) * group.get(i - j - 2).get(l));
                        if (group.get(i - j - 2).get(l) != 0) sub.add(group.get(j).get(k) / group.get(i - j - 2).get(l));
                    }
                }
            }
            if (sub.contains(number)) return i;
            group.add(sub);
        }
        return -1;
    }
}
