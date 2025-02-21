package levelTwo;

import java.util.HashSet;
import java.util.Set;

public class BetweenTwoCircles {

    public long solution(int r1, int r2) {
        long innerCirclePoints = countGridPoints(r1);
        long outerCirclePoints = countGridPoints(r2);
        return outerCirclePoints - innerCirclePoints + 4L;
    }

    public static long countGridPoints(int r) {
        long count = 0;
        long rSquared = (long) r * r;

        for (int x = 0; x <= r; x++) {
            long maxYSquared = rSquared - (long) x * x;
            long maxY = (long) Math.sqrt(maxYSquared);
            count += maxY + 1;
        }
        return 4 * count - 4L * r - 3;
    }
}
