package levelOne;


public class NumberBuddy {

    public String solution(String X, String Y) {
        int[] xx = new int[10], yy = new int[10];
        for (char c : X.toCharArray()) xx[c - '0']++;
        for (char c : Y.toCharArray()) yy[c - '0']++;
        StringBuilder sb = new StringBuilder();
        for (int i = 9; i >= 0; i--) {
            int count = Math.min(xx[i], yy[i]);
            sb.append(String.valueOf(i).repeat(count));
        }
        String result = sb.toString();
        return result.isEmpty() ? "-1" : (result.startsWith("0") ? "0" : result);
    }
}