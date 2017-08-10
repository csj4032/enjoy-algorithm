import java.util.stream.IntStream;

public class AllThreeTime {
    public static void main(String[] args) {
        long hours = IntStream.range(0, 25).filter(i -> String.valueOf(i).contains("3")).count();
        long minute = IntStream.range(0, 61).filter(i -> String.valueOf(i).contains("3")).count();
        long total = (hours * 60 * 60) + ((24 - hours) * minute * 60);
        System.out.println(total);
    }
}
