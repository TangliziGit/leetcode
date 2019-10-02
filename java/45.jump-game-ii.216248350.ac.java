// O(n*sum(nums))
//      dp[i]=min(dp[j])+1
// O(n)
//      farest pointer

class Solution {
    public int jump(int[] nums) {
        int ptr=0, r=0, ans=0;
        for (int i=0; i<nums.length-1; i++){
            ptr=Math.max(ptr, i+nums[i]);
            if (i==r){
                ans++;
                r=ptr;
            }
        }return ans;
    }
}
