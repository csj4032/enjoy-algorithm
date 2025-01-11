package levelOne;

import java.util.ArrayList;
import java.util.List;

public class KnightWeapon {

    public int solution(int number, int limit, int power) {
        int answer = 0;
        for (int i = 1; i <= number; i++) {
            int count = getDivisorCount(i);
            if (count > limit) {
                answer += power;
            } else {
                answer += count;
            }

        }
        return answer;
    }

    private int getDivisorCount(int number) {
        List<Integer> divisors = new ArrayList<>();
        for (int i = 1; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                divisors.add(i);
                if (i != number / i) {
                    divisors.add(number / i);
                }
            }
        }
        return divisors.size();
    }
}
