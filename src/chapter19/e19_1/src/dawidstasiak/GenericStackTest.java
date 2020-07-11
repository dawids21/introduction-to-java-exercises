package dawidstasiak;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GenericStackTest {

    GenericStack<Integer> stackOfIntegers;

    @BeforeEach
    void setUp() {
        stackOfIntegers = new GenericStack<>();
    }

    @Test
    void new_stacks_should_be_empty() {
        assertTrue(stackOfIntegers.isEmpty());
    }

    @Test
    void pushed_element_should_be_return_at_popping() {
        stackOfIntegers.push(5);
        assertEquals(5, stackOfIntegers.pop());
    }

    @Test
    void after_peeking_element_should_still_be_at_stack() {
        stackOfIntegers.push(5);
        assertAll(() -> assertEquals(5, stackOfIntegers.peek()),
                  () -> assertEquals(1, stackOfIntegers.getSize()));

    }

    @Test
    void pushed_elements_should_be_popped_in_reversed_order() {
        stackOfIntegers.push(4);
        stackOfIntegers.push(2);
        stackOfIntegers.push(-2);
        assertAll(() -> assertEquals(-2, stackOfIntegers.pop()),
                  () -> assertEquals(2, stackOfIntegers.pop()),
                  () -> assertEquals(4, stackOfIntegers.pop()));
    }

    @Test
    void to_string_method_should_display_all_elements(){
        stackOfIntegers.push(4);
        stackOfIntegers.push(3);
        assertEquals("stack: [4, 3]", stackOfIntegers.toString());
    }
}