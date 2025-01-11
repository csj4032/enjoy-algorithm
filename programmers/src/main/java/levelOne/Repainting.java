package levelOne;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Repainting {
    public int solution(int n, int m, int[] section) {
        int answer = 1;
        int start = section[0];
        for (int i = 1; i < section.length; i++) {
            if (start + m - 1 < section[i]) {
                answer++;
                start = section[i];
            }
        }
        return answer;
    }
}
