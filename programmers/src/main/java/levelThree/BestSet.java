package levelThree;

import java.util.Arrays;

public class BestSet {

    public int[] solution(int n, int s) {
        int[] answer = new int[n];
        int mod = s % n;
        int div = (s - mod) / n;
        for (int i = 0; i < n; i++) answer[i] = div;
        for (int i = 0; i < mod; i++) answer[i] += 1;
        Arrays.sort(answer);
        return s < n ? new int[]{-1} : answer;
    }
}
