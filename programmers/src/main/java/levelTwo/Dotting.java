package levelTwo;

public class Dotting {

    public long solution(int k, int d) {
        int answer = 0;
        long dSquared = (long) d * d;
        for (int i = 0; i <= d; i += k) {
            long maxYSquared = dSquared - (long) i * i;
            int maxY = (int) Math.sqrt(maxYSquared);
            answer += Math.ceil(maxY / k)+1;
        }
        return answer;
    }
}
