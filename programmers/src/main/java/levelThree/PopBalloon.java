package levelThree;

/**
 * Link :https://school.programmers.co.kr/learn/courses/30/lessons/68646
 **/
public class PopBalloon {

    public int solution(int[] a) {
        int n = a.length;
        if (n == 2) return 2;

        int leftMin[] = new int[n];
        int left = a[0];
        leftMin[0] = a[0];
        for (int i = 1; i < n; i++) {
            if (left > a[i]) left = a[i];
            leftMin[i] = left;
        }

        int rightMin[] = new int[n];
        int right = a[n - 1];
        rightMin[n - 1] = a[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            if (right > a[i]) right = a[i];
            rightMin[i] = right;
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            if (leftMin[i] < a[i] && rightMin[i] < a[i]) {
                continue;
            }
            answer++;
        }
        return answer;
    }
}
