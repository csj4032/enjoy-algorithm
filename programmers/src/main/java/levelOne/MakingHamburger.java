package levelOne;

public class MakingHamburger {

    public int solution(int[] ingredient) {
        int answer = 0;
        StringBuilder sb = new StringBuilder();
        for (int i : ingredient) {
            sb.append(i);
            int len = sb.length();
            if (len >= 4 && sb.substring(len - 4).contains("1231")) {
                sb.delete(len - 4, len);
                answer++;
            }
        }
        return answer;
    }
}
