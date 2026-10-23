class Solution {
    public void setZeroes(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        Set<Integer> rowMarked = new HashSet<>();
        Set<Integer> colMarked = new HashSet<>();
        for(int i = 0 ; i < matrix.length ; i++) {
            for(int j = 0 ; j < matrix[0].length; j++) {
                if(matrix[i][j] == 0) {
                    rowMarked.add(i);
                    colMarked.add(j);
                }
            }
        }

        for(int i = 0 ; i < matrix.length; i++) {
            for(int j = 0 ; j < matrix[0].length; j++) {
                if(rowMarked.contains(i) || colMarked.contains(j)) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
