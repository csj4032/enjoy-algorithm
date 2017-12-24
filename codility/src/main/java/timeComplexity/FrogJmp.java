package timeComplexity;

public class FrogJmp {

	public static void main(String[] args) {
		System.out.println(solution(10, 85, 30));
	}

	private static int solution(int X, int Y, int D) {
		return (int) Math.ceil((Double.valueOf(Y) - Double.valueOf(X)) / Double.valueOf(D));
	}
}