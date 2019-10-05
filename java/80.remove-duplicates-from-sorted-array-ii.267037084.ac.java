class Solution {
    public int removeDuplicates(int[] nums){
        int ptr=0;
        for (int x: nums)
            if (ptr < 2 || nums[ptr-2]!=x)
                nums[ptr++]=x;
        return ptr;
    }
    
// version 1
// it's ugly :(
//     public int removeDuplicates(int[] nums) {
//         if (nums == null || nums.length == 0) return 0;
//         int cnt=0, pre=nums[0], ptr=0;
//         for (int i=0; i<nums.length; i++){
//             if (pre!=nums[i]) {cnt=1; pre=nums[i];}
//             else cnt++;
            
//             if (cnt>2){
//                 while (i<nums.length && pre==nums[i]) i++;
//                 if (i==nums.length) break;
//                 cnt=1; pre=nums[i];
//             }
//             nums[ptr++]=nums[i];
//         }
//         return ptr;
//     }
}
