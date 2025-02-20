package levelFour;

import java.util.Arrays;

public class Theft {

    public int solution(int[] money) {
        int length = money.length;
        if (length == 3) return Math.max(money[0] + money[2], money[1]);
        int case1 = theft(0, length - 2, money);
        int case2 = theft(1, length - 1, money);
        return Math.max(case1, case2);
    }

    private static int theft(int start, int end, int[] money) {
        int length = end - start + 1;
        int[] dp = new int[money.length + 1];
        int index = 2;
        if (start == 1) {
            index = 1;
            dp[0] = money[start - 1];
            dp[1] = Math.max(money[start - 1], money[start]);
        } else {
            dp[0] = money[start];
            dp[1] = Math.max(money[start], money[start + 1]);
        }
        for (int i = index; i < length; i++) {
            System.out.println(Arrays.toString(dp) + " " + money[start + i]);
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + money[start + i]);
        }
        System.out.println(Arrays.toString(dp));
        System.out.println("!!!!");
        return dp[length - 1];
    }
}
