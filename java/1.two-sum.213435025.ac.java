class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map=new HashMap();
        
        for (int i=0; i<nums.length; i++){
            int tmp=target-nums[i];
            if (map.containsKey(tmp)){
                int idx=map.get(tmp);
                if (i!=idx) return new int[]{idx, i};
            }map.put(nums[i], i);
        }
        throw new IllegalArgumentException();
    }
}
