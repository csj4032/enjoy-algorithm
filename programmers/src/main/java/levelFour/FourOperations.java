package levelFour;

import java.util.*;

/**
 * Link : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/1843">사칙연산</a>
 * Category : DP, Dynamic Programming
 */
public class FourOperations {

    private static Map<String, List<Integer>> cache;

    public int solution(String[] arr) {
        cache = new HashMap<>();
        List<Integer> result = expression(arr, 0, arr.length - 1);
        result.sort(Comparator.reverseOrder());
        return result.get(0);
    }

    public static List<Integer> expression(String[] tokens, int start, int end) {
        String key = start + "-" + end;
        if (cache.containsKey(key)) return cache.get(key);
        List<Integer> list = new ArrayList<>();
        if (start == end) {
            if (tokens[start].equals("+") || tokens[start].equals("-")) {
                return list;
            }
            list.add(Integer.parseInt(tokens[start]));
            cache.put(key, list);
            return list;
        }
        for (int i = start + 1; i < end; i += 2) {
            List<Integer> left = expression(tokens, start, i - 1);
            List<Integer> right = expression(tokens, i + 1, end);
            for (Integer leftToken : left) {
                for (Integer rightToken : right) {
                    if (tokens[i].equals("+")) {
                        list.add(leftToken + rightToken);
                    } else {
                        list.add(leftToken - rightToken);
                    }
                }
            }
        }
        cache.put(key, list);
        return list;
    }
}
