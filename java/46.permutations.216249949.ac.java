class Solution {
    private List<List<Integer>> ans;
    private int[] nums;
    private boolean[] vis;
    public List<List<Integer>> permute(int[] nums) {
        this.ans=new LinkedList();
        this.nums=nums;
        this.vis=new boolean[nums.length];
        solve(new LinkedList<Integer>(), 0);
        return ans;
    }
    
    private void solve(LinkedList<Integer> path, int dep){
        if (dep==nums.length){
            ans.add((LinkedList<Integer>)path.clone());
            return;
        }
        
        for (int i=0; i<nums.length; i++){
            if (vis[i]) continue;
            vis[i]=true;
            path.offerLast(nums[i]);
            solve(path, dep+1);
            vis[i]=false;
            path.pollLast();
        }
    }
}
