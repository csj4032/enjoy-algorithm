package levelOne;

import java.util.ArrayList;
import java.util.List;

public class TakePackage {

    public int solution(int n, int w, int num) {
        int answer = 0;
        int index = 0;
        int direction = 1;
        List<Integer>[] lists = new ArrayList[w];
        for (int i = 0; i < w; i++) lists[i] = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            lists[index].add(i);
            index += direction;
            if (index < 0 || index >= w) {
                direction *= -1;
                index += direction;
            }
        }

        for (int i = 0; i < w; i++) {
            List<Integer> list = lists[i];
            if (list.contains(num)) answer = list.size() - list.indexOf(num);
        }
        return answer;
    }
}
