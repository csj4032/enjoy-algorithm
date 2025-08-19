package levelThree;

import java.util.Arrays;

/**
 * Link : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/12904">가장 긴 팰린드롬</a>
 * Category : Dynamic Programming, DP, 다이나믹 프로그래밍
 * Description : 문제 정의: dp[i][j]를 "문자열의 i번째부터 j번째까지의 부분 문자열이 팰린드롬인가?"라는 질문에 대한 답(true/false)으로 정의합니다.
 * 기저 상태 (Base Cases): 가장 작은 문제부터 해결합니다.
 * 길이가 1인 부분 문자열: 모든 글자 하나는 그 자체로 팰린드롬입니다. (예: "a", "b")
 * dp[i][i] = true
 * 길이가 2인 부분 문자열: 두 글자가 같으면 팰린드롬입니다. (예: "aa")
 * dp[i][i+1] = (s[i] == s[i+1])
 * 점화식 (Recurrence Relation): 더 큰 문제를 해결합니다.
 * 길이가 3 이상인 부분 문자열: s[i]부터 s[j]까지의 문자열이 팰린드롬이 되려면 두 가지 조건이 충족되어야 합니다.
 * 양 끝 글자가 같아야 합니다. (s[i] == s[j])
 * 그 사이의 부분 문자열(s[i+1]부터 s[j-1]) 또한 팰린드롬이어야 합니다. (dp[i+1][j-1] == true)
 */
public class LongestPalindrome {

    public int solution(String s) {
        int length = s.length();
        if (length < 2) return length;
        int maxLength = 1;
        boolean[][] dp = new boolean[length][length];
        for (int i = 0; i < length; i++) dp[i][i] = true;
        for (int i = 0; i < length - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
                maxLength = 2;
            }
        }
        for (int len = 3; len <= length; len++) {
            for (int i = 0; i <= length - len; i++) {
                int j = i + len - 1;
                if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                    maxLength = Math.max(maxLength, len);
                }
            }
        }
        return maxLength;
    }
}