package levelZero;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/120868
 */
public class TriangleInequalityTheorem {

    public int solution(int[] sides) {
        int min = Math.min(sides[0], sides[1]);
        int max = Math.max(sides[0], sides[1]);
        int limit = sides[0] + sides[1];
        return limit - (max - min) - 1;
    }
}
