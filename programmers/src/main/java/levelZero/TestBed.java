package levelZero;

import java.util.ArrayList;
import java.util.List;

public class TestBed {

    public String[] solution(String[] picture, int k) {
        int h = picture.length;
        List<String> list = new ArrayList<>();
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < k; j++) {
                StringBuilder sb = new StringBuilder();
                for (int l = 0; l < picture[i].length(); l++) {
                    sb.append(String.valueOf(picture[i].charAt(l)).repeat(k));
                }
                list.add(sb.toString());
            }
        }
        return list.stream().toArray(String[]::new);
    }

    public static void main(String[] args) {
        TestBed testBed = new TestBed();
        String[] result = testBed.solution(new String[]{".xx...xx.", "x..x.x..x", "x...x...x", ".x.....x.", "..x...x..", "...x.x...", "....x...."}, 2);
        // int result = testBed.solution(new int[]{3, 4, 5, 2, 5, 4, 6, 7, 3, 7, 2, 2, 1});
        // int[] result = testBed.solution(new int[]{1, 2, 3, 4, 5, 6});
        // int[] result = testBed.solution(new int[]{58, 172, 746, 89});
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}