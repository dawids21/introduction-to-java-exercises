import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class InfixToPostfixTest {
    @Test
    void should_convert_postfix_notation_to_infix() {
        assertAll(() -> assertEquals("1 2 + 3 *", InfixToPostfix.convert("(1 + 2) * 3")),
                  () -> assertEquals("2 1 3 + *", InfixToPostfix.convert("2 * (1 + 3)")),
                  () -> assertEquals("4 2 3 + 6 * -", InfixToPostfix.convert("4 - (2 + 3) * 6")),
                  () -> assertEquals("8 3 6 * - 2 +", InfixToPostfix.convert("(8 - 3 * 6) + 2")));
    }
}