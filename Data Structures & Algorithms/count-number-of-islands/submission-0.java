class Solution {
    public void visit(boolean[][] visited, int i , int j,char[][] grid) {
        if(i >= visited.length || i < 0 || j < 0 || j >= visited[i].length) return;
        if(visited[i][j]) return;
        else if(grid[i][j] == '0') return;
        else {
            visited[i][j] = true;
            visit(visited, i-1,j,grid);
            visit(visited, i,j-1,grid);
            visit(visited, i,j+1,grid);
            visit(visited, i+1,j,grid);
        }
    }

    public int numIslands(char[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int result = 0;
        for(int i = 0 ; i < grid.length; i++) {
            for(int j = 0 ; j < grid[i].length ; j++) {
                if(grid[i][j] == '1' && !visited[i][j]) {
                    result++;
                    visit(visited,i,j, grid);
                }
            }
        }
        return result;
    }
}
