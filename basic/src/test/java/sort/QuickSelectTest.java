package sort;

import org.junit.jupiter.api.Test;

class QuickSelectTest {

    @Test
    public void quickSelectTest() {
        QuickSelect quickSelect = new QuickSelect();
        quickSelect.quickSelect(new int[]{5, 1, 3, 4, 2}, 2);
    }
}