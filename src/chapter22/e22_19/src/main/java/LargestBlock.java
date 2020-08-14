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

    private LargestBlockInfo solve() {
        var auxArray = new int[sourceArray.length][sourceArray[0].length];
        System.arraycopy(sourceArray[0], 0, auxArray[0], 0, sourceArray[0].length);
        for (int i = 0; i < sourceArray.length; i++) {
            auxArray[i][0] = sourceArray[i][0];
        }

        for (int i = 1; i < sourceArray.length; i++) {
            for (int j = 1; j < sourceArray[0].length; j++) {
                if (sourceArray[i][j] == 1) {
                    var minValue = Math.min(sourceArray[i - 1][j],
                                            Math.min(sourceArray[i - 1][j - 1],
                                                     sourceArray[i][j - 1]));
                    auxArray[i][j] = minValue + 1;
                } else {
                    auxArray[i][j] = 0;
                }
            }
        }

        return getLargestBlockInfo(auxArray);
    }

    private LargestBlockInfo getLargestBlockInfo(int[][] auxArray) {
        //TODO implement getLargestBlockInfo
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
