package levelOne;

import org.junit.jupiter.api.Test;

class RunningRaceTest {

    @Test
    public void test() {
        RunningRace runningRace = new RunningRace();
        runningRace.solution(new String[]{"mumu", "soe", "poe", "kai", "mine"}, new String[]{"kai", "kai", "mine", "mine"});
    }
}