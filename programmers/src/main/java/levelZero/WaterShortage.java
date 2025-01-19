package levelZero;

public class WaterShortage {
    public int solution(int storage, int usage, int[] change) {
        int total_usage = 0;
        for (int i = 0; i < change.length; i++) {
            usage += usage * change[i] / 100;
            System.out.println(usage);
            total_usage += usage;
            if (total_usage > storage) {
                return 1;
            }
        }
        return -1;
    }
}