class Solution {
    private List<List<Integer>> ans;
    private int[] nums;
    
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        this.ans=new LinkedList<>();
        
        Arrays.sort(nums);
        this.nums=nums;
        solve(0, new LinkedList<>());
        return ans;
    }
    
    private void solve(int idx, List<Integer> path){
        ans.add(path);
        for (int i=idx; i<nums.length; i++){
            if (i>idx && nums[i]==nums[i-1]) continue;
            List<Integer> newPath = new LinkedList(path);
            newPath.add(nums[i]);
            solve(i+1, newPath);
            // path.removeLast(); // can not do this! the pointer is not changed
        }
    }
}
