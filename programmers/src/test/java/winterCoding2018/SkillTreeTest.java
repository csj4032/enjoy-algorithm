package winterCoding2018;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SkillTreeTest {

	@Test
	public void test() {
		SkillTree skillTree = new SkillTree();
		Assertions.assertEquals(2, skillTree.solution("A", new String[]{"CD", "BC"}));
		Assertions.assertEquals(0, skillTree.solution("AC", new String[]{"CD", "BC"}));
		Assertions.assertEquals(1, skillTree.solution("ABCDEF", new String[]{ "ABC"}));
		Assertions.assertEquals(1, skillTree.solution("ABC", new String[]{"ACB", "AB"}));
		Assertions.assertEquals(1, skillTree.solution("ABC", new String[]{"ABC", "CBA"}));
		Assertions.assertEquals(2, skillTree.solution("CBD", new String[]{"BACDE", "CBADF", "AECB", "BDA"}));
		Assertions.assertEquals(1, skillTree.solution("ABC", new String[]{"AD"}));
		Assertions.assertEquals(2, skillTree.solution("A", new String[]{"ABCDEF", "FA"}));
    	Assertions.assertEquals(1, skillTree.solution("AB", new String[]{"ABC"}));
	}
}