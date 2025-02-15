package levelTwo;

public class NbaseGame {

    public String solution(int n, int t, int m, int p) {
        StringBuilder answer = new StringBuilder();
        StringBuilder sb = new StringBuilder();
        int num = 0;
        while (sb.length() < t * m) sb.append(Integer.toString(num++, n));
        for (int i = 0; i < t; i++) {
            answer.append(sb.charAt(i * m + (p - 1)));
        }
        return answer.toString().toUpperCase();
    }
}
