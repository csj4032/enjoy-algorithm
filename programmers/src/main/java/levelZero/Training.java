package levelZero;

public class Training {

    public static void main(String[] args) {
        Training training = new Training();
        training.solution(60, 2, 3);
    }

    public int solution(int number, int n, int m) {
        int[] array = new int[]{10, 20, 30, 4, 5, 6};
        int answer = 0;
        for (int i = 0; i < array.length; i++) {
            answer += array[i];
        }
        System.out.println(answer);
        return answer;
    }
}
