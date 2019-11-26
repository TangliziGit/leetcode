class Solution {
    
    private Map<Integer, Integer> id;
    private Integer[][] dp;
    private int[] nums;
    
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        this.dp = new Integer[nums.length+5][2];
        this.nums = nums;
        this.id = new HashMap<>();
        
        for (int i = 0; i<nums.length; i++)
            id.put(nums[i], i);
        
        int ans = 0;
        for (int i=0; i<nums.length; i++)
            ans = Math.max(ans, Math.max(solve(i, 0), solve(i, 1)));
        
        return ans;
    }
    
    private int solve(int i, int dir) {
        if (i<0 || i>=nums.length) return 0;
        if (null != dp[i][dir]) return dp[i][dir];
        
        dp[i][dir] = solve(id.getOrDefault(nums[i]+dir*2-1, -1), dir) + 1;
        return dp[i][dir];
    }
}
