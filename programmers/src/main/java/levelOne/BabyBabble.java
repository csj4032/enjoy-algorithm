package levelOne;

public class BabyBabble {
    public int solution(String[] babbling) {
        int answer = 0;
        String[] words = {"aya", "ye", "woo", "ma"};
        for (String babble : babbling) {
            boolean isValid = true;
            for (String word : words) {
                if (babble.contains(word + word)) {
                    isValid = false;
                    break;
                }
            }
            if (isValid) {
                for (String word : words) {
                    babble = babble.replace(word, " ");
                }
                babble = babble.replace(" ", "");
                if (!babble.isEmpty()) {
                    isValid = false;
                }
            }
            if (isValid) answer++;
        }
        return answer;
    }
}
