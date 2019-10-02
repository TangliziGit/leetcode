class Solution {
    private List<List<Integer>> ans;
    private int[] nums;
    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        // when nums == [0, 1] and target == 1?
        this.ans=new LinkedList(); // HashSet();
        this.nums=nums;
        
        Arrays.sort(nums);
        solve(0, target, new LinkedList<Integer>());
        // return new LinkedList(ans);
        return ans;
    }
    
    private void solve(int idx, int rest, LinkedList<Integer> list){
        if (rest==0){
            ans.add((LinkedList<Integer>)list.clone());
            return;
        }
        
        for (int i=idx; i<nums.length; i++){
            if (nums[i]>rest) break;
            if (i>idx && nums[i]==nums[i-1]) continue;
            
            list.addLast(nums[i]);
            solve(i+1, rest-nums[i], list);
            list.removeLast();
        }
    }
}
