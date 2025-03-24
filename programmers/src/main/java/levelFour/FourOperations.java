package levelFour;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Link : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/1843">사칙연산</a>
 * Category : DP, Dynamic Programming
 */
public class FourOperations {

    public int solution(String[] arr) {
        int answer = Integer.MIN_VALUE;
        int[] numbers = new int[arr.length / 2 + 1];
        String[] operators = new String[arr.length / 2];
        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 0) {
                numbers[i / 2] = Integer.parseInt(arr[i]);
            } else {
                operators[i / 2] = arr[i];
            }
        }
        int numberSize = numbers.length;
        int[][] dpMax = new int[numberSize][numberSize];
        int[][] dpMin = new int[numberSize][numberSize];
        for (int i = 0; i < numberSize; i++) {
            dpMax[i][i] = numbers[i];
            dpMin[i][i] = numbers[i];
        }

        for (int i = 2; i <= numberSize; i++) {
            for (int start = 0; start <= numberSize - i; start++) {
                int end = start + i - 1;
                for (int k = start; k < end; k++) {
                    System.out.println("start: " + start + ", end: " + end + ", k: " + k);
                    int leftMin = dpMin[start][k];
                    int rightMin = dpMin[k + 1][end];
                    int leftMax = dpMax[k + 1][end];
                    int rightMax = dpMax[k + 1][end];
                    evaluate(leftMin, rightMin, operators[k]);
                }
            }
        }
        return answer;
    }

    private static long evaluate(int a, int b, String op) {
        return switch (op) {
            case "+" -> a + b;
            case "-" -> a - b;
            default -> throw new IllegalArgumentException("알 수 없는 연산자: " + op);
        };
    }
}
