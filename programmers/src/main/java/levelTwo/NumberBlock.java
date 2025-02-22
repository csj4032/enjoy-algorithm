package levelTwo;

/**
 * Link : https://school.programmers.co.kr/learn/courses/30/lessons/12923
 * Category : 구현, 수학
 */
public class NumberBlock {

    public int[] solution(long begin, long end) {
        int max_number = 10_000_000;
        int length = (int) (end - begin) + 1;
        int[] answer = new int[length];
        for (long position = begin; position <= end; position++) {
            int limit = (int) Math.min(max_number, position / 2);
            int sqrtPos = (int) Math.sqrt(position);
            int candidate = 0;
            for (long j = 1; j <= sqrtPos; j++) {
                if (position % j == 0) {
                    int factor1 = (int) j;
                    int factor2 = (int) (position / j);
                    if (factor1 <= limit && candidate < factor1) candidate = factor1;
                    if (factor2 <= limit && candidate < factor2) candidate = factor2;
                }
            }
            answer[(int) (position - begin)] = candidate;
            if (position == 1) answer[(int) position] = 0;
        }
        return answer;
    }

    public int[] solution2(long begin, long end) {
        int length = (int) (end - begin) + 1;
        int[] answer = new int[length];
        for (int i = 0; i < length; i++) {
            long target = begin + i;
            answer[i] = 0;
            if (target == 1) continue;
            for (long j = 2; j < target; j++) {
                if (target % j == 0) {
                    answer[i] = (int) (target / j);
                }
            }
            if (answer[i] == 0) answer[i] = 1;
        }
        return answer;
    }
}