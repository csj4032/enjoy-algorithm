package levelTwo;

/**
 * Link : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/148653">마법의 엘리베이터</a>
 * Category : Recursive, Role Search
 */
public class MagicElevator {

    public int solution(int storey) {
        return recursive(storey, 0);
    }

    public static int recursive(int num, int steps) {
        if (num == 0) return steps;
        int lastDigit = num % 10;
        int nextNum = num / 10;
        if (lastDigit == 5) {
            if (nextNum % 10 < 5) {
                return recursive(nextNum, steps + lastDigit);
            } else {
                return recursive(nextNum + 1, steps + (10 - lastDigit));
            }
        } else if (lastDigit < 5) {
            return recursive(nextNum, steps + lastDigit);
        } else {
            return recursive(nextNum + 1, steps + (10 - lastDigit));

        }
    }
}
