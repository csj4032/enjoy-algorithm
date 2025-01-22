package levelZero;

import java.util.Arrays;

public class TestBed {

    public String solution(int[] numLog) {
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < numLog.length - 1; i++) {
            int prev = numLog[i];
            int next = numLog[i + 1];
            if (next - prev == 1) answer.append("w");
            if (next - prev == -1) answer.append("s");
            if (next - prev == 10) answer.append("d");
            if (next - prev == -10) answer.append("a");
        }
        return answer.toString();
    }

    public static void main(String[] args) {
        TestBed testBed = new TestBed();
        String result = testBed.solution(new int[]{0, 1, 0, 10, 0, 1, 0, 10, 0, -1, -2, -1});
        System.out.println(result);
    }
}