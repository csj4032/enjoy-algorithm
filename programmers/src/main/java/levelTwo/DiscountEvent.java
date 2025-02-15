package levelTwo;

import java.util.HashMap;
import java.util.Map;

public class DiscountEvent {

    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;

        Map<String, Integer> wantMap = new HashMap<>();
        for (int i = 0; i < want.length; i++) wantMap.put(want[i], number[i]);

        Map<String, Integer> currentMap = new HashMap<>();
        for (int i = 0; i < 10; i++) currentMap.put(discount[i], currentMap.getOrDefault(discount[i], 0) + 1);

        if (isSubset(wantMap, currentMap)) answer++;

        for (int i = 10; i < discount.length; i++) {
            String removeItem = discount[i - 10];
            if (currentMap.get(removeItem) == 1) {
                currentMap.remove(removeItem);
            } else {
                currentMap.put(removeItem, currentMap.get(removeItem) - 1);
            }
            String addItem = discount[i];
            currentMap.put(addItem, currentMap.getOrDefault(addItem, 0) + 1);
            if (isSubset(wantMap, currentMap)) answer++;
        }
        return answer;
    }

    private boolean isSubset(Map<String, Integer> wantMap, Map<String, Integer> currentMap) {
        for (Map.Entry<String, Integer> entry : wantMap.entrySet()) {
            if (currentMap.getOrDefault(entry.getKey(), 0) < entry.getValue()) {
                return false;
            }
        }
        return true;
    }
}
