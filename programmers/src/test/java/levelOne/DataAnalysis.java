package levelOne;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Predicate;

public class DataAnalysis {

    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        return Arrays.stream(data).map(arr -> new Data(arr[0], arr[1], arr[2], arr[3]))
                .filter(getPredicate(ext, val_ext))
                .sorted(getComparator(sort_by))
                .map(d -> new int[]{d.code, d.date, d.maximum, d.remain})
                .toArray(int[][]::new);
    }

    private Predicate<Data> getPredicate(String ext, int val_ext) {
        switch (ext) {
            case "code":
                return d -> d.code < val_ext;
            case "date":
                return d -> d.date < val_ext;
            case "maximum":
                return d -> d.maximum < val_ext;
            case "remain":
                return d -> d.remain < val_ext;
            default:
                throw new IllegalArgumentException("Invalid ext: " + ext);
        }
    }

    private Comparator<Data> getComparator(String sort_by) {
        switch (sort_by) {
            case "code":
                return Comparator.comparing(Data::getCode);
            case "date":
                return Comparator.comparing(Data::getDate);
            case "maximum":
                return Comparator.comparing(Data::getMaximum);
            case "remain":
                return Comparator.comparing(Data::getRemain);
            default:
                throw new IllegalArgumentException("Invalid sort_by: " + sort_by);
        }
    }
}

class Data {
    public Integer code;
    public Integer date;
    public Integer maximum;
    public Integer remain;

    public Data(Integer code, Integer date, Integer maximum, Integer remain) {
        this.code = code;
        this.date = date;
        this.maximum = maximum;
        this.remain = remain;
    }

    public Integer getCode() {
        return code;
    }

    public Integer getDate() {
        return date;
    }

    public Integer getMaximum() {
        return maximum;
    }

    public Integer getRemain() {
        return remain;
    }

    @Override
    public String toString() {
        return "Data{" +
                "code=" + code +
                ", date=" + date +
                ", maximum=" + maximum +
                ", remain=" + remain +
                '}';
    }
}
