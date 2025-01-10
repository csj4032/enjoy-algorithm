package levelOne;

public class SmallSubstring {
    public int solution(String t, String p) {
        int answer = 0;
        int len = p.length();
        long pNum = Long.parseLong(p);
        System.out.println(t);
        for (int i = 0; i <= t.length() - len; i++) {
            long num = Long.parseLong(t.substring(i, i + len));
            if (num <= pNum) answer++;
        }
        return answer;
    }
}
