class Solution {
    public boolean isValid(char[][] board, int rS, int cS, int rE, int cE) {
        int[] map = new int[10];
        for(int i = 0 ; i < 10; i++) map[i] = 0;
        for(int i = rS ; i <= rE ; i++) {
            for(int j = cS ; j <= cE ; j++) {
                if(board[i][j] > '0' && board[i][j] <= '9') {
                    if(map[board[i][j]-'0'] == 1) {
                        return false;
                    } else {
                        map[board[i][j]-'0'] = 1;
                    }
                }
            }
        }
        return true;
    }
    public boolean isValidSudoku(char[][] board) {
        // row checks
        for(int i = 0 ; i < 9 ; i ++) {
            boolean res = isValid(board, i, 0, i, 8);
            if(!res) return false;
        }
        // column checks
        for(int i = 0 ; i < 9 ; i ++) {
            boolean res = isValid(board, 0, i, 8, i);
            if(!res) return false;
        }
        // 3x3 checks
        for(int i = 0 ; i < 9 ; i+=3) {
            for(int j = 0 ; j < 9; j+=3) {
                if(i+2 < 9 && j+2 < 9) {
                    boolean res = isValid(board, i, j, i + 2, j + 2);
                    if (!res) return false;
                }
            }
        }
        return true;
    }
}
