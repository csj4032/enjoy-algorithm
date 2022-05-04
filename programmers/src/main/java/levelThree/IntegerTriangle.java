package levelThree;

import java.util.Arrays;

public class IntegerTriangle {

	public int solution(int[][] triangle) {
		System.out.println(Arrays.deepToString(triangle));
		System.out.println(triangle.length);
		int answer = 0;
		return answer;
	}

	public static void main(String[] args) {
		int[][] triangle = new int[5][];
		triangle[0] = new int[]{7};
		triangle[1] = new int[]{3, 8};
		triangle[2] = new int[]{8, 1, 0};
		triangle[3] = new int[]{8, 1, 0};
		triangle[3] = new int[]{8, 1, 0};
		IntegerTriangle integerTriangle = new IntegerTriangle();
		System.out.println(integerTriangle.solution(triangle));
	}
}
