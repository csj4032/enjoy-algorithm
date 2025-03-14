package levelTwo;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Link :<a href="https://programmers.co.kr/learn/courses/30/lessons/12977">요격 시스템</a>
 * Category : 탐욕법(Greedy)
 * Description : 타켓 지점의 끝점과 시작점이 겹치는지 확인하는 문제
 */
public class InterceptionSystem {

    public int solution(int[][] targets) {
        int answer = 0;
        Arrays.sort(targets, Comparator.comparingInt(a -> a[1]));
        int compare = -1;
        for (int[] target : targets) {
            if (target[0] >= compare) {
                compare = target[1];
                answer++;
            }
        }
        return answer;
    }
}
