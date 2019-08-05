package elevenStreet.test02;

public class Solution1 {

	public int solution(int A, int B) {
		String a = String.valueOf(A);
		String b = String.valueOf(B);
		int c = -1;
		for (int i = 0; i < b.length(); i++) {
			if (i + a.length() <= b.length()) {
				if (b.substring(i, i + a.length()).equals(a) && c < i) c = i;
			}
		}
		return c;
	}

	public static void main(String[] args) {
		Solution1 solution1 = new Solution1();
		System.out.println(solution1.solution(78, 195378678));
		System.out.println(solution1.solution(57, 57378657));
		System.out.println(solution1.solution(57, 153786));
	}
}