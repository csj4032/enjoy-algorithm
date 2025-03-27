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
            answer[i] = calculate(m, n, startX, startY, balls[i][0], balls[i][1]);
        }
        return answer;
    }

    private int calculate(int m, int n, int sx, int sy, int tx, int ty) {
        if (sy == ty) return minDistanceOneCoordinateSame(sx, tx, sy, m, n);
        if (sx == tx) return minDistanceOneCoordinateSame(sy, ty, sx, n, m);
        int dx = Math.abs(sx - tx);
        int dy = Math.abs(sy - ty);
        int distance1 = square(sx + tx) + square(dy);
        int distance2 = square(dx) + square(sy + ty);
        int distance3 = square((m - sx + m - tx)) + square(dy);
        int distance4 = square(dx) + square((n - sy + n - ty));
        return Math.min(Math.min(distance1, distance2), Math.min(distance3, distance4));
    }

    private int minDistanceOneCoordinateSame(int a1, int a2, int fixed, int boundaryA, int boundaryFixed) {
        int diff = Math.abs(a1 - a2);
        int option1 = square(diff) + square((boundaryFixed - fixed) * 2);
        int option2 = square(diff) + square(fixed * 2);
        int option3 = (a1 > a2) ? square((boundaryA - a1 + boundaryA - a2)) : square((a1 + a2));
        return Math.min(option1, Math.min(option2, option3));
    }

    private int square(int x) {
        return x * x;
    }
}
