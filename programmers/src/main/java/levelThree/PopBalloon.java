package levelThree;

/**
 * Link :https://school.programmers.co.kr/learn/courses/30/lessons/68646
 **/
public class PopBalloon {

    public int solution(int[] a) {
        int answer = 0;
        int n = a.length;
        for (int i = 0; i < n; i++) {
            boolean canPop = true;
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                if (a[i] > a[j]) {
                    canPop = false;
                    break;
                }
            }
            if (canPop) answer++;
        }
        return answer;
    }
}
