package levelFour;

/**
 * Link : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/42897">도둑질</a>
 * Category : Dynamic Programming
 */
public class Theft {

    public int solution(int[] money) {
        int length = money.length;
        if (length == 3) return Math.max(Math.max(money[0], money[1]), money[2]);
        int case1 = theft(0, length - 2, money);
        int case2 = theft(1, length - 1, money);
        return Math.max(case1, case2);
    }

    private static int theft(int start, int end, int[] money) {
        int length = end - start + 1;
        int[] dp = new int[money.length + 1];
        dp[0] = money[start];
        dp[1] = Math.max(money[start], money[start + 1]);
        for (int i = 2; i < length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + money[start + i]);
        }
        return dp[length - 1];
    }
}
