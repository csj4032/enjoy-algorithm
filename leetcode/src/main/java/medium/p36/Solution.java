package medium.p36;

import java.util.HashMap;

public class Solution {

	public boolean isValidSudoku(char[][] board) {
		for (int i = 0; i < 9; i++) {
			HashMap<Character, Character> map1 = new HashMap<>();
			HashMap<Character, Character> map2 = new HashMap<>();
			for (int j = 0; j < 9; j++) {
				char k1 = board[i][j];
				if (k1 != '.') {
					if (map1.containsKey(k1)) {
						return false;
					} else {
						map1.put(k1, k1);
					}
				}

				char k2 = board[j][i];
				if (k2 != '.') {
					if (map2.containsKey(k2)) {
						return false;
					} else {
						map2.put(k2, k2);
					}
				}
			}
		}

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				HashMap<Character, Character> map = new HashMap<>();
				for (int k = 0; k < 9; k++) {
					int row = (i * 3) + (k / 3);
					int col = (j * 3) + (k % 3);
					char l = board[row][col];
					if (l != '.') {
						if (map.containsKey(l)) {
							return false;
						} else {
							map.put(l, l);
						}
					}
				}
			}
		}

		return true;
	}
}