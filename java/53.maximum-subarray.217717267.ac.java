class Solution {
    public int maxSubArray(int[] nums) {
        if (nums==null || nums.length==0) return 0;
        int[] dp=new int[nums.length];
        int ans=nums[0];

        dp[0]=nums[0];
        for (int i=1; i<nums.length; i++){
            dp[i]=Math.max(dp[i-1], 0)+nums[i];
            ans=Math.max(dp[i], ans);
        }
        return ans;
    }
}

