package euclideanAlgorithm;

public class ChocolatesByNumbers {

    public int solution(int N, int M) {
        return chocolate(N, M);
    }

    private int chocolate(int N, int M) {
        if (M == 1) return N;
        return N / leastCommonMultiple(N, M);
    }

    private int leastCommonMultiple(int n, int m) {
        if (n % m == 0) return m;
        return leastCommonMultiple(m, n % m);
    }

    public static void main(String[] args) {
        System.out.println(new ChocolatesByNumbers().solution(12, 21));
        System.out.println(new ChocolatesByNumbers().solution(10, 4));
        System.out.println(new ChocolatesByNumbers().solution(100000000, 1));
        System.out.println(new ChocolatesByNumbers().solution(415633212, 234332));
    }
}