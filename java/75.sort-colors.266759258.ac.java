class Solution {
    private int[] cnt=new int[3];
    public void sortColors(int[] nums) {
        cnt[0]=cnt[1]=cnt[2]=0;
        for (int i=0; i<nums.length; i++)
            cnt[nums[i]]++;
        
        int[] idx=new int[3];
        idx[0]=0;
        idx[1]=cnt[0];
        idx[2]=cnt[0]+cnt[1];
        for (int i=0; i<nums.length; i++)
            while (nums[i]!=kind(i)){
                int tmp=nums[i], ij=idx[nums[i]];
                nums[i]=nums[ij];
                nums[ij]=tmp;
                
                idx[tmp]++;
            }
    }
    
    private int kind(int i){
        if (i<cnt[0]) return 0;
        if (i<cnt[0]+cnt[1]) return 1;
        return 2;
    }
}
