class Solution {
    public int longestValidParentheses(String s) {
        if (s==null || s.length()==0) return 0;
        int[] dp=new int[s.length()];
        int ans=0, slen=s.length();
        
        dp[slen-1]=0;
        for (int i=slen-2; i>=0; i--){
            if (s.charAt(i)==')') dp[i]=0;
            else if (dp[i+1]+i+1<slen && s.charAt(dp[i+1]+i+1)==')'){
                dp[i]=dp[i+1]+2;
                if (dp[i+1]+i+2<slen)
                    dp[i]+=dp[dp[i+1]+i+2];
            }else dp[i]=0;
            ans=Math.max(ans, dp[i]);
        }return ans;
    }
}
