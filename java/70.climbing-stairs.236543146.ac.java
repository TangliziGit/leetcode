class Solution {
    private int[] dp;
    public int climbStairs(int n) {
        dp=new int[n+1];
        return solve(n);
    }
    
    private int solve(int x){
        if (x==0) return 1;
        if (x<0) return 0;
        if (dp[x]!=0) return dp[x];
        return dp[x]=solve(x-1)+solve(x-2);
    }
}
