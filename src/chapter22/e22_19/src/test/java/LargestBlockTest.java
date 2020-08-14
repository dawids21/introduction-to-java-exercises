import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LargestBlockTest {

    @Test
    void returns_true_when_it_found_a_solution() {
        int[][] sourceArray = {{1}};
        var largestBlock = new LargestBlock(sourceArray);

        assertTrue(largestBlock.hasSolution());
    }

    @Test
    void returns_first_block_when_only_one_exists() {
        int[][] sourceArray = {{1}};
        var largestBlock = new LargestBlock(sourceArray);

        var largestBlockInfo = largestBlock.getSolution();
        var expected = new LargestBlockInfo(0, 0, 1);

        assertEquals(expected, largestBlockInfo);
    }

    @Test
    void returns_first_block_with_size_of_the_source_array_when_array_is_full() {
        int[][] sourceArray =
                 {{1, 1, 1, 1, 1}, {1, 1, 1, 1, 1}, {1, 1, 1, 1, 1}, {1, 1, 1, 1, 1},
                  {1, 1, 1, 1, 1}};
        var largestBlock = new LargestBlock(sourceArray);

        var largestBlockInfo = largestBlock.getSolution();
        var expected = new LargestBlockInfo(0, 0, sourceArray.length);

        assertEquals(expected, largestBlockInfo);
    }

    @Test
    void returns_false_and_the_solution_is_null_when_there_is_no_solution() {
        int[][] sourceArray = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
        var largestBlock = new LargestBlock(sourceArray);

        var largestBlockInfo = largestBlock.getSolution();

        assertFalse(largestBlock.hasSolution());
        assertNull(largestBlockInfo);
    }
}