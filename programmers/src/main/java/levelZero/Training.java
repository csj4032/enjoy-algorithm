package levelZero;

public class Training {

    public static void main(String[] args) {
        Training training = new Training();
        training.solution(60, 2, 3);
    }

    public int solution(int number, int n, int m) {
        int answer = 0;
        int nn = number % n;
        int mm = number % m;
        if (nn == 0 & mm == 0) {
            return 1;
        }
        return answer;
    }
}
