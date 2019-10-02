class Solution {
    private List<List<Integer>> ans;
    private int[] nums;
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        // when nums == [0, 1] and target == 1?
        this.ans=new LinkedList();
        this.nums=nums;
        
        Arrays.sort(nums);
        solve(0, target, new LinkedList<Integer>());
        return ans;
    }
    
    private void solve(int idx, int rest, LinkedList<Integer> list){
        if (rest==0){
            ans.add((LinkedList<Integer>)list.clone());
            return;
        }
        
        for (int i=idx; i<nums.length; i++){
            if (nums[i]>rest) break;
            
            list.addLast(nums[i]);
            solve(i, rest-nums[i], list);
            list.removeLast();
        }
    }
}
