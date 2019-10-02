class Solution {
    public int search(int[] nums, int target) {
        if (nums.length==0) return -1;
        
        int pivot=searchPivot(nums);
        if (nums[0]<=target)
            return Math.max(-1, Arrays.binarySearch(nums, 0, pivot+1, target));
        return  Math.max(-1, Arrays.binarySearch(nums, pivot+1, nums.length, target));
    }
    
    private int searchPivot(int[] nums){
        int l=0, r=nums.length-1;
        while (r-l>2){
            int mid=l+(r-l)/2;
            if (nums[mid]<nums[l]) r=mid-1;
            else l=mid;
        }
        for (int i=Math.max(0, l-1); i<Math.min(nums.length, r+1); i++)
            if (nums[i]>nums[(i+1)%nums.length]
                && nums[i]>nums[(i-1+nums.length)%nums.length])
                return i;
        return 0;
    }
}
