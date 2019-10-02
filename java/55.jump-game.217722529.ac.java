class Solution {
    public boolean canJump(int[] nums) {
        if (nums.length<=1) return true;
        int ans=0, pos=0, mostFar=0;

        for (int i=0; i<nums.length; i++){
            mostFar=Math.max(mostFar, i+nums[i]);

            if (i==pos){
                if (mostFar>=nums.length-1) break;
                if (i==mostFar) return false;
                ans++; pos=mostFar;
            }
        }return true;
    }
}

