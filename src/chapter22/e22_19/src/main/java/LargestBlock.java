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
                    var minValue = Math.min(auxArray[i - 1][j],
                                            Math.min(auxArray[i - 1][j - 1],
                                                     auxArray[i][j - 1]));
                    auxArray[i][j] = minValue + 1;
                } else {
                    auxArray[i][j] = 0;
                }
            }
        }

        return getLargestBlockInfo(auxArray);
    }

    private LargestBlockInfo getLargestBlockInfo(int[][] auxArray) {
        var max = 0;
        var maxX = -1;
        var maxY = -1;
        for (int i = 0; i < auxArray.length; i++) {
            for (int j = 0; j < auxArray[0].length; j++) {
                if (auxArray[i][j] > max) {
                    max = auxArray[i][j];
                    maxX = j;
                    maxY = i;
                }
            }
        }
        maxX -= max - 1;
        maxY -= max - 1;

        if (max == 0) {
            return null;
        } else {
            return new LargestBlockInfo(maxX, maxY, max);
        }
    }
}
