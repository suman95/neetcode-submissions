class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();

        if (matrix == null || matrix.length == 0
                || matrix[0].length == 0) {
            return res;
        }

        int rowMin = 0;
        int rowMax = matrix.length - 1;
        int colMin = 0;
        int colMax = matrix[0].length - 1;

        while (rowMin <= rowMax && colMin <= colMax) {
            for (int col = colMin; col <= colMax; col++) {
                res.add(matrix[rowMin][col]);
            }
            rowMin++;
            for (int row = rowMin; row <= rowMax; row++) {
                res.add(matrix[row][colMax]);
            }
            colMax--;
            if (rowMin <= rowMax) {
                for (int col = colMax; col >= colMin; col--) {
                    res.add(matrix[rowMax][col]);
                }
                rowMax--;
            }
            if (colMin <= colMax) {
                for (int row = rowMax; row >= rowMin; row--) {
                    res.add(matrix[row][colMin]);
                }
                colMin++;
            }
        }

        return res;
    }
}
