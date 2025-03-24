package levelTwo;

import java.util.Arrays;

/**
 * Link : https://school.programmers.co.kr/learn/courses/30/lessons/169198
 * Category : 완전탐색
 * Describe :
 */
public class BilliardsPractice {

    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        int[] answer = new int[balls.length];
        for (int i = 0; i < balls.length; i++) {
            int x = balls[i][0];
            int y = balls[i][1];
            int dx = x - startX;
            int dy = y - startY;
            int gcd = gcd(Math.abs(dx), Math.abs(dy));
            

        }
        System.out.println("answer = " + Arrays.toString(answer));
        return answer;
    }

    public static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}
