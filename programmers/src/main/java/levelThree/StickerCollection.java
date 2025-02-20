package levelThree;

public class StickerCollection {

    public int solution(int sticker[]) {
        if (sticker.length == 1) return sticker[0];
        int case1 = dp(sticker, 0, sticker.length - 2);
        int case2 = dp(sticker, 1, sticker.length - 1);
        return Math.max(case1, case2);
    }

    public int dp(int sticker[], int start, int end) {
        int len = end - start + 1;
        if (len == 0) return 0;
        if (len == 1) return sticker[start];
        int[] dp = new int[sticker.length + 1];
        dp[0] = sticker[start];
        dp[1] = Math.max(sticker[start], sticker[start + 1]);
        for (int i = 2; i < len; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + sticker[start + i]);
        }
        return dp[len - 1];
    }
}
