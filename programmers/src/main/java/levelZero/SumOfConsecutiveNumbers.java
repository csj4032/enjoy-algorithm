package levelZero;

import java.util.Arrays;

public class SumOfConsecutiveNumbers {

    public int[] solution(int num, int total) {
        int[] answer = new int[num];
        int start = num * -1;
        for (int i = start; i <= total; i++) {
            int sum = 0;
            answer = new int[num];
            for (int j = i; j < i + num; j++) {
                sum += j;
                answer[j - i] = j;
            }
            if (total == sum) break;
        }
        System.out.println(Arrays.toString(answer));
        return answer;
    }
}
