package levelZero;

public class FindingCompositeNumbers {

    public int solution(int n) {
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            if (isComposite(i)) {
                answer++;
            }
        }
        return answer;
    }

    private boolean isComposite(int num) {
        if (num <= 1) return false;
        int len = (num / 2) + 1;
        for (int j = 2; j < len; j++) {
            if (num % j == 0) return true;
        }
        return false;
    }
}
