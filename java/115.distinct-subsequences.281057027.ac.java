class Solution {
    
    private Integer[][] dp;
    private String s, t;
    
    public int numDistinct(String s, String t) {
        this.dp = new Integer[s.length()+5][t.length()+5];
        this.s = s;
        this.t = t;
        
        return solve(s.length(), t.length());
    }
    
    private int solve(int i, int j) {
        if (i>=0 && j==0) return 1;
        if (i<=0 || j<=0) return 0;
        if (null != dp[i][j]) return dp[i][j];
    
        dp[i][j] = 0;
        if (s.charAt(i-1) == t.charAt(j-1)) dp[i][j] += solve(i-1, j-1);
        dp[i][j] += solve(i-1, j);
        
        return dp[i][j];
    }
}
