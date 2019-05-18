package futureTraining;

public class TreeHeight {

	static int max = 0;

	public int solution(Tree T) {
		depthFirstSearch(T, 0);
		return max;
	}

	private void depthFirstSearch(Tree t, int depth) {
		if (null != t.l) depthFirstSearch(t.l, depth + 1);
		if (null != t.r) depthFirstSearch(t.r, depth + 1);
		if(max < depth) max = depth;
		return;
	}
}

class Tree {
	public int x;
	public Tree l;
	public Tree r;
}
