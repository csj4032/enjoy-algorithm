import java.util.Stack;

public class Question3 {

	public static void main(String[] args) {
		//String n = "(())";
		//String n = "()(())";
		String n = "()";
		String[] m = n.split("");
		Stack<String> s = new Stack<>();
		String o = "(";
		int c = 0;
		for (int i = 0; i < m.length; i++) {
			if (o.equals(m[i])) {
				s.push(m[i]);
			} else {
				s.pop();
				c++;
			}
		}
		System.out.println(c);
		System.out.println(String.format("%3s", Integer.toBinaryString(7)).replace(' ', '0'));
	}
}