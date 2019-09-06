package winterCoding2018;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SkillTreeTest {

    @Test
    public void test() {
        SkillTree skillTree = new SkillTree();
//        Assertions.assertEquals(0, skillTree.solution("A", new String[]{"CD", "BC"}));
//        Assertions.assertEquals(0, skillTree.solution("AC", new String[]{"CD", "BC"}));
        Assertions.assertEquals(1, skillTree.solution("ABCDEF", new String[]{"ABEF", "ABC"}));
//        Assertions.assertEquals(1, skillTree.solution("ABC", new String[]{"AC", "AB"}));
//        Assertions.assertEquals(1, skillTree.solution("ABC", new String[]{"ABC", "CBA"}));
//        Assertions.assertEquals(2, skillTree.solution("CBD", new String[]{"BACDE", "CBADF", "AECB", "BDA"}));
//        Assertions.assertEquals(1, skillTree.solution("ABC", new String[]{"AD"}));
    }
}