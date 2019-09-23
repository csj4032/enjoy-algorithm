package skillChecks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BudgetTest {

    @Test
    public void test() {
        Budget budget = new Budget();
       // Assertions.assertEquals(0, budget.solution(new int[]{1, 2, 3}, 9));
        //Assertions.assertEquals(3, budget.solution(new int[]{1, 3, 2, 5, 4}, 9));
        Assertions.assertEquals(4, budget.solution(new int[]{2, 2, 3, 3}, 10));
        //Assertions.assertEquals(0, budget.solution(new int[]{1}, 10));
    }
}