class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i=0; i<nums.length; i++) {
            int x = nums[i];
            if (map.containsKey(x) && i - map.get(x) <= k)
                return true;
            map.put(x, i);
        }
        
        return false;
    }
}
