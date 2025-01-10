package levelOne;

public class SplittingString {

    public int solution(String s) {
        char c = s.charAt(0);
        int answer = 0;
        int ccount = 0;
        int dcount = 0;
        int index = 0;
        int length = s.length();
        int count = 0;
        int start = 0;
        int end = s.length();
        String ss = s.substring(start, end);
        while (true) {
            if (c == ss.charAt(index)) {
                ccount++;
            } else {
                dcount++;
            }
            index++;
            if (ccount == dcount) {
                answer++;
                ss = ss.substring(index);
                if (ss.length() < 2) break;
                c = ss.charAt(0);
                index = 0;
                ccount = 0;
                dcount = 0;
            }
            count++;
            System.out.println(ss + " " + index + " " + c + " " + ccount + " " + dcount);
        }
        return answer;
    }
}
