package futureTraining;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TreeHeightTest {

	@Test
	void solution() {
		Tree tree20 = new Tree();
		tree20.x = 20;
		Tree tree21 = new Tree();
		tree21.x = 21;

		Tree tree3 = new Tree();
		tree3.x = 3;
		tree3.r = tree20;
		tree3.l = tree21;

		Tree tree1 = new Tree();
		tree1.x = 1;

		Tree tree10 = new Tree();
		tree10.x = 10;
		tree10.l = tree1;

		Tree root = new Tree();
		root.x = 5;
		root.l = tree3;
		root.r = tree10;

		TreeHeight treeHeight = new TreeHeight();
		int result = treeHeight.solution(root);
		Assertions.assertEquals(2, result);
	}
}