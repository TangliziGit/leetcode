class Solution {
    public int numDecodings(String s) {
        if (s.length()==0 || s.charAt(0)=='0' || s.contains("00")) return 0;
        int[] dp = new int[s.length()+5];
        
        dp[0]=dp[1]=1;
        for (int i=1; i<s.length(); i++){
            dp[i+1]=0;
            if (s.charAt(i-1)=='1' || (s.charAt(i-1)=='2' && s.charAt(i)<='6'))
                dp[i+1]+=dp[i-2+1];
            if (s.charAt(i)!='0')
                dp[i+1]+=dp[i-1+1];
        }
        return dp[s.length()];
    }
}
