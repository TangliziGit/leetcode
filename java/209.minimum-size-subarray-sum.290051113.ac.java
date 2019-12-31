class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums.length == 0) return 0;
        int left = 0, right = 0;
        int sum = nums[left], ans = nums.length + 1;
        
        while (left <= right && right < nums.length) {
            while (sum < s && right + 1 < nums.length) sum += nums[++right];
            while (sum - nums[left] >= s && left < right) sum -= nums[left++];
            if (sum >= s) ans = Math.min(ans, right - left + 1);
            // System.out.println(String.format("%d %d, %d", sum, left, right));
            
            if (right == nums.length - 1) break;
            sum += nums[++right];
        }
        return (ans==nums.length+1)?0:ans;
    }
}
