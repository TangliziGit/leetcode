class Solution {
    
    private static final List<Integer> empty = new ArrayList<>();
    
    public int[] findOrder(int numCourses, int[][] pre) {
        Map<Integer, List<Integer>> edges = new HashMap<>();
        int[] in = new int[numCourses];
        
        for (int i = 0 ; i < pre.length; i++) {
            edges.computeIfAbsent(pre[i][1], x -> new LinkedList());
            edges.get(pre[i][1]).add(pre[i][0]);
            in[pre[i][0]]++;
        }
        
        return sort(in, edges);
    }
    
    private int[] sort(int[] in, Map<Integer, List<Integer>> edges) {
        int[] ans = new int[in.length];
        int[] sta = new int[in.length];
        int cnt = 0, total = 0;
        
        for (int i = 0; i < in.length; i++)
            if (in[i]==0) sta[cnt++] = i;
        
        while (cnt != 0){
            int x = sta[--cnt];
            ans[total++] = x;

            for (Integer next: edges.getOrDefault(x, empty))
                if (--in[next] == 0) sta[cnt++] = next;
        }
        
        if (total == in.length) return ans;
        return new int[0];
    }
}
