import java.util.Scanner;

public class LCDDisplay {

	static int[][] map = new int[10][5];

	static {
		map[0] = new int[]{1, 4, 0, 4, 1};
	}

	static int[][] map2 = new int[5][3];
	static {
		map2[0] = new int[]{0,0,0};
		map2[1] = new int[]{0,1,0};
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String[] s = sc.next().split("");
		int tLen = 5 + ((n - 1) * 2);
		int sLen = s.length;
		int nLen = 2 + n;
		int[][][] temp = new int[tLen][sLen][nLen];

		for (int i = 0; i < tLen ; i++) {
			for (int j = 0; j < sLen ; j++) {
				temp[i][j] = map2[map[Integer.valueOf(s[j])][i]];
			}
		}
	}
}

// 0 >> [0 ,0 ,0]
// 1 >> [0 ,1 ,0]
// 2 >> [2 ,0 ,0]
// 3 >> [0 ,0 ,2]
// 4 >> [1 ,0 ,1]

// [ [[0 ,1 ,0]], [[2, 0, 2]], [[0 ,0 ,0]], [[2, 0, 2]], [[0, 1, 0]] ]
// -
//| |
//
//| |
// -

//[[],[]]
//[[[],[]],[[],[]]]
//[[],[]]
//[[[],[]],[[],[]]]
//[[],[]]