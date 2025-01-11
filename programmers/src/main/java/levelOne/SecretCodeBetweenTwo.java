package levelOne;

public class SecretCodeBetweenTwo {

    public String solution(String s, String skip, int index) {
        String answer = "";
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int count = 0;
            while (count < index) {
                ch = (char) (ch + 1);
                if (ch > 122) ch = (char) (97);
                if (skip.contains(String.valueOf(ch))) continue;
                count++;
            }
            answer += ch;
        }
        System.out.println(answer);
        return answer;
    }
}
