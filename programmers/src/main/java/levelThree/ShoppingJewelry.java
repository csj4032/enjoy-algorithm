package levelThree;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ShoppingJewelry {

    public int[] solution(String[] gems) {
        Set<String> unique = new HashSet<>(Arrays.stream(gems).toList());
        int length = unique.size();
        int[] answer = {};
        return answer;
    }
}
