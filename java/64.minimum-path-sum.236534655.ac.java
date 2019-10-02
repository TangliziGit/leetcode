class Solution {
    private int[][] dp;
    private final int INF=0x3f3f3f3f;
    public int minPathSum(int[][] grid) {
        dp=new int[grid.length][];
        for (int i=0; i<dp.length; i++){
            dp[i]=new int[grid[0].length];
            for (int j=0; j<dp[i].length; j++) dp[i][j]=-1;
        }
        return dfs(grid, 0, 0);
    }
    
    public int dfs(int[][] grid, int x, int y){
        if (x>=grid[0].length || y>=grid.length) return INF;
        if (dp[y][x]!=-1) return dp[y][x];
        if (x==grid[0].length-1 && y==grid.length-1) return grid[y][x];
        return dp[y][x]=Math.min(dfs(grid, x+1, y), dfs(grid, x, y+1))+grid[y][x];
    }
}
