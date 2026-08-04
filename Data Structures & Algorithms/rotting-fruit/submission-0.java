class Solution {
    public static class Pair {
        int i,j,l;
        Pair(int i,int j,int l) {
            this.i = i;
            this.j = j;
            this.l = l;
        }
    }
    public static int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        Queue<Pair> q = new ArrayDeque<>();
        int result = 0;
        for(int i = 0 ; i < m; i++) {
            for(int j = 0 ; j < n ; j++) {
                if(grid[i][j] == 2) {
                    q.add(new Pair(i,j,0));
                }
            }
        }
        while(!q.isEmpty()) {
            Pair temp = q.remove();
            if(!visited[temp.i][temp.j]) {
                result = Integer.max(result, temp.l);
                visited[temp.i][temp.j] = true;
                if (temp.i - 1 > -1 && grid[temp.i - 1][temp.j] == 1 && !visited[temp.i - 1][temp.j])
                    q.add(new Pair(temp.i - 1, temp.j, temp.l + 1));
                if (temp.j - 1 > -1 && grid[temp.i][temp.j - 1] == 1 && !visited[temp.i][temp.j - 1])
                    q.add(new Pair(temp.i, temp.j - 1, temp.l + 1));
                if (temp.j + 1 < n && grid[temp.i][temp.j + 1] == 1 && !visited[temp.i][temp.j + 1])
                    q.add(new Pair(temp.i, temp.j + 1, temp.l + 1));
                if (temp.i + 1 < m && grid[temp.i + 1][temp.j] == 1 && !visited[temp.i + 1][temp.j])
                    q.add(new Pair(temp.i + 1, temp.j, temp.l + 1));
            }
        }
        for(int i = 0 ; i < m; i++) {
            for(int j = 0 ; j < n; j++) {
                if(grid[i][j] == 1 && !visited[i][j]) {
                    return -1;
                }
            }
        }
        return result;
    }
}
