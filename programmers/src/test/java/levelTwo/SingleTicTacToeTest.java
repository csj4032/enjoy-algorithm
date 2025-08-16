package levelTwo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SingleTicTacToeTest {

    @Test
    public void solution() {
        SingleTicTacToe singleTicTacToe = new SingleTicTacToe();
        Assertions.assertEquals(0, singleTicTacToe.solution(new String[]{"XOX", "XOX", "OXX"}));
        Assertions.assertEquals(0, singleTicTacToe.solution(new String[]{"XOX", "OXX", "OXX"}));
        Assertions.assertEquals(0, singleTicTacToe.solution(new String[]{"XOX", "OXX", "XXX"}));
        Assertions.assertEquals(1, singleTicTacToe.solution(new String[]{"XOX", "OXX", "OOO"}));
        Assertions.assertEquals(0, singleTicTacToe.solution(new String[]{"XOX", "OXX", "OOX"}));
        Assertions.assertEquals(0, singleTicTacToe.solution(new String[]{"XOX", "OXX", "XOO"}));
        Assertions.assertEquals(0, singleTicTacToe.solution(new String[]{"XOX", "OXX", "XXO"}));
        Assertions.assertEquals(0, singleTicTacToe.solution(new String[]{"XOX", "OXX", "XXX"}));
        Assertions.assertEquals(0, singleTicTacToe.solution(new String[]{"XOX", "OXX", "OOX"}));
        Assertions.assertEquals(0, singleTicTacToe.solution(new String[]{"XOX", "OXX", "XOO"}));
        Assertions.assertEquals(0, singleTicTacToe.solution(new String[]{"XOX", "OXX", "XXO"}));
        Assertions.assertEquals(1, singleTicTacToe.solution(new String[]{"XOX", "OXX", "OOO"}));
        Assertions.assertEquals(0, singleTicTacToe.solution(new String[]{"XOX", "OXX", "XXX"}));
        Assertions.assertEquals(0, singleTicTacToe.solution(new String[]{"XOX", "OXX", "OOX"}));
        Assertions.assertEquals(0, singleTicTacToe.solution(new String[]{"XOX", "OXX", "XOO"}));
        Assertions.assertEquals(0, singleTicTacToe.solution(new String[]{"XOX", "OXX", "XXO"}));
        Assertions.assertEquals(1, singleTicTacToe.solution(new String[]{"XOX", "OXX", "OOO"}));

    }
}