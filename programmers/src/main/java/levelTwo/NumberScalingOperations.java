package levelTwo;

public class NumberScalingOperations {

    public int solution(int[] players, int m, int k) {
        int answer = 0;
        int[] currentSeries = new int[players.length];
        for (int i = 0; i < players.length; i++) {
            int current = players[i];
            int currentServer = getLiveServer(i, k, currentSeries);
            int currentCapacity = (currentServer * m) + (m - 1);
            if (current > currentCapacity) {
                currentSeries[i] = (current / m) - (currentCapacity / m);
                answer += currentSeries[i];
            }
        }
        return answer;
    }

    public static int getLiveServer(int index, int limit, int[] currentSeries) {
        int server = 0;
        int start = Math.max(index - (limit - 1), 0);
        for (int i = start; i <= index; i++) {
            server += currentSeries[i];
        }
        return server;
    }
}
