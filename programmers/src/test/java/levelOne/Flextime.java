package levelOne;

public class Flextime {

    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = timelogs.length;
        for (int i = 0; i < timelogs.length; i++) {
            for (int j = 0; j < 7; j++) {
                int dayOfWeek = (startday + j) % 7;
                if (dayOfWeek == 6 || dayOfWeek == 0) continue;
                int limit = schedules[i] + 10;
                int mod = limit % 100;
                int div = limit / 100;
                if (mod > 59) limit = (div + 1) * 100 + (mod - 59);
                if (limit < timelogs[i][j]) {
                    answer--;
                    break;
                }
            }
        }
        return answer;
    }
}
