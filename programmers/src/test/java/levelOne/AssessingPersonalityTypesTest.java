package levelOne;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AssessingPersonalityTypesTest {

    @Test
    public void test() {
        AssessingPersonalityTypes assessingPersonalityTypes = new AssessingPersonalityTypes();
        Assertions.assertEquals("TCMA", assessingPersonalityTypes.solution(new String[]{"AN", "CF", "MJ", "RT", "NA"}, new int[]{5, 3, 2, 7, 5}));
    }
}