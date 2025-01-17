package levelOne;

import org.junit.jupiter.api.Test;

class FoldingBanknotesTest {

    @Test
    public void test() {
        FoldingBanknotes foldingBanknotes = new FoldingBanknotes();
        foldingBanknotes.solution(new int[]{30, 15}, new int[]{26, 17});
        foldingBanknotes.solution(new int[]{50, 50}, new int[]{100, 241});
    }
}