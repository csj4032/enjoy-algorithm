package levelTwo;

import java.util.ArrayList;
import java.util.List;

/**
 * Link : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/134239">우박수열 정적분</a>
 * Category : Math, Trapezoid, Simulation
 */
public class DefiniteCollatzSequence {

    public double[] solution(int k, int[][] ranges) {
        double[] answer = new double[ranges.length];
        double[] collatzAreas = collatz(k);
        int length = collatzAreas.length;
        for (int i = 0; i < ranges.length; i++) {
            int x1 = ranges[i][0];
            int x2 = length + ranges[i][1] - 1;
            if (x1 > x2) {
                answer[i] = -1;
            } else {
                answer[i] = collatzAreas[x2] - collatzAreas[x1];
            }
        }
        return answer;
    }

    public double[] collatz(int k) {
        List<Double> list = new ArrayList<>();
        int index = 0;
        list.add(0D);
        while (k > 1) {
            int temp = k;
            k = (k % 2 == 0) ? k / 2 : 3 * k + 1;
            double area = (temp + k) / 2.0 + list.get(index++);
            list.add(area);
        }
        return list.stream().mapToDouble(Double::doubleValue).toArray();
    }
}
