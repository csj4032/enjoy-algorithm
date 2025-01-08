package levelOne;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MemoryScore {

    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        Map<String, Integer> points = new HashMap<>();
        for (int i = 0; i < name.length; i++) points.put(name[i], yearning[i]);
        return Arrays.stream(photo).mapToInt(friends -> Arrays.stream(friends).mapToInt(friend -> points.getOrDefault(friend, 0)).sum()).toArray();
    }
}
