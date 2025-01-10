package levelOne;

/**
 * <a href="https://school.programmers.co.kr/learn/courses/30/lessons/140108">문자열 나누기</a>
 */
public class SplittingString {

    public int solution(String s) {
        int answer = 0, ccount = 0, dcount = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(0)) {
                ccount++;
            } else {
                dcount++;
            }
            if (ccount == dcount) {
                answer++;
                ccount = 0;
                dcount = 0;
            }
        }

        return ccount > 0 || dcount > 0 ? answer + 1 : answer;
    }
}
