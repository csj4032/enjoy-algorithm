package levelThree;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Link : https://school.programmers.co.kr/learn/courses/30/lessons/67258
 * Category : Sliding Window, Two Pointers
 */
public class ShoppingJewelry {

    public int[] solution(String[] gems) {
        Set<String> unique = new HashSet<>(Arrays.stream(gems).collect(Collectors.toList()));
        int uniqueSize = unique.size();
        Map<String, Integer> map = new HashMap<>();
        for (String gem : unique) map.put(gem, 0);
        int right = 0;
        int left = 0;
        int match = 0;
        int minLength = gems.length;
        int[] minRange = new int[]{0, gems.length};
        while (right < gems.length) {
            String add = gems[right];
            map.merge(add, 1, Integer::sum);
            if (map.get(add) == 1) match++;
            while (match == uniqueSize) {
                if (right - left - 1 < minLength) {
                    minLength = right - left - 1;
                    minRange = new int[]{left + 1, right + 1};
                }
                String remove = gems[left];
                map.merge(remove, -1, Integer::sum);
                if (map.get(remove) == 0) match--;
                left++;
            }
            right++;
        }
        return minRange;
    }
}
