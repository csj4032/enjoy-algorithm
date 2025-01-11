package levelZero;

import java.util.HashMap;
import java.util.Map;

public class TestBed {

    public int solution(int[] array) {
        int maxCount = 0;
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int number : array) {
            System.out.println(number);
            int count = map.getOrDefault(number, 0) + 1;
            if (count > maxCount) {
                maxCount = count;
                answer = number;
            } else if (count == maxCount) {
                answer = -1;
            }
            map.put(number, count);
        }
        return answer;
    }

    public static void main(String[] args) {
        TestBed testBed = new TestBed();
        testBed.solution(new int[]{1, 1, 2, 2, 3, 3, 3});
    }
}

class Node {
    Integer key;
    Integer value;
}