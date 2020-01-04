class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        if (nums.length == 0) return 0;
        int ans = 0;
        ans = Math.max(ans, solve(nums, 1, nums.length-2));
        ans = Math.max(ans, solve(nums, 0, nums.length-2));
        ans = Math.max(ans, solve(nums, 1, nums.length-1));
        return ans;
    }
    
    private int solve(int[] nums, int start, int n) {
        // int[] dp = new int[n-start];
        int ans = 0, first = 0, second = 0;
        
        for (int i=n; i>=start; i--) {
            // dp[i] = max(dp[i+2]+nums[i], dp[i+1]);
            ans = Math.max(second+nums[i], first);
            second = first;
            first = ans;
        }
        return ans;
    }
}
