class Solution {
    public class Pair {
        public int a,b,l;
        Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }
    
    public int maxAreaOfIsland(int[][] grid) {
        Stack<Pair> s = new Stack<>();
        int result = 0;
        for(int i = 0 ; i < grid.length; i++) {
            for(int j = 0 ; j < grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    s.push(new Pair(i,j));
                    grid[i][j] = 0;
                    int count = 1;
                    while(!s.empty()) {
                        Pair temp = s.pop();
                        if(temp.a - 1 > 0 && grid[temp.a-1][temp.b] == 1) {
                            s.push(new Pair(temp.a-1, temp.b));
                            grid[temp.a-1][temp.b] = 0;
                            count++;
                        }
                        if(temp.b - 1 > 0 && grid[temp.a][temp.b-1] == 1) {
                            s.push(new Pair(temp.a, temp.b-1));
                            grid[temp.a][temp.b-1] = 0;
                            count++;
                        }
                        if(temp.b + 1 < grid[temp.a].length && grid[temp.a][temp.b+1] == 1) {
                            s.push(new Pair(temp.a, temp.b+1));
                            grid[temp.a][temp.b+1] = 0;
                            count++;
                        }
                        if(temp.a + 1 < grid.length && grid[temp.a+1][temp.b] == 1) {
                            s.push(new Pair(temp.a+1, temp.b));
                            grid[temp.a+1][temp.b] = 0;
                            count++;
                        }
                    }
                    result = Integer.max(result,count);
                }
            }
        }
        return result;
    }
}
