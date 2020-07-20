import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AppTest {
    @Test
    void should_return_the_symbols_are_in_pairs() {
        assertTrue(App.areGroupingSymbolsInPairs("(123 + 3) * {2 + ( 2 + [ 3 - 3 ] - 3) * 5}"));
    }

    @Test
    void should_return_symbols_are_not_in_pairs() {
        assertFalse(App.areGroupingSymbolsInPairs("(a{b)}"));
    }
}