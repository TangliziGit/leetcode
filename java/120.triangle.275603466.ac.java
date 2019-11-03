class Solution {
    private List<List<Integer>> tri;
    private Integer[][] dp;
    
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) return 0;
        
        this.tri = triangle;
        this.dp = new Integer[tri.size()][tri.size()];
        return solve(0, 0);
    }
    
    private int solve(int x, int y){
        if (tri.size() == y) return 0;
        if (dp[y][x] != null) return dp[y][x];
        
        return dp[y][x] = Math.min(solve(x, y+1), solve(x+1, y+1)) + tri.get(y).get(x);
    }
}
