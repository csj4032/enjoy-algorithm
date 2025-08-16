package levelTwo;

/**
 * Link : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/250135">아날로그 시계</a>
 */
public class AnalogWatch {

    public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
        int startTime = h1 * 3600 + m1 * 60 + s1;
        int endTime = h2 * 3600 + m2 * 60 + s2;
        int alarmCount = 0;
        for (int t = startTime; t < endTime; t++) {
            double hAnglePrev = getHourAngle(t);
            double mAnglePrev = getMinuteAngle(t);
            double sAnglePrev = getSecondAngle(t);

            double hAngleCurr = getHourAngle(t + 1);
            double mAngleCurr = getMinuteAngle(t + 1);
            double sAngleCurr = getSecondAngle(t + 1);

            boolean mCrossed = hasCrossed(sAnglePrev, sAngleCurr, mAnglePrev, mAngleCurr);
            boolean hCrossed = hasCrossed(sAnglePrev, sAngleCurr, hAnglePrev, hAngleCurr);

            if (mCrossed && hCrossed) {
                if (Double.compare(mAngleCurr, hAngleCurr) == 0) {
                    alarmCount++;
                } else {
                    alarmCount += 2;
                }
            } else if (mCrossed || hCrossed) {
                alarmCount++;
            }
        }
        if (startTime == 0 || startTime == 12 * 3600) {
            alarmCount++;
        }
        return alarmCount;
    }

    private double getHourAngle(int totalSeconds) {
        return (totalSeconds % 43200) * (360.0 / 43200.0);
    }

    private double getMinuteAngle(int totalSeconds) {
        return (totalSeconds % 3600) * (360.0 / 3600.0);
    }

    private double getSecondAngle(int totalSeconds) {
        return (totalSeconds % 60) * (360.0 / 60.0);
    }

    private boolean hasCrossed(double sPrev, double sCurr, double otherPrev, double otherCurr) {
        if (sPrev > sCurr) {
            return (sPrev < otherPrev && otherCurr <= 360) || (sCurr >= otherCurr && otherPrev >= 0);
        }
        return sPrev < otherPrev && sCurr >= otherCurr;
    }
}
