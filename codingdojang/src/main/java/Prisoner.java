public class Prisoner {

	public static void main(String[] args) {
		int p = 120;
		int c = 0;
		for (int i = 1; i <= p; i++) {
			for (int j = 1; j <= p; j++) {
				if (j * j == i) {
					c++;
				}
			}
		}
		System.out.println(c);
	}
}