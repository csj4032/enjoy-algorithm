package levelTwo;

import java.util.*;

public class Tangerine {

    public int solution(int k, int[] tangerine) {
        int sum = 0;
        int answer = 0;
        Map<Integer, Integer> frequency = new LinkedHashMap<>();
        for (int tan : tangerine) frequency.put(tan, frequency.getOrDefault(tan, 0) + 1);
        List<Integer> counts = new ArrayList<>(frequency.values());
        counts.sort(Comparator.reverseOrder());
        for (int count : counts) {
            sum += count;
            answer++;
            if (sum >= k) break;
        }
        return answer;
    }
}
