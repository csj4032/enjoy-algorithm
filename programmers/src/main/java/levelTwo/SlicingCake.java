package levelTwo;

import java.util.HashMap;
import java.util.Map;

public class SlicingCake {

    public int solution(int[] topping) {
        int answer = 0;
        Map<Integer, Integer> prev = new HashMap<>();
        Map<Integer, Integer> next = new HashMap<>();
        for (int i = 0; i < topping.length; i++) next.put(topping[i], next.getOrDefault(topping[i], 0) + 1);

        int distinctNext = next.size();
        int distinctPrev = 0;

        for (int top : topping) {
            int countPrev = prev.getOrDefault(top, 0);
            if (countPrev == 0) distinctPrev++;
            prev.put(top, countPrev + 1);

            int countNext = next.get(top);
            if (countNext == 1) {
                next.remove(top);
                distinctNext--;
            } else {
                next.put(top, countNext - 1);
            }

            if (distinctNext == distinctPrev) answer++;
        }
        return answer;
    }
}
