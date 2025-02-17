package levelTwo;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement {

    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Arrays.fill(answer, -1);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < numbers.length; i++) {
            System.out.println(stack);
            while (!stack.isEmpty() && numbers[i] > numbers[stack.peek()]) {
                int index = stack.pop();
                answer[index] = numbers[i];
            }
            stack.push(i);
        }
        return answer;
    }
}
