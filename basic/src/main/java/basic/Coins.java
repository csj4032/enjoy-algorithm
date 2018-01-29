package basic;

public class Coins {
	static int[] n = {3,2,1};

	public static void main(String[] args) {
		System.out.println(count(100, 0));
	}

	private static int count(int amount, int m) {
		if (amount == 0)
			return 1;
		else if (m >= n.length || amount < 0)
			return 0;
		else
			return count(amount - n[m], m) + count(amount, m + 1);
	}
}
