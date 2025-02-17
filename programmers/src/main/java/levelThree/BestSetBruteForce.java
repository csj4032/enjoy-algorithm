package levelThree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class BestSetBruteForce {

    private static long maxProduct = -1;
    private static int[] bestAnswer;

    public int[] solution(int n, int s) {
        int[] answer = new int[n];
        int max = Integer.MIN_VALUE;
        List<int[]> combination = new LinkedList<>();
        dfs(s, 1, 0, 0, new int[n]);
        System.out.println(Arrays.toString(bestAnswer));
        return bestAnswer;
    }

    public static void dfs(int target, int start, int index, int currentSum, int[] array) {
        if (index == array.length) {
            if (currentSum == target) {
                long product = 1;
                for (int num : array) {
                    product *= num;
                }
                if (product > maxProduct) {
                    maxProduct = product;
                    bestAnswer = array.clone();
                }
            }
            return;
        }
        for (int i = start; i <= target - currentSum; i++) {
            if (currentSum + i * (array.length - index) > target) break;
            array[index] = i;
            dfs(target, i, index + 1, currentSum + i, array);
        }
    }

    public static int sum(int[] array) {
        int sum = 0;
        for (int arr : array) {
            sum += arr;
        }
        return sum;
    }

    public static int mul(int[] array) {
        int mul = 1;
        for (int arr : array) {
            mul *= arr;
        }
        return mul;
    }
}
