class Solution {
    public int[] processQueries(int[] queries, int m) {
        LinkedList<Integer> list = new LinkedList<>();
        int[] ans = new int[queries.length];
        
        for (int i = 1; i <= m; i++)
            list.add(i);
        
        for (int i = 0; i < queries.length; i++) {
            int idx = list.indexOf(queries[i]);
            list.remove(idx);
            list.addFirst(queries[i]);
            ans[i] = idx;
        }
        
        return ans;
    }
}
