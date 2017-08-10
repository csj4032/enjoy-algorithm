public class HourMinute {

	public static void main(String[] args) {
		int c = 0;
		for (Double i = 0D; i <= 60 * 24; i++) {
			Double h = (i * 0.5);
			Double m = (i * 6) % 360;
			Double hm = Math.abs(h - m) % 360;

			if (hm == 90 || hm == 270) {
				System.out.printf("%02d:%02d \n", h.intValue() / 30, m.intValue());
				c++;
			}
		}
		System.out.println(c);
	}
}