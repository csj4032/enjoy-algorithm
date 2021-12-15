package levelOne;

import java.util.*;

/*
 * 로또의 최고 순위와 최저 순위
 * https://programmers.co.kr/learn/courses/30/lessons/77484
 * */
public class Dial {
	int x;
	int y;
	String letter;
	String direct;

	public Dial(int x, int y, String letter, String direct) {
		this.x = x;
		this.y = y;
		this.letter = letter;
		this.direct = direct;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public String getDirect() {
		return direct;
	}

	@Override
	public String toString() {
		return "Dial{" +
				"x=" + x +
				", y=" + y +
				", letter='" + letter + '\'' +
				", direct='" + direct + '\'' +
				'}';
	}

	public static void main(String[] args) {
		int[] numbers = new int[]{1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
		String result = "";
		String hand = "right";
		Map<String, Dial> map = new HashMap<>();
		map.put("1", new Dial(0, 0, "1", "L"));
		map.put("4", new Dial(0, 1, "4", "L"));
		map.put("7", new Dial(0, 2, "7", "L"));
		map.put("*", new Dial(0, 3, "*", "L"));
		map.put("2", new Dial(1, 0, "2", "D"));
		map.put("5", new Dial(1, 1, "5", "D"));
		map.put("8", new Dial(1, 2, "8", "D"));
		map.put("0", new Dial(1, 3, "0", "D"));
		map.put("3", new Dial(2, 0, "3", "R"));
		map.put("6", new Dial(2, 1, "6", "R"));
		map.put("9", new Dial(2, 2, "9", "R"));
		map.put("#", new Dial(2, 3, "#", "R"));
		Dial left = map.get("*");
		Dial right = map.get("#");
		for (int i = 0; i < numbers.length; i++) {
			int number = numbers[i];
			Dial target = map.get(String.valueOf(number));
			if ("D".equals(target.getDirect())) {
				int left_dis = Math.abs(target.getX() - left.getX()) + Math.abs(target.getY() - left.getY());
				int right_dis = Math.abs(target.getX() - right.getX()) + Math.abs(target.getY() - right.getY());
				if (left_dis == right_dis) {
					if (hand.equals("right")) {
						result += "R";
						right = target;
					} else {
						result += "L";
						left = target;
					}
				} else {
					if (left_dis > right_dis) {
						result += "R";
						right = target;
					} else {
						result += "L";
						left = target;
					}
				}
			} else {
				if (target.getDirect().equals("R")) {
					result += "R";
					right = map.get(String.valueOf(number));
				} else {
					result += "L";
					left = map.get(String.valueOf(number));
				}
			}
		}
		System.out.println(result);
	}
}
