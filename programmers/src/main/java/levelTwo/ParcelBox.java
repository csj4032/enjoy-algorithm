package levelTwo;

import java.util.*;

public class ParcelBox {

    public int solution(int[] order) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < order.length; i++) {
            stack.add(i + 1);
            while (!stack.isEmpty()) {
                if (stack.peek() == order[answer]) {
                    stack.pop();
                    answer++;
                } else {
                    break;
                }
            }
        }
        return answer;
    }
}
