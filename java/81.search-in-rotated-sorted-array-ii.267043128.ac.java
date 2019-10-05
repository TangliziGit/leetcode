class Solution {
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return false;
        int peek = findPeekIndex(nums);
        return binarySearch(nums, (peek+1)%nums.length, target);
    }
    
    private int findPeekIndex(int[] nums){
        int l=0, r=nums.length-1;
        while (l<r){
            int ll=l+(r-l)/3, rr=l+2*(r-l)/3;
            if (nums[ll]<nums[rr]) l=ll+1;
            else r=rr-1;
        }
        
        int mod=nums.length;
        for (int i=l; i!=(l-1+mod)%mod; i=(i+1)%mod)
            if (nums[(i+mod-1)%mod]<=nums[i] && nums[i]>nums[(i+1)%mod]) return i;
        return 0;
    }
    
    private boolean binarySearch(int[] nums, int low, int tar){
        System.out.println(low);
        int mod=nums.length, l=0, r=nums.length-1;
        while (l<r){
            int mid=(r+l)/2;
            if (nums[(mid+low)%mod]<tar) l=mid+1;
            else r=mid-1;
        }
        
        System.out.println(l+" "+r);
        
        for (int i=Math.max(0, l-2); i<=Math.min(r+2, nums.length-1); i++)
            if (nums[(i+low)%mod]==tar) return true;
        return false;
    }
}
