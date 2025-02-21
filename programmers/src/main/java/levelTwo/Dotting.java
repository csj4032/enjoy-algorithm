package levelTwo;

public class Dotting {

    public long solution(int k, int d) {
        long answer = 0;
        long dSquared = (long) d * d;
        for (int i = 0; i <= d; i += k) {
            long maxYSquared = dSquared - (long) i * i;
            long maxY = (long) Math.sqrt(maxYSquared);
            answer += (long) (Math.ceil((double) maxY / k) + 1);
        }
        return answer;
    }
}
