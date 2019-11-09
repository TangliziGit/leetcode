class Solution {
    private boolean[][] dp;
    
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) return false;
        this.dp = new boolean[s1.length()+5][s3.length()+5];    
        
        dp[0][0] = true;
        for (int j=1; j<=s3.length(); j++){
            for (int i=0; i<=j && i<=s1.length(); i++){
                dp[i][j] = false;
                if (i!=j && j-i-1<s2.length() && s2.charAt(j-i-1) == s3.charAt(j-1))
                    dp[i][j] |= dp[i][j-1];
                if (i-1>=0 && s1.charAt(i-1) == s3.charAt(j-1))
                    dp[i][j] |= dp[i-1][j-1];
            }
        }
        
        return dp[s1.length()][s3.length()];
    }
}
