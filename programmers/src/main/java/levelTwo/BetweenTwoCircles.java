package levelTwo;

public class BetweenTwoCircles {

    public long solution(int r1, int r2) {
        return countGridPoints(r1, r2);
    }

    public static long countGridPoints(int r1, int r2) {
        long count = 0L;
        long r1Squared = (long) r1 * r1;
        long r2Squared = (long) r2 * r2;

        for (int x = 0; x <= r2; x++) {
            long maxYSquared = r2Squared - (long) x * x;
            long maxY = (long) Math.sqrt(maxYSquared);
            long minYSquared = r1Squared - (long) x * x;
            long minY = minYSquared > 0 ? (long) Math.ceil(Math.sqrt(minYSquared)) : 0;
            count += (maxY - minY + 1);
        }
        return count * 4 - ((r2 - r1 + 1) * 4L);
    }
}
