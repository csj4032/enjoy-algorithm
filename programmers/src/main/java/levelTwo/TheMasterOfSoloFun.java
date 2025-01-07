package levelTwo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TheMasterOfSoloFun {

    public int solution(int[] cards) {
        List<Integer> group = new ArrayList<>();
        boolean[] visited = new boolean[cards.length];
        for (int i = 0; i < cards.length; i++) {
            if (!visited[i]) {
                int count = 0;
                int index = i;
                while (!visited[index]) {
                    visited[index] = true;
                    index = cards[index] - 1;
                    count++;
                }
                if (count > 0) group.add(count);
            }
        }
        group.sort(Collections.reverseOrder());
        if (group.size() < 2) return 0;
        return group.get(0) * group.get(1);
    }
}
