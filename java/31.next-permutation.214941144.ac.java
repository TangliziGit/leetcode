class Solution {
    public void nextPermutation(int[] nums) {
        if (nums.length<2) return;
        int idx=nums.length-2;
        while (idx>=0 && nums[idx]>=nums[idx+1]) idx--;
        
        if (idx>=0){
            int pos=idx+1;
            while (pos+1<nums.length && nums[pos+1]>nums[idx]) pos++;
            swap(nums, idx, pos);
        }
        
        for (int i=0; i+idx+1<nums.length-i-1; i++){
            swap(nums, i+idx+1, nums.length-i-1);
        }
    }
    
    private void swap(int[] nums, int i, int j){
        int tmp=nums[i];
        nums[i]=nums[j];
        nums[j]=tmp;
    }
}
