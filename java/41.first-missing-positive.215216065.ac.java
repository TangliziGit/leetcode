class Solution {
    public int firstMissingPositive(int[] nums) {
        if (nums==null || nums.length==0) return 1; 
        for (int i=0; i<nums.length; i++){
            while (nums[i]>=0
                   && nums[i]<nums.length
                   && nums[i]!=i
                   && nums[nums[i]]!=nums[i])
                swap(nums, i, nums[i]);
        }
        
        int ans=0;
        for (int i=1; i<nums.length; i++)
            if (nums[i]!=i) return i;
        if (nums[0]==nums.length) return nums.length+1;
        return nums.length;
    }
    
    private void swap(int[] nums, int i, int j){
        int tmp=nums[i];
        nums[i]=nums[j];
        nums[j]=tmp;
    }
}
