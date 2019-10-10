class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Set<List<Integer>> ans=new HashSet<>();
        
        for (int s=0; s<(1<<nums.length); s++){
            List<Integer> list=new ArrayList<>();
            for (int i=0; (1<<i)<=s; i++) if ((s & (1<<i))!=0)
                list.add(nums[i]);
            list.sort((Integer x, Integer y) -> x.compareTo(y));
            ans.add(list);
        }
        return new LinkedList(ans);
    }
}
