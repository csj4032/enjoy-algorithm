package levelTwo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Link : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/147354">테이블 해시 함수</a>
 * Category : Simulation
 */
public class TableHashFunction {

    public static class Tuple implements Comparable<Tuple> {
        public int primary;
        public int second;
        public int[] values;
        public int module;

        public Tuple(int index, int primary, int second, int[] values) {
            this.primary = primary;
            this.second = second;
            this.values = values;
        }

        private int getModule(int index) {
            int sum = 0;
            for (int value : values) sum += value % index;
            return sum;
        }

        @Override
        public int compareTo(Tuple other) {
            if (other.second == second) return Integer.compare(other.primary, primary);
            return Integer.compare(second, other.second);
        }

        @Override
        public String toString() {
            return "Tuple{" +
                    "primary=" + primary +
                    ", second=" + second +
                    ", values=" + Arrays.toString(values) +
                    ", module=" + module +
                    '}';
        }
    }

    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;
        List<Tuple> table = new ArrayList<>();
        for (int i = 0; i < data.length; i++) {
            table.add(new Tuple(i + 1, data[i][0], data[i][col - 1], data[i]));
        }
        Collections.sort(table);
        for (int i = row_begin; i <= row_end; i++) {
            answer ^= table.get(i - 1).getModule(i);
        }
        return answer;
    }
}
