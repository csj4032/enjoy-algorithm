package levelOne;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class DeckCardsTest {

    @Test
    public void test() {
        DeckCards deckCards = new DeckCards();
        // Assertions.assertEquals("Yes", deckCards.solution(new String[]{"i", "drink", "water"}, new String[]{"want", "to"}, new String[]{"i", "want", "to", "drink", "water"}));
        // Assertions.assertEquals("No", deckCards.solution(new String[]{"i", "water", "drink"}, new String[]{"want", "to"}, new String[]{"i", "want", "to", "drink", "water"}));
        Assertions.assertEquals("Yes", deckCards.solution(new String[]{"i", "am"}, new String[]{"boy", "a"}, new String[]{"i", "am", "boy", "a"}));
        //Assertions.assertEquals("Yes", deckCards.solution(new String[]{"A", "C", "E"}, new String[]{"B", "D", "F"}, new String[]{"A", "B", "D", "C"}));
    }
}