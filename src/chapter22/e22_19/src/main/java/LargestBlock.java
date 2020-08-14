public class LargestBlock {

    private final int[][] sourceArray;
    private final LargestBlockInfo solution;

    public LargestBlock(int[][] sourceArray) {
        this.sourceArray = sourceArray;
        solution = solve();
    }

    public LargestBlockInfo getSolution() {
        return solution;
    }

    public boolean hasSolution() {
        return solution != null;
    }
}
