package levelZero;

/**
 * <a href="https://school.programmers.co.kr/learn/courses/30/lessons/120843">공 던지기</a>
 **/
public class ThrowingBall {

    public int solution(int[] numbers, int k) {
        return (k - 1) * 2 % numbers.length + 1;
    }
}
