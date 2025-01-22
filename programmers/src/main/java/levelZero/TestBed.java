package levelZero;

import java.util.*;

public class TestBed {

    public int[] solution(int n, int[] numlist) {
        List<Integer> answer = new ArrayList<>();
        for (int num : numlist) {
            if (num % n == 0) answer.add(num);
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        TestBed testBed = new TestBed();
        int[] result = testBed.solution(5, new int[]{1, 9, 3, 10, 13, 5});
        System.out.println(result[0]);
    }
}