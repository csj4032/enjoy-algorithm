package levelOne;

import java.util.HashMap;
import java.util.Map;

public class ClosestMatchingWord {

    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            answer[i] = map.getOrDefault(c, -1) == -1 ? -1 : i - map.get(c);
            map.put(c, i);
        }
        return answer;
    }
}
