class Solution {
    private String s, p;
    private Boolean[][] dp;
    
    public boolean isMatch(String s, String p) {
        this.s = s;
        this.p = p;
        this.dp = new Boolean[s.length()+5][p.length()+5];
        
        return solve(0, 0);
    }
    
    private boolean solve(int i, int j) {
        if (i >= s.length() && j == p.length()) return true;
        if (i > s.length() || j >= p.length()) return false;
        if (null != dp[i][j]) return dp[i][j];
        
        dp[i][j] = false;
        if (i<s.length() && s.charAt(i) == p.charAt(j)) dp[i][j] |= solve(i+1, j+1);
        if (p.charAt(j) == '*') dp[i][j] |= solve(i, j+1) || solve(i+1, j);
        if (i<s.length() && p.charAt(j) == '?') dp[i][j] |= solve(i+1, j+1);
        return dp[i][j];
    }
}
