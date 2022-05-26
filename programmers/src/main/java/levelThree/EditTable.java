package levelThree;

import java.util.*;

/**
 *  명령이 끝나고 누락된 줄을 찾아서 LIFO 로 X 를 삽입
 */
public class EditTable {

	public String solution(int n, int k, String[] cmd) {

		StringBuilder sb = new StringBuilder();
		Stack<Integer> stack = new Stack<>();
		int size = n;
		int length = cmd.length;

		StringBuffer sbb = new StringBuffer();
		sbb.append("aaa");
		sbb.insert(1, "b");
		System.out.println(sbb);

		for (int i = 0; i < length; i++) {
			char c = cmd[i].charAt(0);

			if (c == 'U') {
				k -= Integer.valueOf(cmd[i].substring(2));
			} else if (c == 'D') {
				k += Integer.valueOf(cmd[i].substring(2));
			} else if (c == 'C') {
				stack.push(k);
				size -= 1;
				if (k == size) k -= 1;
			} else {
				int r = stack.pop();
				if (k >= r) k += 1;
				size += 1;
			}
		}

		for (int i = 0; i < size; i++) sb.append('O');

		while (!stack.isEmpty()) {
			int kk = stack.pop().intValue();
			sb.insert(kk, 'X');
		}
		return sb.toString();
	}
}