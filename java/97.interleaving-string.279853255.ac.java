class Solution {
    private boolean[] dp;
    
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) return false;
        this.dp = new boolean[s1.length()+5];    
        
        dp[0] = true;
        for (int j=1; j<=s3.length(); j++){
            for (int i=Math.min(j, s1.length()); i>=0; i--){
                boolean tmp = false;
                if (i!=j && j-i-1<s2.length() && s2.charAt(j-i-1) == s3.charAt(j-1))
                    tmp |= dp[i];
                if (i-1>=0 && s1.charAt(i-1) == s3.charAt(j-1))
                    tmp |= dp[i-1];
                dp[i] = tmp;
            }
        }
        
        return dp[s1.length()];
    }
}
