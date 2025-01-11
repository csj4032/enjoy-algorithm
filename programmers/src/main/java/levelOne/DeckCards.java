package levelOne;

import java.util.Queue;

/**
 * <a href="https://school.programmers.co.kr/learn/courses/30/lessons/159994">카드 뭉</a>
 */
public class DeckCards {

    public String solution(String[] cards1, String[] cards2, String[] goal) {
        int c1 = 0;
        int c2 = 0;
        for (String keyword : goal) {
            if (c1 < cards1.length && keyword.equals(cards1[c1])) {
                c1++;
            } else if (keyword.equals(cards2[c2])) {
                c2++;
            } else {
                return "No";
            }
        }
        return "Yes";
    }
}
