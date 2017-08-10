public class StringCompression {

	public static void main(String[] args) {
		String s[] = "aaabbcccccca".split("");
		StringBuffer r = new StringBuffer();
		Integer c = 1;
		String b = s[0];
		r.append(s[0]);
		for (int i = 1; i < s.length; i++) {
			System.out.println(s[i] + " " + b);
			if (s[i].equals(b)) {
				c++;
			} else {
				r.append(c);
				r.append(s[i]);
				c = 1;
				b = s[i];
			}
			if(i == s.length-1) {
				r.append(c);
			}
		}
		System.out.println(r);
	}
}