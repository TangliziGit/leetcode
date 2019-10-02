// 1. O(n^2+nlogn) with big constant:
//      map+set

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n=nums.length, size=0;
        int[] pre=new int[n*(n-1)/2];
        int[] pos=new int[n*(n-1)/2];
        Map<Integer, List<Integer>> map=new HashMap();
        Set<List<Integer>> set=new HashSet();
        LinkedList<List<Integer>> ans=new LinkedList();
        
        for (int i=0; i<n; i++)
            for (int j=i+1; j<n; j++){
                int sum=nums[i]+nums[j];
                pre[size]=i;
                pos[size++]=j;
                
                if (!map.containsKey(sum))
                    map.put(sum, new LinkedList());
                map.get(sum).add(size-1);
            }
        
        for (int i=0; i<n; i++)
            for (int j=i+1; j<n; j++){
                int rest=target-nums[i]-nums[j];
                if (!map.containsKey(rest)) continue;
                for (Integer ptr: map.get(rest))
                    if (i!=pre[ptr] && i!=pos[ptr] &&
                        j!=pre[ptr] && j!=pos[ptr]){
                        int[] l={nums[i], nums[j], nums[pre[ptr]], nums[pos[ptr]]};
                        Arrays.sort(l);
                        set.add(Arrays
                                .stream(l)
                                .boxed()
                                .collect(Collectors.toList()));
                    }
            }
        
        
        for (List<Integer> list: set)
            ans.add(list);
        
        return ans;
    }
}
