package levelThree;

import java.util.Arrays;
import java.util.Comparator;

public class SpeedCamera {

    public int solution(int[][] routes) {
        int answer = 0;
        Arrays.sort(routes, Comparator.comparingInt(a -> a[1]));
        int cameraPosition = Integer.MIN_VALUE;
        for (int[] route : routes) {
            if (route[0] > cameraPosition) {
                cameraPosition = route[1];
                answer++;
            }
        }
        return answer;
    }
}
