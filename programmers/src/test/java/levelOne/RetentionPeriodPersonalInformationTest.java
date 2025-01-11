package levelOne;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RetentionPeriodPersonalInformationTest {

    @Test
    public void test() {
        RetentionPeriodPersonalInformation retentionPeriodPersonalInformation = new RetentionPeriodPersonalInformation();
        Assertions.assertArrayEquals(new int[]{1, 3},
                retentionPeriodPersonalInformation.solution("2022.05.19", new String[]{"A 6", "B 12", "C 3"}, new String[]{"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"}));

        Assertions.assertArrayEquals(new int[]{1, 4, 5},
                retentionPeriodPersonalInformation.solution("2020.01.01", new String[]{"Z 3", "D 5"}, new String[]{"2019.01.01 D", "2019.11.15 Z", "2019.08.02 D", "2019.07.01 D", "2018.12.28 Z"}));
    }
}